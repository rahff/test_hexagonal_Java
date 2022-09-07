package com.ardevelopment.tweetos.infrastructure.dto;

public class CreateCommentRequestBody {

    public String content;
    public String tweetRef;
    public String tweetosRef;

    public CreateCommentRequestBody() {}

    public CreateCommentRequestBody(String content, String tweetRef, String tweetosRef) {
        this.content = content;
        this.tweetRef = tweetRef;
        this.tweetosRef = tweetosRef;
    }
}
