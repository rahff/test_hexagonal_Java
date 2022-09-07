package com.ardevelopment.tweetos.core.ports.driver.api;

import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetosRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;

public interface ICreateTweetos {
    TweetosDto execute(CreateTweetosRequestDto data);
}
