package com.mule.daily.practice.apigateway.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {
    private int id;
    private String username;
    private String password;
    private List<Role> roles;
}
