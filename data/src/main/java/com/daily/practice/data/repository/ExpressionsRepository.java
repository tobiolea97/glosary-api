package com.daily.practice.data.repository;

import com.daily.practice.data.domain.Expression;
import com.daily.practice.data.repository.contract.IExpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExpressionsRepository implements IExpressionRepository {
    private final String getNewExpressionsForUserQuery =    "SELECT * " +
            "  FROM expressions e " +
            "LEFT JOIN user_expressions ue ON e.id = ue.expression_id " +
            " WHERE ue.expression_id IS NULL " +
            "   AND e.topic_type_id IN (SELECT topic_type_id FROM user_topics WHERE user_id = ?)";

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Expression> getNewExpressionsForUser(int userId, int amount) {
        return null;
    }
}
