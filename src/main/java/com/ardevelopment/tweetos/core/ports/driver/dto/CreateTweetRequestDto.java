package com.ardevelopment.tweetos.core.ports.driver.dto;

public class CreateTweetRequestDto {
    private String content;
    private String tweetosId;

    public CreateTweetRequestDto(String content, String tweetosId){
        this.content = content;
        this.tweetosId = tweetosId;
    }

    public String getTweetosId() {
        return tweetosId;
    }

    public String getContent() {
        return content;
    }
}
