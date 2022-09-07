package com.ardevelopment.tweetos.core.ports.driver.api;

import com.ardevelopment.tweetos.core.ports.driver.dto.LikeTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;

public interface ILikeTweet {

    int execute(LikeTweetRequestDto data);
}
