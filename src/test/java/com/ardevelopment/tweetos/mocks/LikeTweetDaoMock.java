package com.ardevelopment.tweetos.mocks;


import com.ardevelopment.tweetos.core.ports.driven.dao.ILikeTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;

public class LikeTweetDaoMock  implements ILikeTweetDao {

    @Override
    public boolean isTweetExist(String tweetId) {
        return tweetId.equals("existingTweetId");
    }

    @Override
    public TweetDto addLikeOnTweet(String tweetId) {
        return new TweetDto(tweetId, "hello", new TweetosDto("123456789123", "Elon Musk", "elonmusk@gmail.com"), 1);
    }
}
