package com.daily.practice.business.repository.contract;

import com.daily.practice.business.domain.User;

public interface IAuthenticationRepository {
    User getAuthentication(String username);
    boolean existsByUsername(String username);
    User save(User user);
}
