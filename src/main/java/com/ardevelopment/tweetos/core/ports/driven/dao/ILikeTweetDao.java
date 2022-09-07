package com.ardevelopment.tweetos.core.ports.driven.dao;

import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;

public interface ILikeTweetDao {
    boolean isTweetExist(String tweetId);
    TweetDto addLikeOnTweet(String tweetId);
}
