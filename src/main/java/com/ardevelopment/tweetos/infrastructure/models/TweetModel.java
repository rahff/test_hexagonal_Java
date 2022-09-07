package com.ardevelopment.tweetos.infrastructure.models;


import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TweetModel {
    @Id
    public String _id;
    public String content;
    public TweetosDto tweetos;
    public int likes;

    public TweetModel(String _id, String content, TweetosDto tweetos, int likes) {
        this._id = _id;
        this.content = content;
        this.tweetos = tweetos;
        this.likes = likes;
    }

    public TweetModel() {}
}
