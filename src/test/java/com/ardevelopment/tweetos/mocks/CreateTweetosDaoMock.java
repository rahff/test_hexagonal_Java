package com.ardevelopment.tweetos.mocks;


import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetosDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;

public class CreateTweetosDaoMock implements ICreateTweetosDao {
    @Override
    public boolean isExistingWithSameEmail(String email) {
        return email.equals("existingmail@gmail.com");
    }

    @Override
    public TweetosDto saveTweetos(TweetosDto data, String password) {
        return new TweetosDto(data.get_id(), data.getUsername(), data.getEmail());
    }
}
