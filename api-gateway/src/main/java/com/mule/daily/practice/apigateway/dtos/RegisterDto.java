package com.mule.daily.practice.apigateway.dtos;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
}
