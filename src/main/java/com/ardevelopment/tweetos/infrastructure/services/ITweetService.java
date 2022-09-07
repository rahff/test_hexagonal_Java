package com.ardevelopment.tweetos.infrastructure.services;

import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.LikeTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;

public interface ITweetService {
    TweetDto createTweetHandler(CreateTweetRequestDto dto);
    int likeTweetHandler(LikeTweetRequestDto dto);
}
