package com.daily.practice.business.service.contract;

import com.daily.practice.business.domain.QuizItem;
import com.daily.practice.business.response.DataResponse;

import java.util.List;

public interface IQuizService {
    DataResponse<List<QuizItem>> getQuiz(int userId, int topicId);
}
