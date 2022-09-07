package com.ardevelopment.tweetos.core.features;

import com.ardevelopment.tweetos.core.features.CreateTweetos;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetosDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetosRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.mocks.CreateTweetosDaoMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class CreateTweetosTest {

    private ICreateTweetosDao daoMock;
    private CreateTweetos feature;
    @BeforeEach()
    void setUp(){
        daoMock = new CreateTweetosDaoMock();
        feature = new CreateTweetos(daoMock);
    }
    @Test
    void should_create_tweetos(){
        CreateTweetosRequestDto dto = new CreateTweetosRequestDto("Pierre", "Roger", "Mot2$asse", "notexistingmail@gmail.com");
        TweetosDto response = feature.execute(dto);
        assertEquals(response.getEmail(), dto.getEmail());
    }

    @Test
    void should_not_create_tweetos(){
        CreateTweetosRequestDto dto = new CreateTweetosRequestDto("Pierre", "Roger", "Mot2$asse", "existingmail@gmail.com");
        assertThrows(RuntimeException.class, ()-> feature.execute(dto));
    }
}