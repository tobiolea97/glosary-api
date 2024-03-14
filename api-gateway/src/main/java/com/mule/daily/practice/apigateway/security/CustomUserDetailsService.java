package com.mule.daily.practice.apigateway.security;

import com.mule.daily.practice.apigateway.domain.Authentication;
import com.mule.daily.practice.apigateway.domain.Role;
import com.mule.daily.practice.apigateway.repository.contract.IAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final IAuthenticationRepository authenticationRepository;
    public Collection<GrantedAuthority> mapToAuthorities(List<Role> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Authentication authentication = authenticationRepository.getAuthentication(username);
            return new User(authentication.getUsername(), authentication.getPassword(), mapToAuthorities(authentication.getRoles()));
        } catch(Exception e) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
