package com.kitapyurdu.interaction.repository;

import com.kitapyurdu.interaction.entity.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Integer> {
}
