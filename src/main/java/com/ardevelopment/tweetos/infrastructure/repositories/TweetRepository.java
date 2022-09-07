package com.ardevelopment.tweetos.infrastructure.repositories;

import com.ardevelopment.tweetos.infrastructure.models.TweetModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TweetRepository extends MongoRepository<TweetModel, String> {
}
