package com.ardevelopment.tweetos.infrastructure.services;

import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentTweetRequestDto;

public interface ICommentService {
    CommentDto CommentTweetHandler(CommentTweetRequestDto dto);
}
