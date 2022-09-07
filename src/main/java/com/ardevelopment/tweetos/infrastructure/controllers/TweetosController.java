package com.ardevelopment.tweetos.infrastructure.controllers;

import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetosRequestDto;
import com.ardevelopment.tweetos.infrastructure.dto.CreateTweetosRequestBody;
import com.ardevelopment.tweetos.infrastructure.services.ITweetosService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;



@RestController()
@RequestMapping("api")
public class TweetosController {

    private ITweetosService service;

    public TweetosController(ITweetosService service){
        this.service = service;
    }

    @PostMapping("tweetos")
    public ResponseEntity<?> createTweetos(@RequestBody CreateTweetosRequestBody body){
        try{
            CreateTweetosRequestDto dto = new CreateTweetosRequestDto(body.lastname, body.firstname, body.password, body.email);
            return ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).body(service.createTweetosHandler(dto));
        }catch (Exception e){
            System.out.println("errorMessage :"+ e.getMessage());
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(e);
        }
    }
}
