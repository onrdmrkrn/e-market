package com.kitapyurdu.interaction.service;

import com.kitapyurdu.interaction.dto.CommentsDto;
import com.kitapyurdu.interaction.entity.Comments;
import com.kitapyurdu.interaction.exception.AddCommentsException;
import com.kitapyurdu.interaction.mapper.CommentsMapper;
import com.kitapyurdu.interaction.repository.CommentRepository;
import com.kitapyurdu.interaction.response.CommentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    @Autowired
    CommentsMapper commentsMapper;

    @Autowired
    CommentRepository commentRepository;

    /*public CommentsDto addComments(CommentsDto commentsDto){
        Comments comments=commentsMapper.toEntity(commentsDto);
        comments=commentRepository.save(comments);
        return commentsMapper.toResource(comments);
    }*/

    public CommentsResponse addComments(CommentsDto commentsDto)throws AddCommentsException{
        Comments comments=commentsMapper.toEntity(commentsDto);
        comments=commentRepository.save(comments);
        if (comments==null){
            throw new AddCommentsException();
        }
        return commentsResult(commentsMapper.toResource(comments));
    }

    private CommentsResponse commentsResult(CommentsDto toResource) {
        CommentsResponse commentsResponse=new CommentsResponse();
        commentsResponse.commentsDto=toResource;
        return commentsResponse;
    }

}
