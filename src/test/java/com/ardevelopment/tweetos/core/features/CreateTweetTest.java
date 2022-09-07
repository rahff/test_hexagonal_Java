package com.ardevelopment.tweetos.core.features;


import com.ardevelopment.tweetos.core.exceptions.TweetosNotFoundException;
import com.ardevelopment.tweetos.core.features.CreateTweet;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.mocks.CreateTweetDaoMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CreateTweetTest {

    private ICreateTweetDao daoMock;
    private CreateTweet feature;
    CreateTweetRequestDto dto;

    @BeforeEach
    void setUp() {
        daoMock = new CreateTweetDaoMock();
        feature = new CreateTweet(daoMock);
    }

    @Test
    void should_create_tweet() {
        dto = new CreateTweetRequestDto("Hello world!", "existingTweetosId");
        TweetDto response = feature.execute(dto);
        assertEquals(response.getContent(), "Hello world!");
    }

    @Test
    void should_not_create_tweet_if_tweetos_does_not_exist() {
        dto = new CreateTweetRequestDto("Hello world!", "notExistingTweetosId");
        assertThrows(TweetosNotFoundException.class, ()-> feature.execute(dto));
    }
}