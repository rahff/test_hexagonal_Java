package com.ardevelopment.tweetos.core.ports.driver.dto;

public class CommentTweetRequestDto {

    private String tweetRef;
    private String tweetosRef;
    private String content;


    public CommentTweetRequestDto(String tweetRef, String tweetosRef, String content) {
        this.tweetRef = tweetRef;
        this.tweetosRef = tweetosRef;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTweetosRef() {
        return tweetosRef;
    }

    public String getTweetRef() {
        return tweetRef;
    }
}
