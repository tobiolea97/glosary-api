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
    private final String GET_AUTHENTICATION = "SELECT * FROM users WHERE username = ?";
    private final String EXISTS_BY_USERNAME = "SELECT count(*) FROM users WHERE username = ?";
    private final String SAVE = "INSERT INTO users (first_name, last_name, username, password) VALUES (?,?,?,?)";
    private final JdbcTemplate jdbcTemplate;
    @Override
    public User getAuthentication(String username) {
        return jdbcTemplate.queryForObject(GET_AUTHENTICATION, new Object[]{username}, (rs, rowNum) ->
            new User(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("username"),
                    rs.getString("password")
            ));
    }

    @Override
    public boolean existsByUsername(String username) {
        return jdbcTemplate.queryForObject(EXISTS_BY_USERNAME, new String[]{username}, Integer.class) > 0;
    }

    @Override
    public User save(User user) {
        jdbcTemplate.update(SAVE, user.getFirst_name(), user.getLast_name(), user.getUsername(), user.getPassword());
        return user;
    }


}
