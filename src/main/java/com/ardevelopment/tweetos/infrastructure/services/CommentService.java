package com.ardevelopment.tweetos.infrastructure.services;


import com.ardevelopment.tweetos.core.features.CommentTweet;
import com.ardevelopment.tweetos.core.ports.driven.dao.ICommentTweetDao;
import com.ardevelopment.tweetos.core.ports.driver.api.ICommentTweet;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentDto;
import com.ardevelopment.tweetos.core.ports.driver.dto.CommentTweetRequestDto;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService{

    private ICommentTweet commentTweet;

    public CommentService(ICommentTweetDao dao) {
        this.commentTweet = new CommentTweet(dao);
    }

    public CommentDto CommentTweetHandler(CommentTweetRequestDto dto) {
        return commentTweet.execute(dto);
    }
}
