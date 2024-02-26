package com.daily.practice.business.service.contract;

import com.daily.practice.business.response.DataResponse_old;

public interface IQuizService {
    DataResponse_old getQuiz(int userId, int topicId);
}
