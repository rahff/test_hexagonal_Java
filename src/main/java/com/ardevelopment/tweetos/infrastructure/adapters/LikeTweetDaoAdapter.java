package com.ardevelopment.tweetos.infrastructure.adapters;

import com.ardevelopment.tweetos.core.ports.driven.dao.ILikeTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.infrastructure.models.TweetModel;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class LikeTweetDaoAdapter implements ILikeTweetDao {

    private MongoTemplate mongo;
    public LikeTweetDaoAdapter(MongoTemplate mongo) {
        this.mongo = mongo;
    }

    public boolean isTweetExist(String tweetId) {
        Query query = new Query(Criteria.where("_id").is(tweetId));
        return mongo.exists(query, "Tweet");
    }

    public TweetDto addLikeOnTweet(String tweetId) {
        Query query = new Query(Criteria.where("_id").is(tweetId));
        Update update = new Update().inc("likes", 1);
        var likedTweet = mongo.findAndModify(query, update, TweetModel.class, "Tweet");
        return new TweetDto(likedTweet._id, likedTweet.content, likedTweet.tweetos, ++likedTweet.likes);
    }
}
