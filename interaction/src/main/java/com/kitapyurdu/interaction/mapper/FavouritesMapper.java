package com.kitapyurdu.interaction.mapper;

import com.kitapyurdu.interaction.dto.FavouritesDto;
import com.kitapyurdu.interaction.entity.Favourites;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface FavouritesMapper extends IEntityMapper<FavouritesDto, Favourites>{
}
