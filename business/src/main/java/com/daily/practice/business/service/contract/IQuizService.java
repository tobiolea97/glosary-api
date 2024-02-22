package com.daily.practice.business.service.contract;

import com.daily.practice.business.response.DataResponse;

public interface IQuizService {
    DataResponse getQuiz(int userId, int topicId);
}
