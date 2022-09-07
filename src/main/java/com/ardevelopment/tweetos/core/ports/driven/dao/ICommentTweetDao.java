package com.ardevelopment.tweetos.core.ports.driven.dao;

import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;

public interface ICommentTweetDao {

    boolean isTweetExist(String tweetId);
    TweetosDto isTweetosExist(String tweetosId);
    CommentDto saveComment(CommentDto data);
}
