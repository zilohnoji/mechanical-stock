package com.donatoordep.mechanical_api.services.validations.user.register.validations;

import com.donatoordep.mechanical_api.exceptions.ONBPasswordMinimumCharactersException;
import com.donatoordep.mechanical_api.services.validations.user.register.UserRegisterArgs;
import com.donatoordep.mechanical_api.services.validations.user.register.UserRegisterValidation;
import org.springframework.stereotype.Component;

@Component
public class PasswordNotContainsEightCharactersValidation implements UserRegisterValidation {

    @Override
    public void validate(UserRegisterArgs args) {
        if (args.dto().getPassword().length() < 8) {
            throw new ONBPasswordMinimumCharactersException();
        }
    }
}
