package com.kitapyurdu.auth.repository;

import com.kitapyurdu.auth.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {

}
