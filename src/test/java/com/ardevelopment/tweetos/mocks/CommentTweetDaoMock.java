package com.ardevelopment.tweetos.mocks;

import com.ardevelopment.tweetos.core.ports.driven.dao.ICommentTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;


public class CommentTweetDaoMock implements ICommentTweetDao {
    @Override
    public boolean isTweetExist(String tweetId) {
        return tweetId.equals("existingTweetId");
    }

    @Override
    public TweetosDto isTweetosExist(String tweetosId) {
        if(tweetosId.equals("existingTweetosId")){
            return new TweetosDto("existingTweetosId", "Elon Musk", "elonmusk@gmail.com");
        };
        return null;
    }

    @Override
    public CommentDto saveComment(CommentDto data) {
        return new CommentDto(data.get_id(), data.getContent(), data.getTweetRef(), data.getAuthorUsername(), data.getAuthorId());
    }
}
