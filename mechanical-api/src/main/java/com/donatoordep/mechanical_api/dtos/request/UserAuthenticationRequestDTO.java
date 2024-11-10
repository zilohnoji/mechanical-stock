package com.donatoordep.mechanical_api.dtos.request;

public final class UserAuthenticationRequestDTO {
    private String email;
    private String password;

    private UserAuthenticationRequestDTO() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}