package com.ardevelopment.tweetos.infrastructure.controllers;



import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.LikeTweetRequestDto;
import com.ardevelopment.tweetos.infrastructure.dto.CreateTweetRequestBody;
import com.ardevelopment.tweetos.infrastructure.services.ITweetService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/tweet")
public class TweetController {
    private ITweetService service;

    public TweetController(ITweetService service){
        this.service = service;
    }

    @PostMapping("")
    ResponseEntity<?> publishTweet(@RequestBody CreateTweetRequestBody body) {
        try{
            CreateTweetRequestDto dto = new CreateTweetRequestDto(body.content, body.tweetosId);
            return ResponseEntity.status(201).body(service.createTweetHandler(dto));
        }catch (RuntimeException e){
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(e.getMessage());
        }
    }

    @GetMapping("/like/{tweetId}")
    ResponseEntity<?> likeTweet(@PathVariable String tweetId) {
        try{
            LikeTweetRequestDto dto = new LikeTweetRequestDto(tweetId);
            return ResponseEntity.status(200).body(service.likeTweetHandler(dto));
        }catch (RuntimeException e){
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(e.getMessage());
        }
    }
}
