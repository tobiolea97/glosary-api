package com.daily.practice.data.services.contract;

import com.daily.practice.data.response.DataResponse;

public interface IQuizService {
    DataResponse getQuizItemsForUserAndTopic(int userId, int topicId);
}
