package com.daily.practice.data.repository;

import com.daily.practice.data.domain.UserTopic;
import com.daily.practice.data.repository.contract.IUserTopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserTopicRepository implements IUserTopicRepository {
    private final String assignTopicToUserQuery = "INSERT INTO user_topics (user_id, topic_type_id) VALUES (?, ?)";
    private final JdbcTemplate jdbcTemplate;
    @Override
    public UserTopic create(int userId, int topicId) {
        jdbcTemplate.update(assignTopicToUserQuery, userId, topicId);
        return new UserTopic(userId, topicId);
    }
}
