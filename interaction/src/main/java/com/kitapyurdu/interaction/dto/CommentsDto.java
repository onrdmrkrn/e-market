package com.kitapyurdu.interaction.dto;

import com.kitapyurdu.interaction.entity.Comments;
import com.kitapyurdu.interaction.entity.Product;
import com.kitapyurdu.interaction.entity.User;

import java.io.Serializable;

public class CommentsDto implements Serializable {
    public int commentId;
    public String comment;
    public User user;
    public int productId;
}
