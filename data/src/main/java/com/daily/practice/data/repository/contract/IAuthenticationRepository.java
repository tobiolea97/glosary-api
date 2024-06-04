package com.daily.practice.data.repository.contract;

import com.daily.practice.data.domain.security.User;

public interface IAuthenticationRepository {
    User getAuthentication(String username);
    boolean existsByUsername(String username);
    User save(User user);
}
