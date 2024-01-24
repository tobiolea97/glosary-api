package com.daily.practice.data.repository;

import com.daily.practice.data.domain.User;
import com.daily.practice.data.repository.contract.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository implements IUserRepository {
    private final String updateUserQuery = "UPDATE users SET first_name = ?, last_name = ?, questions_per_quiz = ? WHERE id = ?";
    private final JdbcTemplate jdbcTemplate;
    @Override
    public User update(User user) {
        jdbcTemplate.update(updateUserQuery, user.getFirstName(), user.getLastName(), user.getQuestionsPerQuiz(), user.getId());
        return user;
    }
}
