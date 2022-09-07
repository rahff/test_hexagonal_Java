package com.ardevelopment.tweetos.infrastructure.controllers;

import com.ardevelopment.tweetos.infrastructure.dto.CreateTweetosRequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TweetosControllerTest {

    @Autowired
    private MockMvc http;
    private final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    @Test
    void createTweetos() throws Exception {
        String email = UUID.randomUUID().toString().substring(3,8) + "@gmail.com";
        CreateTweetosRequestBody body = new CreateTweetosRequestBody("Pierre", "Jacques", "pierrejacques@gmail.com", "Mot2$asse");
        String jsonBody = ow.writeValueAsString(body);
        http.perform(post("/api/tweetos")
                    .contentType(MediaType.APPLICATION_JSON).content(jsonBody))
                    .andExpect(status().isCreated());
    }

    @Test
    void createTweetos_bad_request_caused_by_invalid_payload() throws Exception {
        CreateTweetosRequestBody body = new CreateTweetosRequestBody("Pierre", "Jacques", "pierrejacquesgmail.com", "Mot2$asse");
        String bodyJson = ow.writeValueAsString(body);
        http.perform(post("/api/tweetos")
                .contentType(MediaType.APPLICATION_JSON).content(bodyJson))
                .andExpect(status().isBadRequest());
    }
}