package com.ardevelopment.tweetos.infrastructure.adapters;

import com.ardevelopment.tweetos.core.ports.driven.dao.ICommentTweetDao;
import com.ardevelopment.tweetos.core.ports.driven.dao.ILikeTweetDao;
import com.ardevelopment.tweetos.infrastructure.models.TweetModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LikeTweetDaoAdapterTest {

    @Mock
    private MongoTemplate mongoTemplate;
    private ILikeTweetDao feature;

    @BeforeEach
    void setUp() {
        feature = new LikeTweetDaoAdapter(mongoTemplate);
    }
    @Test
    void should_verify_if_liked_tweet_really_exist() {
        //given
        given(mongoTemplate.exists(any(), eq("Tweet"))).willReturn(true);
        //when
        boolean result = feature.isTweetExist("448484rg48");
        //then
        verify(mongoTemplate).exists(any(), eq("Tweet"));
        assertTrue(result);
    }

    @Test
    void should_verify_if_liked_tweet_effectively_not_exist() {
        //given
        given(mongoTemplate.exists(any(), eq("Tweet"))).willReturn(false);
        //when
        boolean result = feature.isTweetExist("54r4gt84");
        //then
        verify(mongoTemplate).exists(any(), eq("Tweet"));
        assertFalse(result);
    }


    @Test
    void addLikeOnTweet() {
        //given
        given(mongoTemplate.findAndModify(any(), any() , eq(TweetModel.class), eq("Tweet"))).willReturn(new TweetModel());
        //when
        feature.addLikeOnTweet("122315555");
        ArgumentCaptor<Update> capturedUpdate = ArgumentCaptor.forClass(Update.class);
        verify(mongoTemplate).findAndModify(any(), capturedUpdate.capture(), eq(TweetModel.class), eq("Tweet"));
        //then
        assertThat(capturedUpdate.getValue()).isEqualTo(new Update().inc("likes", 1));
    }
}