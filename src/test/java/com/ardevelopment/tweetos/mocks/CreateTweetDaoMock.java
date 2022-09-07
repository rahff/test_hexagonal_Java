package com.ardevelopment.tweetos.mocks;


import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;

public class CreateTweetDaoMock implements ICreateTweetDao {
    @Override
    public TweetosDto getTweetosTweet(String tweetosId) {
        if(tweetosId.equals("existingTweetosId")){
            return new TweetosDto("existingTweetosId", "Elon Musk", "elonmusk@gmail.com");
        }
        return null;
    }

    @Override
    public TweetDto saveTweet(TweetDto data) {
        return new TweetDto(data.get_id(), data.getContent(), data.getTweetos(), data.getLikes());
    }
}
