package com.ardevelopment.tweetos.core.ports.driver.api;

import com.ardevelopment.tweetos.core.ports.driver.dto.CommentTweetRequestDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;

public interface ICommentTweet {

    CommentDto execute(CommentTweetRequestDto data);
}
