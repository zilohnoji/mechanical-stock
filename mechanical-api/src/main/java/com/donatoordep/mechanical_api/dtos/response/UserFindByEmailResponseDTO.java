package com.donatoordep.mechanical_api.dtos.response;


public final class UserFindByEmailResponseDTO {
    private Long id;
    private String name;
    private String email;

    public UserFindByEmailResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}