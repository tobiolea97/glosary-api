package com.daily.practice.business.external.service.response;

import com.daily.practice.business.domain.Expression;
import com.daily.practice.business.domain.TopicType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetExpressionsResponse extends APIGetResponse {
    @JsonProperty("data")
    private List<Expression> expressions;

    @Override
    public List<?> getData() {
        return expressions;
    }
}
