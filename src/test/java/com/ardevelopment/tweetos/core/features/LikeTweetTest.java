package com.ardevelopment.tweetos.core.features;


import com.ardevelopment.tweetos.core.exceptions.TweetNotFoundException;
import com.ardevelopment.tweetos.core.features.LikeTweet;
import com.ardevelopment.tweetos.core.ports.driven.dao.ILikeTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.LikeTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.mocks.LikeTweetDaoMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LikeTweetTest {

    private ILikeTweetDao dao;
    private LikeTweet feature;

    @BeforeEach
    void setUp(){
        dao = new LikeTweetDaoMock();
        feature = new LikeTweet(dao);
    }

    @Test
    void should_add_like_on_tweet(){
        LikeTweetRequestDto dto = new LikeTweetRequestDto("existingTweetId");
        int response = feature.execute(dto);
        assertEquals(response, 1);
    }

    @Test
    void should_throw_exception_if_tweet_does_not_exist(){
        LikeTweetRequestDto dto = new LikeTweetRequestDto("notExistingTweetId");
        assertThrows(TweetNotFoundException.class, ()-> feature.execute(dto));
    }
}