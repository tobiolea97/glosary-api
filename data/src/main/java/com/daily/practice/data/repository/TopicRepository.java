package com.daily.practice.data.repository;

import com.daily.practice.data.domain.Topic;
import com.daily.practice.data.repository.contract.ITopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TopicRepository implements ITopicRepository {
    private final String getAllTopicsQuery = "SELECT id, name, topic_type_id FROM topics";
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
}
