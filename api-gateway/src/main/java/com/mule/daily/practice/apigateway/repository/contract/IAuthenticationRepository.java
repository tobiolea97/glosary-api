package com.mule.daily.practice.apigateway.repository.contract;

import com.mule.daily.practice.apigateway.domain.Authentication;
import com.mule.daily.practice.apigateway.domain.User;

public interface IAuthenticationRepository {
    User getAuthentication(String username);
    boolean existsByUsername(String username);
    User save(User user);
}
