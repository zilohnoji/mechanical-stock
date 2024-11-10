package com.donatoordep.mechanical_api.controllers;

import com.donatoordep.mechanical_api.dtos.request.UserAuthenticationRequestDTO;
import com.donatoordep.mechanical_api.dtos.request.UserRegisterRequestDTO;
import com.donatoordep.mechanical_api.dtos.response.UserFindByEmailResponseDTO;
import com.donatoordep.mechanical_api.dtos.response.UserRegisterResponseDTO;
import com.donatoordep.mechanical_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.donatoordep.mechanical_api.controllers.UserController.PATH;

@RestController
@RequestMapping(path = PATH)
public class UserController {

    private final UserService SERVICE;
    public final static String PATH = "/users";

    @Autowired
    public UserController(UserService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @PostMapping
    public ResponseEntity<UserRegisterResponseDTO> register(@RequestBody UserRegisterRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(SERVICE.register(request));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserFindByEmailResponseDTO> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok().body(SERVICE.findByEmail(email));
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<Boolean> authentication(@RequestBody UserAuthenticationRequestDTO request) {
        return ResponseEntity.ok().body(SERVICE.authentication(request));
    }
}