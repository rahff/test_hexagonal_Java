package com.ardevelopment.tweetos.infrastructure.controllers;

import com.ardevelopment.tweetos.core.ports.driver.dto.CommentTweetRequestDto;
import com.ardevelopment.tweetos.infrastructure.dto.CreateCommentRequestBody;
import com.ardevelopment.tweetos.infrastructure.services.ICommentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private ICommentService service;

    public CommentController(ICommentService service) {
        this.service = service;
    }

    @PostMapping()
    ResponseEntity<?> commentTweet(@RequestBody CreateCommentRequestBody body) {
        try{
            CommentTweetRequestDto dto = new CommentTweetRequestDto(body.tweetRef, body.tweetosRef, body.content);
            return ResponseEntity.status(201).body(service.CommentTweetHandler(dto));
        }catch (RuntimeException e) {
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(e.getMessage());
        }
    }
}
