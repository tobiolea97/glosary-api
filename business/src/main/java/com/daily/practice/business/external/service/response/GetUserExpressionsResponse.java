package com.daily.practice.business.external.service.response;

import com.daily.practice.business.domain.UserExpression;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class GetUserExpressionsResponse extends APIGetResponse {
    @JsonProperty("data")
    private List<UserExpression> userExpressions;

    @Override
    public List<?> getData() {
        return userExpressions;
    }
}
