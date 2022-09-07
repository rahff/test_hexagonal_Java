package com.ardevelopment.tweetos.core.features;

import com.ardevelopment.tweetos.core.entities.Tweet;
import com.ardevelopment.tweetos.core.exceptions.TweetosNotFoundException;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.api.ICreateTweet;
import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.core.valueObjects.EntityId;
import com.ardevelopment.tweetos.core.valueObjects.TweetContent;


import java.util.UUID;

public class CreateTweet implements ICreateTweet {

    private ICreateTweetDao repository;
    public CreateTweet(ICreateTweetDao repository){
        this.repository = repository;
    }

    @Override
    public TweetDto execute(CreateTweetRequestDto data) {
        try{
            String _id = UUID.randomUUID().toString();
            TweetosDto foundedTweetos = repository.getTweetosTweet(data.getTweetosId());
            if(foundedTweetos == null) throw new TweetosNotFoundException();
            Tweet newTweet = new Tweet(new TweetContent(data.getContent()), new EntityId(_id), foundedTweetos);
            TweetDto savedTweet = repository.saveTweet(newTweet.asDto());
            return  savedTweet;
        }catch (RuntimeException e){
            throw e;
        }
    }
}
