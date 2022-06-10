package com.kitapyurdu.interaction.dto;

import com.kitapyurdu.interaction.entity.Product;

import java.io.Serializable;
import java.util.List;

public class FavouritesDto implements Serializable {
    public int favoriteId;
    public String favoriteDesc;
    public List<ProductDto> productList;
}
