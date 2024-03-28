package com.mule.daily.practice.apigateway.controller;

import com.mule.daily.practice.apigateway.domain.User;
import com.mule.daily.practice.apigateway.dto.SignInDto;
import com.mule.daily.practice.apigateway.dto.SignUpDto;
import com.mule.daily.practice.apigateway.repository.contract.IAuthenticationRepository;
import com.mule.daily.practice.apigateway.security.JwtUtil;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthenticationRepository authenticationRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private ReactiveAuthenticationManager authenticationManager;
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

    /*@PostMapping("/signin")
    public ResponseEntity<String> login(@RequestBody SignInDto signIn) {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(signIn.getUsername(), signIn.getPassword());
            authenticationManager.authenticate(authentication);
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
        }
    }*/

    @PostMapping("/signin")
    public Mono<ResponseEntity<String>> login(@RequestBody SignInDto signIn) {
        JwtUtil jwtUtil = new JwtUtil();
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(signIn.getUsername(), signIn.getPassword());
            return authenticationManager.authenticate(authentication)
                    .map(auth -> {
                        String token = jwtUtil.generateToken(signIn.getUsername());
                        return ResponseEntity.ok().header("Authorization", "Bearer " + token).body("Login successful");
                    })
                    .onErrorResume(e -> Mono.just(new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED)));
        } catch (Exception e) {
            return Mono.just(new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED));
        }
    }
}
