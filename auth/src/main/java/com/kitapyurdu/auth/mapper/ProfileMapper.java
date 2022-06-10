package com.kitapyurdu.auth.mapper;

import com.kitapyurdu.auth.dto.ProfileDto;
import com.kitapyurdu.auth.entity.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper extends IEntityMapper<ProfileDto, Profile>{
}
