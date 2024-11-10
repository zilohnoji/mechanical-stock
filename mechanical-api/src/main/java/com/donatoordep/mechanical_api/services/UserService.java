package com.donatoordep.mechanical_api.services;

import com.donatoordep.mechanical_api.dtos.request.UserAuthenticationRequestDTO;
import com.donatoordep.mechanical_api.dtos.request.UserRegisterRequestDTO;
import com.donatoordep.mechanical_api.dtos.response.UserFindByEmailResponseDTO;
import com.donatoordep.mechanical_api.dtos.response.UserRegisterResponseDTO;
import com.donatoordep.mechanical_api.entities.User;
import com.donatoordep.mechanical_api.mappers.UserMapper;
import com.donatoordep.mechanical_api.repositories.impl.UserRepositoryImpl;
import com.donatoordep.mechanical_api.services.validations.user.register.UserRegisterArgs;
import com.donatoordep.mechanical_api.services.validations.user.register.UserRegisterValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepositoryImpl repository;
    private final List<UserRegisterValidation> userRegisterValidations;

    @Autowired
    public UserService(UserRepositoryImpl repository, List<UserRegisterValidation> userRegisterValidations) {
        this.repository = repository;
        this.userRegisterValidations = userRegisterValidations;
    }

    @Transactional
    public UserRegisterResponseDTO register(UserRegisterRequestDTO dto) {
        userRegisterValidations.forEach(validation -> validation.validate(new UserRegisterArgs(dto, this.repository)));
        return UserMapper.fromEntity(this.repository.save(UserMapper.fromRegisterDto(dto)));
    }

    @Transactional(readOnly = true)
    public UserFindByEmailResponseDTO findByEmail(String email) {
        User entity = this.repository.findByEmailOrThrowNotFound(email);
        return new UserFindByEmailResponseDTO(entity.getId(), entity.getName(), entity.getEmail());
    }

    @Transactional(readOnly = true)
    public boolean authentication(UserAuthenticationRequestDTO dto) {
        User entity = this.repository.findByEmailOrThrowNotFound(dto.getEmail());
        return entity.getPassword().equals(dto.getPassword());
    }
}
