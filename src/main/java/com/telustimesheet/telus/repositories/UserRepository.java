package com.telustimesheet.telus.repositories;

import com.telustimesheet.telus.entities.User;
import com.telustimesheet.telus.repositories.general.ExtendedJpaRepository;

public interface UserRepository extends ExtendedJpaRepository<User> {
    public User findByEmail(String email);
}