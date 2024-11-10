package com.donatoordep.mechanical_api.dtos.response;


public final class UserRegisterResponseDTO {
    private Long id;
    private String email;

    public UserRegisterResponseDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}