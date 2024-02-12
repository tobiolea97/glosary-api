package com.daily.practice.data.repository.contract;

import com.daily.practice.data.domain.UserExpression;
import com.daily.practice.data.response.PersistResponse;

import java.util.List;

public interface IUserExpressionRepository {
    UserExpression create(UserExpression userExpression);
    UserExpression update(UserExpression userExpression);
    List<UserExpression> getByUserId(int userId);

}
