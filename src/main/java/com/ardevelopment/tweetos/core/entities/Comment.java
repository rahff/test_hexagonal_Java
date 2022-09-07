package com.ardevelopment.tweetos.core.entities;

import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;
import com.ardevelopment.tweetos.core.valueObjects.CommentContent;
import com.ardevelopment.tweetos.core.valueObjects.EntityId;

public class Comment {

    private EntityId _id;
    private CommentContent content;
    private String tweetRef;

    private String authorUsername;
    private String authorId;

    public Comment(EntityId _id, CommentContent content, String tweetRef, String authorUsername, String authorId) {
        this._id = _id;
        this.content = content;
        this.tweetRef = tweetRef;
        this.authorUsername = authorUsername;
        this.authorId = authorId;
    }

    public String getTweetRef() {
        return tweetRef;
    }

    public CommentContent getContent() {
        return content;
    }

    public EntityId get_id() {
        return _id;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public CommentDto asDto(String authorId) {
        return new CommentDto(get_id().getValue(), getContent().getValue(), getTweetRef(), getAuthorUsername(), authorId);
    }
}
