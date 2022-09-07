package com.ardevelopment.tweetos.infrastructure.repositories;

import com.ardevelopment.tweetos.infrastructure.models.TweetosModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TweetosRepository extends MongoRepository<TweetosModel, String> {
}
