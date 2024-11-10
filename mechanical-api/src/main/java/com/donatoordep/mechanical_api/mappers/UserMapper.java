package com.donatoordep.mechanical_api.mappers;

import com.donatoordep.mechanical_api.dtos.request.UserRegisterRequestDTO;
import com.donatoordep.mechanical_api.dtos.response.UserRegisterResponseDTO;
import com.donatoordep.mechanical_api.entities.User;

public final class UserMapper {

    private UserMapper() {
    }

    public static User fromRegisterDto(UserRegisterRequestDTO dto) {
        return User.Builder.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public static UserRegisterResponseDTO fromEntity(User entity) {
        return new UserRegisterResponseDTO(entity.getId(), entity.getEmail());
    }
}