package com.kitapyurdu.interaction.dto;

import com.kitapyurdu.interaction.entity.Comments;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
    public int userId;
    public String userName;
    public String userLastName;
    public List<CommentsDto> commentsList;
}
