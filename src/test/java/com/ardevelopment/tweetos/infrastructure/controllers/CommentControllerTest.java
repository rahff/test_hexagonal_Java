package com.ardevelopment.tweetos.infrastructure.controllers;

import com.ardevelopment.tweetos.infrastructure.dto.CreateCommentRequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {
    @Autowired
    private MockMvc http;
    private final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    void commentTweet() throws Exception {
        CreateCommentRequestBody body = new CreateCommentRequestBody("Cool !", "5c78ec12-0675-4b46-9735-9b48f721e16b", "05fe6350-9c4e-4215-912d-9986e68edfb7");
        String jsonBody = ow.writeValueAsString(body);
        http.perform(post("/api/comment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                        .andExpect(status().isCreated());
    }

    @Test
    void commentTweet_bad_request_caused_by_tweetRef() throws Exception {
        CreateCommentRequestBody body = new CreateCommentRequestBody("Cool !", "5c78ee12-0675-4b56-9735-9b48f721e16b", "05fe6350-9c4e-4215-912d-9986e68edfb7");
        String jsonBody = ow.writeValueAsString(body);
        http.perform(post("/api/comment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                        .andExpect(status().isBadRequest());
    }

    @Test
    void commentTweet_bad_request_caused_by_tweetosRef() throws Exception {
        CreateCommentRequestBody body = new CreateCommentRequestBody("Cool !", "5c78ec12-0675-4b46-9735-9b48f721e16b", "05ff6350-9c4e-4215-962d-9986e61edfb7");
        String jsonBody = ow.writeValueAsString(body);
        http.perform(post("/api/comment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isBadRequest());
    }
}