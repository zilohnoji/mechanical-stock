package com.donatoordep.mechanical_api.dtos.request;

public final class UserRegisterRequestDTO {
    private String name;
    private String email;
    private String password;

    private UserRegisterRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}