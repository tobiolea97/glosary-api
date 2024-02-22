package com.daily.practice.data.repository.contract;

import com.daily.practice.data.domain.QuizItem;

import java.util.List;

public interface IQuizRepository {
    List<QuizItem> getQuizItemsForUserAndTopic(int userId, int topicId);
}
