package com.ardevelopment.tweetos.infrastructure.adapters;

import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.infrastructure.models.TweetModel;
import com.ardevelopment.tweetos.infrastructure.models.TweetosModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CreateTweetDaoAdapterTest {

    @Mock
    private MongoTemplate mongo;
    private ICreateTweetDao feature;

    @BeforeEach
    void setUp() {
        feature = new CreateTweetDaoAdapter(mongo);
    }
    @Test
    void should_get_tweetos_who_attempts_to_create_tweet() {
        //given
        String _id = UUID.randomUUID().toString();
        given(mongo.findById(eq(_id), eq(TweetosModel.class), eq("Tweetos"))).willReturn(new TweetosModel(_id, "test123@gmail.com", "test", "poiiiii"));
        //when
        feature.getTweetosTweet(_id);
        ArgumentCaptor<String> capture = ArgumentCaptor.forClass(String.class);
        verify(mongo).findById(capture.capture(), eq(TweetosModel.class), eq("Tweetos"));
        //then
        assertThat(capture.getValue()).isEqualTo(_id);
    }

    @Test
    void should_return_null_if_tweetos_does_not_exist() {
        //given
        String _id = UUID.randomUUID().toString();
        given(mongo.findById(eq(_id), eq(TweetosModel.class), eq("Tweetos"))).willReturn(null);
        //when
        var result =feature.getTweetosTweet(_id);
        //then
        assertThat(result).isEqualTo(null);
    }


    @Test
    void should_save_tweet() {
        //given
        String _id = UUID.randomUUID().toString();
        String tweetId = UUID.randomUUID().toString();
        TweetosDto tweetos = new TweetosDto("123", "Jacques Vabre", "jacquesvabre@free.com");
        TweetDto tweet = new TweetDto(tweetId, "hello", tweetos, 0);
        TweetModel tweetToSave = new TweetModel(_id, "hello", tweetos, 0);
        given(mongo.save(any(), eq("Tweet"))).willReturn(tweetToSave);
        //when
        feature.saveTweet(tweet);
        ArgumentCaptor<TweetModel> capture = ArgumentCaptor.forClass(TweetModel.class);
        verify(mongo).save(capture.capture(), eq("Tweet"));
        assertThat(capture.getValue()._id).isEqualTo(tweetId);
    }
}