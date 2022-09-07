package com.ardevelopment.tweetos.infrastructure.dto;

public class CreateTweetRequestBody {

    public String content;
    public String tweetosId;
    public CreateTweetRequestBody(){}
    public CreateTweetRequestBody(String content, String tweetosId){
        this.content = content;
        this.tweetosId = tweetosId;
    }
}
