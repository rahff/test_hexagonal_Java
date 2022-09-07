package com.ardevelopment.tweetos.core.ports.driver.dto;

public class TweetDto {
    private String content;
    private TweetosDto Tweetos;
    private String _id;
    private int likes;

    public TweetDto(String _id, String content, TweetosDto tweetos, int likes){
        this._id = _id;
        this.content = content;
        this.Tweetos = tweetos;
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public TweetosDto getTweetos() {
        return Tweetos;
    }

    public String get_id() {
        return _id;
    }

    public int getLikes() {
        return likes;
    }
}
