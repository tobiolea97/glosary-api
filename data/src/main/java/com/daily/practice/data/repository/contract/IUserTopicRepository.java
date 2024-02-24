package com.daily.practice.data.repository.contract;

import com.daily.practice.data.domain.UserTopic;

public interface IUserTopicRepository {
    UserTopic create(int userId, int topicId);
}
