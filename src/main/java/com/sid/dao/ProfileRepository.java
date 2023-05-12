package com.sid.dao;

import com.sid.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
