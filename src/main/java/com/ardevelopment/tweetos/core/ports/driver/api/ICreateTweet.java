package com.ardevelopment.tweetos.core.ports.driver.api;

import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;

public interface ICreateTweet {
    TweetDto execute(CreateTweetRequestDto data);
}
