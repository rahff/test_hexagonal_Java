package com.ardevelopment.tweetos.core.features;

import com.ardevelopment.tweetos.core.entities.Comment;
import com.ardevelopment.tweetos.core.exceptions.TweetNotFoundException;
import com.ardevelopment.tweetos.core.exceptions.TweetosNotFoundException;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICommentTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.api.ICommentTweet;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.core.valueObjects.CommentContent;
import com.ardevelopment.tweetos.core.valueObjects.EntityId;

import java.util.UUID;

public class CommentTweet implements ICommentTweet {

    private ICommentTweetDao repository;

    public CommentTweet(ICommentTweetDao repository) {
        this.repository = repository;
    }

    @Override
    public CommentDto execute(CommentTweetRequestDto data) {
        try{
            String _id = UUID.randomUUID().toString();
            boolean isTweetExist = repository.isTweetExist(data.getTweetRef());
            if(!isTweetExist) throw  new TweetNotFoundException();
            TweetosDto tweetosAuthor = repository.isTweetosExist(data.getTweetosRef());
            if(tweetosAuthor == null) throw new TweetosNotFoundException();
            var comment = new Comment(new EntityId(_id), new CommentContent(data.getContent()), data.getTweetRef(), tweetosAuthor.getUsername(), tweetosAuthor.get_id());
            return repository.saveComment(comment.asDto(tweetosAuthor.get_id()));
        }catch (RuntimeException e){
            throw  e;
        }
    }
}
