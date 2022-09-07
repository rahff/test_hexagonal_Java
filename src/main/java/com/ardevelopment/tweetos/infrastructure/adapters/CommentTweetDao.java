package com.ardevelopment.tweetos.infrastructure.adapters;

import com.ardevelopment.tweetos.core.ports.driven.dao.ICommentTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.infrastructure.exceptions.SaveEntityFailedException;
import com.ardevelopment.tweetos.infrastructure.models.CommentModel;
import com.ardevelopment.tweetos.infrastructure.models.TweetModel;
import com.ardevelopment.tweetos.infrastructure.models.TweetosModel;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class CommentTweetDao implements ICommentTweetDao {

    private MongoTemplate mongo;

    public CommentTweetDao(MongoTemplate mongo){
        this.mongo = mongo;
    }

    public boolean isTweetExist(String tweetId) {
        Query query = new Query(Criteria.where("_id").is(tweetId));
        return mongo.exists(query, "Tweet");
    }

    public TweetosDto isTweetosExist(String tweetosId) {
        var foundedTweetos = mongo.findById(tweetosId, TweetosModel.class, "Tweetos");
        if(foundedTweetos == null) return null;
        return new TweetosDto(foundedTweetos._id, foundedTweetos.username, foundedTweetos.email);
    }

    public CommentDto saveComment(CommentDto data) {
        CommentModel comment = new CommentModel(data.get_id(), data.getContent(), data.getTweetRef(), data.getAuthorId(), data.getAuthorUsername());
        var savedComment = (CommentModel) mongo.save(comment, "Comment");
        if(savedComment == null) throw new SaveEntityFailedException();
        return new CommentDto(savedComment._id, savedComment.content, savedComment.tweetRef, savedComment.tweetosName, savedComment.tweetosRef);
    }
}
