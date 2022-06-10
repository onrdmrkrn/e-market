package com.kitapyurdu.interaction.controller;

import com.kitapyurdu.interaction.dto.FavouritesDto;
import com.kitapyurdu.interaction.exception.AddFavouritesException;
import com.kitapyurdu.interaction.response.FavouritesResponse;
import com.kitapyurdu.interaction.service.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favories")
public class FavouritesController {

    @Autowired
    FavouritesService favouritesService;

    @PostMapping("/addFavourites")
    public FavouritesResponse addFavourites(@RequestBody FavouritesDto favouritesDto)throws AddFavouritesException{
        return favouritesService.addFavourites(favouritesDto);
    }
}
