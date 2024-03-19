package com.mule.daily.practice.apigateway.repository;

import com.mule.daily.practice.apigateway.domain.Authentication;
import com.mule.daily.practice.apigateway.domain.User;
import com.mule.daily.practice.apigateway.repository.contract.IAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class AuthenticationRepository implements IAuthenticationRepository {
    private final String GET_AUTHENTICATION = "SELECT * FROM authentication WHERE username = ?";
    private final String EXISTS_BY_USERNAME = "SELECT count(*) FROM authentication WHERE username = ?";
    private final String SAVE = "INSERT INTO authentication (username, password) VALUES (?, ?)";
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

    @Override
    public boolean existsByUsername(String username) {
        return jdbcTemplate.queryForObject(EXISTS_BY_USERNAME, new String[]{username}, Integer.class) > 0;
    }

    @Override
    public User save(User user) {
        jdbcTemplate.update(SAVE, user.getUsername(), user.getPassword());
        return user;
    }


}
