package com.kitapyurdu.interaction.controller;

import com.kitapyurdu.interaction.dto.CommentsDto;
import com.kitapyurdu.interaction.exception.AddCommentsException;
import com.kitapyurdu.interaction.response.CommentsResponse;
import com.kitapyurdu.interaction.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    @PostMapping("/addComments")
    public CommentsResponse addComments(@RequestBody CommentsDto commentsDto)throws AddCommentsException{
        return commentsService.addComments(commentsDto);
    }
}
