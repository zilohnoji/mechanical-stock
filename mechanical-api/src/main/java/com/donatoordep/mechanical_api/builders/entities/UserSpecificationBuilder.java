package com.donatoordep.mechanical_api.builders.entities;

import com.donatoordep.mechanical_api.builders.Builder;
import com.donatoordep.mechanical_api.entities.User;

public interface UserSpecificationBuilder extends Builder<User> {

    UserSpecificationBuilder name(String name);

    UserSpecificationBuilder email(String email);

    UserSpecificationBuilder password(String password);
}