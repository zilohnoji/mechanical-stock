package com.donatoordep.mechanical_api.repositories;

import com.donatoordep.mechanical_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepositorySpecification extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE UPPER(u.email) LIKE UPPER(CONCAT('%', :email, '%'))")
    Optional<User> findByEmail(String email);
}