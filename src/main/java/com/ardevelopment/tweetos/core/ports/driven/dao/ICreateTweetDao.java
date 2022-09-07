package com.ardevelopment.tweetos.core.ports.driven.dao;

import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;

public interface ICreateTweetDao {
    TweetosDto getTweetosTweet(String tweetosId);
    TweetDto saveTweet(TweetDto data);
}
