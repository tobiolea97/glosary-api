package com.mule.daily.practice.apigateway.dto;

import lombok.Data;

@Data
public class SignInDto {
    private String username;
    private String password;
}
