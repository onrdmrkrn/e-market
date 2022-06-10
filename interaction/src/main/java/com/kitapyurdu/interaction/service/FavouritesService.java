package com.kitapyurdu.interaction.service;

import com.kitapyurdu.interaction.dto.FavouritesDto;
import com.kitapyurdu.interaction.entity.Favourites;
import com.kitapyurdu.interaction.exception.AddFavouritesException;
import com.kitapyurdu.interaction.mapper.FavouritesMapper;
import com.kitapyurdu.interaction.repository.FavouritesRepository;
import com.kitapyurdu.interaction.response.FavouritesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouritesService {

    @Autowired
    FavouritesMapper favouritesMapper;

    @Autowired
    FavouritesRepository favouritesRepository;

    public FavouritesResponse addFavourites(FavouritesDto favouritesDto)throws AddFavouritesException {
        Favourites favourites=favouritesMapper.toEntity(favouritesDto);
        favourites=favouritesRepository.save(favourites);
        if (favourites==null){
            throw new AddFavouritesException();
        }
        return favouritesResult(favouritesMapper.toResource(favourites));
    }

    private FavouritesResponse favouritesResult(FavouritesDto toResource) {
        FavouritesResponse favouritesResponse=new FavouritesResponse();
        favouritesResponse.favouritesDto=toResource;
        return favouritesResponse;
    }
}
