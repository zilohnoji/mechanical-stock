package com.donatoordep.mechanical_api.repositories.impl;

import com.donatoordep.mechanical_api.entities.User;
import com.donatoordep.mechanical_api.exceptions.ONBEntityNotFoundException;
import com.donatoordep.mechanical_api.repositories.UserRepositorySpecification;

public interface UserRepositoryImpl extends UserRepositorySpecification {

    default User findByEmailOrThrowNotFound(String email) {
        return this.findByEmail(email).orElseThrow(ONBEntityNotFoundException::new);
    }
}