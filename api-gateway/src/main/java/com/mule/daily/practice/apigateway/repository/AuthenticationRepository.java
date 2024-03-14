package com.mule.daily.practice.apigateway.repository;

import com.mule.daily.practice.apigateway.domain.Authentication;
import com.mule.daily.practice.apigateway.repository.contract.IAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class AuthenticationRepository implements IAuthenticationRepository {
    private final String GET_AUTHENTICATION = "SELECT * FROM USERS WHERE username = ?";
    private final JdbcTemplate jdbcTemplate;
    @Override
    public Authentication getAuthentication(String username) {
        return jdbcTemplate.queryForObject(GET_AUTHENTICATION, new Object[]{username}, (rs, rowNum) ->
                new Authentication(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        new ArrayList<>()
                ));
    }
}
