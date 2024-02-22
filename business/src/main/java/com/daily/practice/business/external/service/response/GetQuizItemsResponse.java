package com.daily.practice.business.external.service.response;

import com.daily.practice.business.domain.QuizItem;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetQuizItemsResponse extends APIGetResponse {
    @JsonProperty("data")
    private List<QuizItem> quizItems;
    @Override
    public List<?> getData() {
        return quizItems;
    }
}
