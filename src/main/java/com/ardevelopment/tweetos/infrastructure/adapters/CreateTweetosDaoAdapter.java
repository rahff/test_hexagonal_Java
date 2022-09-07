package com.ardevelopment.tweetos.infrastructure.adapters;

import com.ardevelopment.tweetos.infrastructure.models.TweetosModel;
import com.ardevelopment.tweetos.infrastructure.security.Crypto;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICreateTweetosDao;
import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;


@Component
public class CreateTweetosDaoAdapter implements ICreateTweetosDao {

    private MongoTemplate mongo;
    public CreateTweetosDaoAdapter(MongoTemplate mongo){
        this.mongo = mongo;
    }

    public boolean isExistingWithSameEmail(String email) {
        Query query = new Query(Criteria.where("email").is(email));
        return mongo.exists(query, "Tweetos");
    }

    public TweetosDto saveTweetos(TweetosDto data, String password) {
        byte[] hashedPassword = Crypto.hash(password);
        TweetosModel savedTweetos = (TweetosModel) mongo.save(new TweetosModel(data.get_id(), data.getEmail(), data.getUsername(), hashedPassword.toString()), "Tweetos");
        System.out.println("saved: " + savedTweetos);
        return new TweetosDto(savedTweetos._id, savedTweetos.username, savedTweetos.email);
    }
}
