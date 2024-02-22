package com.daily.practice.data.repository.contract;

import com.daily.practice.data.domain.Topic;
import com.daily.practice.data.domain.TopicType;

import java.util.List;

public interface ITopicRepository {
    List<Topic> getAllTopics();
    List<Topic> getAllTopicsByUser(int userId);
    List<TopicType> getAllTopicTypes();
}
