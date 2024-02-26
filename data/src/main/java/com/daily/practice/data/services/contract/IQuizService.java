package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.QuizItem;
import com.daily.practice.data.response.DataResponse;

import java.util.List;

public interface IQuizService {
    DataResponse<List<QuizItem>> getQuizItemsForUserAndTopic(int userId, int topicId);
}
