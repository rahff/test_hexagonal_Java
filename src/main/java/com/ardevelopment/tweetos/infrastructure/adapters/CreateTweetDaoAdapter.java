package com.ardevelopment.tweetos.infrastructure.adapters;

import com.ardevelopment.tweetos.core.exceptions.TweetNotFoundException;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.infrastructure.exceptions.SaveEntityFailedException;
import com.ardevelopment.tweetos.infrastructure.models.TweetModel;
import com.ardevelopment.tweetos.infrastructure.models.TweetosModel;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreateTweetDaoAdapter implements ICreateTweetDao {

    private MongoTemplate mongo;

    public CreateTweetDaoAdapter(MongoTemplate mongo) {
        this.mongo = mongo;
    }

    public TweetosDto getTweetosTweet(String tweetosId) {
        var foundedTweetos = mongo.findById(tweetosId, TweetosModel.class, "Tweetos");
        if(foundedTweetos == null) return null;
        return new TweetosDto(foundedTweetos._id, foundedTweetos.username, foundedTweetos.email);
    }


    public TweetDto saveTweet(TweetDto data) {
        var savedTweet = mongo.save(new TweetModel(data.get_id(), data.getContent(), data.getTweetos(), 0), "Tweet");
        if(savedTweet == null) throw new SaveEntityFailedException();
        return new TweetDto(savedTweet._id, savedTweet.content, savedTweet.tweetos, savedTweet.likes);
    }
}
