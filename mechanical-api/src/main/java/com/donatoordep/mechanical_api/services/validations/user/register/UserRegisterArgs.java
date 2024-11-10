package com.donatoordep.mechanical_api.services.validations.user.register;

import com.donatoordep.mechanical_api.dtos.request.UserRegisterRequestDTO;
import com.donatoordep.mechanical_api.repositories.impl.UserRepositoryImpl;

public record UserRegisterArgs(UserRegisterRequestDTO dto, UserRepositoryImpl repository) {
}
