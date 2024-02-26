package com.daily.practice.data.repository;

import com.daily.practice.data.domain.UserExpression;
import com.daily.practice.data.repository.contract.IUserExpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserExpressionRepository implements IUserExpressionRepository {
    private final String insertUserExpressionQuery = "INSERT INTO user_expressions (user_id, expression_id, score, last_completed, learn) VALUES (?, ?, ?, ?, ?)";
    private final String updateUserExpressionQuery = "UPDATE user_expressions SET score = ?, last_completed = ?, learn = ? WHERE user_id = ? AND expression_id = ?";
    private final String getUserExpressionQuery = "SELECT expression_id, user_id, score, last_completed, learn FROM user_expressions WHERE user_id = ?";
    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserExpression create(UserExpression userExpression) {
        jdbcTemplate.update(
                insertUserExpressionQuery,
                userExpression.getUserId(),
                userExpression.getExpressionId(),
                userExpression.getScore(),
                userExpression.getLastCompleted(),
                userExpression.isLearn()
        );
        return userExpression;
    }

    @Override
    public UserExpression update(UserExpression userExpression) {
        jdbcTemplate.update(
                updateUserExpressionQuery,
                userExpression.getScore(),
                userExpression.getLastCompleted(),
                userExpression.isLearn(),
                userExpression.getUserId(),
                userExpression.getExpressionId()
        );
        return userExpression;
    }

    @Override
    public List<UserExpression> getByUserId(int userId) {
        return jdbcTemplate.query(getUserExpressionQuery, new Object[]{userId}, (rs, rowNum) ->
            new UserExpression(
                    rs.getInt("expression_id"),
                    rs.getInt("user_id"),
                    rs.getInt("score"),
                    (rs.getDate("last_completed") == null ? null : rs.getDate("last_completed").toLocalDate()),
                    rs.getBoolean("learn")
            ));
    }


}
