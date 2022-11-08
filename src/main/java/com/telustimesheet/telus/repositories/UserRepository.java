package com.telustimesheet.telus.repositories;

import com.telustimesheet.telus.entities.UserEntity;
import com.telustimesheet.telus.repositories.general.ExtendedJpaRepository;

public interface UserRepository extends ExtendedJpaRepository<UserEntity> {
    public UserEntity findByEmail(String email);
}