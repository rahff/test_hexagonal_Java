package com.ardevelopment.tweetos.infrastructure.controllers;

import com.ardevelopment.tweetos.infrastructure.dto.CreateCommentRequestBody;
import com.ardevelopment.tweetos.infrastructure.dto.CreateTweetRequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class TweetControllerTest {
    @Autowired
    private MockMvc http;
    private final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    void publishTweet() throws Exception {
        CreateTweetRequestBody body = new CreateTweetRequestBody("hello", "f91cd718-60f8-43b0-9680-4745ab476154");
        String jsonBody = ow.writeValueAsString(body);
        http.perform(post("/api/tweet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andExpect(status().isCreated());
    }

    @Test
    void publishTweet_bad_request_caused_by_tweetos_ref() throws Exception {
        CreateTweetRequestBody body = new CreateTweetRequestBody("hello", "f91cd714-60f8-43b0-9680-4745ac476154");
        String jsonBody = ow.writeValueAsString(body);
        http.perform(post("/api/tweet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    void likeTweet() throws Exception {
        http.perform(get("/api/tweet/like")
                .param("tweetId", "84606553-8650-475a-a578-947f0c818795"))
                .andExpect(status().isOk());
    }

    @Test
    void likeTweet_bad_request_caused_by_tweet_ref() throws Exception {
        http.perform(get("/api/tweet/like")
                        .param("tweetId", "84606553-86b0-475a-a574-947f0c818795"))
                .andExpect(status().isBadRequest());
    }
}