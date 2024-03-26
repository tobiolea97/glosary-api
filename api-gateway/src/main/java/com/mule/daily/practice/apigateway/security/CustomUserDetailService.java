package com.mule.daily.practice.apigateway.security;

import com.mule.daily.practice.apigateway.repository.contract.IAuthenticationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements ReactiveUserDetailsService {
    private IAuthenticationRepository authenticationRepository;

    @Autowired
    public CustomUserDetailService(IAuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        com.mule.daily.practice.apigateway.domain.User user = authenticationRepository.getAuthentication(username);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
        return Mono.just(userDetails);
    }
}
