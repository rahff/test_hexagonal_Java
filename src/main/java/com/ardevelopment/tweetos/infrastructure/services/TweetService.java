package com.ardevelopment.tweetos.infrastructure.services;

import com.ardevelopment.tweetos.core.features.CreateTweet;
import com.ardevelopment.tweetos.core.features.LikeTweet;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetDao;
import com.ardevelopment.tweetos.core.ports.driven.dao.ILikeTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.api.ICreateTweet;
import com.ardevelopment.tweetos.core.ports.driver.api.ILikeTweet;
import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.LikeTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import org.springframework.stereotype.Service;


@Service
public class TweetService implements ITweetService {

    private ICreateTweet createTweet;
    private ILikeTweet likeTweet;

    public TweetService(ICreateTweetDao createTweetDao, ILikeTweetDao likeTweetDao) {
        this.createTweet = new CreateTweet(createTweetDao);
        this.likeTweet = new LikeTweet(likeTweetDao);
    }

    public TweetDto createTweetHandler(CreateTweetRequestDto dto) {
        return createTweet.execute(dto);
    }

    public int likeTweetHandler(LikeTweetRequestDto dto) {
        return likeTweet.execute(dto);
    }
}
