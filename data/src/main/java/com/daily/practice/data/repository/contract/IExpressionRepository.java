package com.daily.practice.data.repository.contract;

import com.daily.practice.data.domain.Expression;

import java.util.List;

public interface IExpressionRepository {
    List<Expression> getNewExpressionsForUser(int userId, int amount);
    Expression getExpressionById(int expressionId);
}
