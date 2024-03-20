package com.mule.daily.practice.apigateway.controller;

import com.mule.daily.practice.apigateway.domain.Authentication;
import com.mule.daily.practice.apigateway.domain.User;
import com.mule.daily.practice.apigateway.dto.SignUpDto;
import com.mule.daily.practice.apigateway.repository.contract.IAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthenticationRepository authenticationRepository;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpDto signUpDto) {
        try {
            if(authenticationRepository.existsByUsername(signUpDto.getUsername()))
                throw new RuntimeException("Username already exists");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setFirst_name(signUpDto.getFirstName());
        user.setLast_name(signUpDto.getLastName());
        user.setUsername(signUpDto.getUsername());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        authenticationRepository.save(user);

        return new ResponseEntity<>("The user has been registered", HttpStatus.OK);
    }


}
