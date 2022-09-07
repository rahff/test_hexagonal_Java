package com.ardevelopment.tweetos.core.ports.driven.dao;


import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;

public interface ICreateTweetosDao {
    boolean isExistingWithSameEmail(String email);
    TweetosDto saveTweetos(TweetosDto data, String password);
}
