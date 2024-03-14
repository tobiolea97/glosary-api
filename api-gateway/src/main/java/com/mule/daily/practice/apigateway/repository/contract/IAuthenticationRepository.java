package com.mule.daily.practice.apigateway.repository.contract;

import com.mule.daily.practice.apigateway.domain.Authentication;

public interface IAuthenticationRepository {
    Authentication getAuthentication(String username);
}
