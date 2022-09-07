package com.ardevelopment.tweetos.infrastructure.adapters;

import com.ardevelopment.tweetos.core.ports.driven.dao.ICommentTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;
import com.ardevelopment.tweetos.infrastructure.models.CommentModel;
import com.ardevelopment.tweetos.infrastructure.models.TweetosModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;



@ExtendWith(MockitoExtension.class)
class CommentTweetDaoTest {

    @Mock
    private MongoTemplate mongo;
    private ICommentTweetDao feature;

    @BeforeEach
    void setUp() {
        feature = new CommentTweetDao(mongo);
    }
    @Test
    void should_verify_existence_of_tweet() {
        //given
        String _id = UUID.randomUUID().toString();
        given(mongo.exists(any(), eq("Tweet"))).willReturn(true);
        //when
        var isExisting = feature.isTweetExist(_id);
        //then
        assertThat(isExisting).isTrue();
    }

    @Test
    void should_verify_no_existence_of_tweet() {
        //given
        String _id = UUID.randomUUID().toString();
        given(mongo.exists(any(), eq("Tweet"))).willReturn(false);
        //when
        var isExisting = feature.isTweetExist(_id);
        //then
        assertThat(isExisting).isFalse();
    }

    @Test
    void should_get_tweetos_who_attempts_to_create_tweet() {
        //given
        String _id = UUID.randomUUID().toString();
        given(mongo.findById(eq(_id), eq(TweetosModel.class), eq("Tweetos"))).willReturn(new TweetosModel(_id, "test123@gmail.com", "test", "poiiiii"));
        //when
        feature.isTweetosExist(_id);
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
        var result = feature.isTweetosExist(_id);
        //then
        assertThat(result).isEqualTo(null);
    }

    @Test
    void should_save_comment_for_given_tweet() {
        //given
        String _id = UUID.randomUUID().toString();
        String tweetosId = UUID.randomUUID().toString();
        String tweetRef = UUID.randomUUID().toString();
        CommentDto commentToSave = new CommentDto(_id, "Cool !", tweetRef, "Tester", tweetosId);
        given(mongo.save(any(), eq("Comment"))).willReturn(new CommentModel());
        //when
        feature.saveComment(commentToSave);
        ArgumentCaptor<CommentModel> capturedComment = ArgumentCaptor.forClass(CommentModel.class);
        verify(mongo).save(capturedComment.capture(), eq("Comment"));
        //then
        assertThat(capturedComment.getValue().tweetosRef).isEqualTo(tweetosId);
    }
}