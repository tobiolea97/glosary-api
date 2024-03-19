package com.mule.daily.practice.apigateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SignUpDto {
    private String username;
    private String password;
}
