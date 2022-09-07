package com.ardevelopment.tweetos.infrastructure.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CommentModel {

    @Id
    public String _id;
    public String content;
    public String tweetRef;
    public String tweetosRef;
    public String tweetosName;

    public CommentModel(){}
    public CommentModel(String _id, String content, String tweetRef, String tweetosRef, String tweetosName){
        this._id = _id;
        this.content = content;
        this.tweetosRef = tweetosRef;
        this.tweetRef = tweetRef;
        this.tweetosName = tweetosName;
    }


}
