package com.ardevelopment.tweetos.core.entities;


import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.core.valueObjects.TweetContent;
import com.ardevelopment.tweetos.core.valueObjects.EntityId;

public class Tweet {

    private TweetContent content;
    private EntityId _id;
    private TweetosDto tweetos;

    private int likes;

    public Tweet(TweetContent content, EntityId _id, TweetosDto tweetos){
        this.content = content;
        this._id = _id;
        this.tweetos = tweetos;
        this.likes = 0;
    }

    public TweetosDto getTweetos() {
        return tweetos;
    }

    public EntityId get_id() {
        return _id;
    }

    public TweetContent getContent() {
        return content;
    }

    public TweetDto asDto(){
        return new TweetDto(this.get_id().getValue(), this.getContent().getTextValue(), this.getTweetos(), this.getLikes());
    }

    public int getLikes() {
        return likes;
    }
}
