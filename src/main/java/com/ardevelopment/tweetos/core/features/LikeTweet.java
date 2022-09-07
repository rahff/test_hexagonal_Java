package com.ardevelopment.tweetos.core.features;

import com.ardevelopment.tweetos.core.exceptions.TweetNotFoundException;
import com.ardevelopment.tweetos.core.ports.driven.dao.ILikeTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.api.ILikeTweet;
import com.ardevelopment.tweetos.core.ports.driver.dto.LikeTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;

public class LikeTweet implements ILikeTweet {

    private ILikeTweetDao repository;
    public LikeTweet(ILikeTweetDao repository){
    this.repository = repository;
    }

    @Override
    public int execute(LikeTweetRequestDto data) {
        boolean isTweetExist = repository.isTweetExist(data.getTweetedTweetId());
        if(!isTweetExist) throw new TweetNotFoundException();
        return repository.addLikeOnTweet(data.getTweetedTweetId()).getLikes();
    }
}
