package com.donatoordep.mechanical_api.services.validations.user.register.validations;

import com.donatoordep.mechanical_api.exceptions.ONBEmailHasExistsOnDatabaseException;
import com.donatoordep.mechanical_api.services.validations.user.register.UserRegisterArgs;
import com.donatoordep.mechanical_api.services.validations.user.register.UserRegisterValidation;
import org.springframework.stereotype.Component;

@Component
public class EmailHasExistsValidation implements UserRegisterValidation {

    @Override
    public void validate(UserRegisterArgs args) {
        if (args.repository().findByEmail(args.dto().getEmail()).isPresent()) {
            throw new ONBEmailHasExistsOnDatabaseException();
        }
    }
}
