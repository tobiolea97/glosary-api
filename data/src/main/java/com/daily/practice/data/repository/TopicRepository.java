package com.daily.practice.data.repository;

import com.daily.practice.data.domain.Topic;
import com.daily.practice.data.domain.TopicType;
import com.daily.practice.data.repository.contract.ITopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TopicRepository implements ITopicRepository {
    private final String getAllTopicsQuery = "SELECT id, name, topic_type_id FROM topics";
    private final String getAllTopicsByUser = "SELECT id, name, u.topic_type_id FROM topics t, user_topics u WHERE t.id = u.topic_type_id and u.user_id = ?";
    private final String getAllTopicTypesQuery = "SELECT id, name FROM topic_types";
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Topic> getAllTopics() {
        return jdbcTemplate.query(getAllTopicsQuery, (rs, rowNum) ->
                new Topic(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("topic_type_id")
                )
        );
    }

    @Override
    public List<Topic> getAllTopicsByUser(int userId) {
        return jdbcTemplate.query(getAllTopicsByUser, new Object[]{userId}, (rs, rowNum) ->
                new Topic(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("topic_type_id")
                )
        );
    }

    @Override
    public List<TopicType> getAllTopicTypes() {
        return jdbcTemplate.query(getAllTopicTypesQuery, (rs, rowNum) ->
                new TopicType(
                        rs.getInt("id"),
                        rs.getString("name")
                )
        );
    }


}
