package com.donatoordep.mechanical_api.entities;

import com.donatoordep.mechanical_api.builders.entities.UserSpecificationBuilder;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_user")
public final class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    private User() {
    }

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
    }

    public final static class Builder implements UserSpecificationBuilder {
        private String name;
        private String email;
        private String password;

        private Builder() {
        }

        public static UserSpecificationBuilder builder() {
            return new Builder();
        }

        @Override
        public User build() {
            return new User(this);
        }

        @Override
        public UserSpecificationBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public UserSpecificationBuilder email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public UserSpecificationBuilder password(String password) {
            this.password = password;
            return this;
        }
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

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(user.getEmail(), this.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}