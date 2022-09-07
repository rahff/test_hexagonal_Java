package com.ardevelopment.tweetos.core.features;

import static org.junit.jupiter.api.Assertions.*;

import com.ardevelopment.tweetos.core.exceptions.TweetNotFoundException;
import com.ardevelopment.tweetos.core.exceptions.TweetosNotFoundException;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICommentTweetDao;

import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentTweetRequestDto;
import com.ardevelopment.tweetos.mocks.CommentTweetDaoMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommentTweetTest {

    private ICommentTweetDao dao;
    CommentTweet feature;
    @BeforeEach
    void setUp(){
        dao = new CommentTweetDaoMock();
        feature = new CommentTweet(dao);
    }
    @Test
    void should_create_comment() {
        CommentTweetRequestDto dto = new CommentTweetRequestDto("existingTweetId", "existingTweetosId", "hello");
        CommentDto savedComment = feature.execute(dto);
        assertEquals(savedComment.getContent(), "hello");
    }

    @Test
    void should_not_create_comment_if_tweet_ref_does_not_exist() {
        CommentTweetRequestDto dto = new CommentTweetRequestDto("notExistingTweetId", "existingTweetosId", "hello");
        assertThrows(TweetNotFoundException.class, ()-> feature.execute(dto));
    }

    @Test
    void should_not_create_comment_if_tweetos_ref_does_not_exist() {
        CommentTweetRequestDto dto = new CommentTweetRequestDto("existingTweetId", "notExistingTweetosId", "hello");
        assertThrows(TweetosNotFoundException.class, ()-> feature.execute(dto));
    }

}