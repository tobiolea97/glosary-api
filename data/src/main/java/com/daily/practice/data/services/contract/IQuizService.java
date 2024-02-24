package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.QuizItem;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;

import java.util.List;

public interface IQuizService {
    DataResponse2<List<QuizItem>> getQuizItemsForUserAndTopic(int userId, int topicId);
}
