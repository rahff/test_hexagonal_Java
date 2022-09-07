package com.ardevelopment.tweetos.core.ports.driver.dto;

public class CommentDto {

    private String content;
    private String tweetRef;
    private String _id;
    private String authorUsername;
    private String authorId;

    public CommentDto(String _id, String content, String tweetRef, String authorUsername, String authorId) {
        this._id = _id;
        this.content = content;
        this.tweetRef = tweetRef;
        this.authorUsername = authorUsername;
        this.authorId = authorId;
    }

    public String get_id() {
        return _id;
    }

    public String getTweetRef() {
        return tweetRef;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public String getAuthorId() {
        return authorId;
    }
}
