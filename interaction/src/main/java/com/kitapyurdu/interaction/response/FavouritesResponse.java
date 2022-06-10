package com.kitapyurdu.interaction.response;

import com.kitapyurdu.interaction.dto.FavouritesDto;

import java.io.Serializable;

public class FavouritesResponse extends BaseResponse implements Serializable {
    public FavouritesDto favouritesDto;
}
