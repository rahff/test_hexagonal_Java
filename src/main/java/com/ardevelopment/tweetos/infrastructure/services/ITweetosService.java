package com.ardevelopment.tweetos.infrastructure.services;

import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetosRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;

public interface ITweetosService {

    TweetosDto createTweetosHandler(CreateTweetosRequestDto dto);
}
