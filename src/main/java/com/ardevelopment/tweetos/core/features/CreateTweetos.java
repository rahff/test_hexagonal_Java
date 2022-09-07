package com.ardevelopment.tweetos.core.features;

import com.ardevelopment.tweetos.core.entities.Tweetos;
import com.ardevelopment.tweetos.core.exceptions.EmailAlreadyExistException;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetosDao;
import com.ardevelopment.tweetos.core.ports.driver.api.ICreateTweetos;
import com.ardevelopment.tweetos.core.ports.driver.dto.CreateTweetosRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.core.valueObjects.Email;
import com.ardevelopment.tweetos.core.valueObjects.EntityId;
import com.ardevelopment.tweetos.core.valueObjects.Password;
import com.ardevelopment.tweetos.core.valueObjects.TweetosName;

import java.util.UUID;

public class CreateTweetos implements ICreateTweetos {

    private ICreateTweetosDao repository;
    public CreateTweetos(ICreateTweetosDao repository){
        this.repository = repository;
    }
    @Override
    public TweetosDto execute(CreateTweetosRequestDto data) {
        try{
            boolean isExistWithSameEmail = repository.isExistingWithSameEmail(data.getEmail());
            if(isExistWithSameEmail) throw new EmailAlreadyExistException();
            String _id = UUID.randomUUID().toString();
            Tweetos newTweetos = new Tweetos(new EntityId(_id), new TweetosName(data.getLastname(), data.getFirstname()), new Email(data.getEmail()), new Password(data.getPassword()));
            TweetosDto saveResult = repository.saveTweetos(newTweetos.asDto(), newTweetos.getPassword());
            return saveResult;
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
