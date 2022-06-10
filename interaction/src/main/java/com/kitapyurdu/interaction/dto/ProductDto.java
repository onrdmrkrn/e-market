package com.kitapyurdu.interaction.dto;

import com.kitapyurdu.interaction.entity.Comments;
import com.kitapyurdu.interaction.entity.Favourites;

import java.io.Serializable;
import java.util.List;

public class ProductDto implements Serializable {
    public int productId;
    public String productName;
    public String productDescprition;
    public Favourites favourites;
    public List<CommentsDto> commentsList;
}
