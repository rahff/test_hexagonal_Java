package com.ardevelopment.tweetos.infrastructure.repositories;

import com.ardevelopment.tweetos.infrastructure.models.CommentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<CommentModel, String> {
}
