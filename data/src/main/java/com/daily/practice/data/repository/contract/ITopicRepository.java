package com.daily.practice.data.repository.contract;

import com.daily.practice.data.domain.Topic;

import java.util.List;

public interface ITopicRepository {
    List<Topic> getAllTopics();
}
