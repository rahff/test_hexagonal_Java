package com.ardevelopment.tweetos.infrastructure.services;

import com.ardevelopment.tweetos.core.features.CreateTweetos;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetosDao;
import com.ardevelopment.tweetos.core.ports.driver.api.ICreateTweetos;
import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetosRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import org.springframework.stereotype.Service;


@Service
public class TweetosService implements ITweetosService {

    private ICreateTweetos createTweetos;

    public TweetosService(ICreateTweetosDao dao) {
        this.createTweetos = new CreateTweetos(dao);
    }

    public TweetosDto createTweetosHandler(CreateTweetosRequestDto dto) {
        return createTweetos.execute(dto);
    }
}
