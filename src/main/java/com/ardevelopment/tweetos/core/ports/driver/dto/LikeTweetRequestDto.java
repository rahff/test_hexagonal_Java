package com.ardevelopment.tweetos.core.ports.driver.dto;

public class LikeTweetRequestDto {

    private String tweetedTweetId;

    public LikeTweetRequestDto(String tweetRef){
        this.tweetedTweetId = tweetRef;
    }

    public String getTweetedTweetId() {
        return tweetedTweetId;
    }
}
