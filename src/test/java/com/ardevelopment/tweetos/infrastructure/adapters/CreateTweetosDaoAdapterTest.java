package com.ardevelopment.tweetos.infrastructure.adapters;

import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetosDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.infrastructure.models.TweetosModel;
import com.ardevelopment.tweetos.infrastructure.security.Crypto;
import com.mongodb.client.MongoClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTweetosDaoAdapterTest {

   @Mock
    private MongoTemplate mongoTemplate;
    private ICreateTweetosDao feature;

    @BeforeEach
    void setUp() {
        feature = new CreateTweetosDaoAdapter(mongoTemplate);
    }

    @Test
    void isExistingWithSameEmailIsTrue() {
        //given
        given(mongoTemplate.exists(any(), eq("Tweetos"))).willReturn(true);
        //when
        boolean result = feature.isExistingWithSameEmail("yuri@gmail.com");
        //then
        verify(mongoTemplate).exists(any(), eq("Tweetos"));
        assertTrue(result);
    }

    @Test
    void isExistingWithSameEmailIsFalse() {
        //given
        given(mongoTemplate.exists(any(), eq("Tweetos"))).willReturn(false);
        //when
        boolean result = feature.isExistingWithSameEmail("yuri@gmail.com");
        //then
        verify(mongoTemplate).exists(any(), eq("Tweetos"));
        assertFalse(result);
    }

    @Test
    void saveTweetos() {
        //given
        String _id = UUID.randomUUID().toString();
        String email = UUID.randomUUID().toString().substring(5,10) + "@gmail.com";
        TweetosDto tweetos = new TweetosDto(_id, "Yuri Sop", email);
        String hashedPassword = Crypto.hash("Mot2$asse").toString();
        TweetosModel TweetosToSave = new TweetosModel(tweetos.get_id(), tweetos.getEmail(), tweetos.getUsername(), hashedPassword);
        given(mongoTemplate.save(any(), eq("Tweetos"))).willReturn(TweetosToSave);
        //when
        feature.saveTweetos(tweetos, "Mot2$asse");
        //then
        ArgumentCaptor<TweetosModel> captureModel = ArgumentCaptor.forClass(TweetosModel.class);
        verify(mongoTemplate).save(captureModel.capture(), eq("Tweetos"));
        assertEquals(captureModel.getValue()._id, _id);
    }
}