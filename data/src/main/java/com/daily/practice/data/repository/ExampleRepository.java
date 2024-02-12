package com.daily.practice.data.repository;

import com.daily.practice.data.domain.Example;
import com.daily.practice.data.repository.contract.IExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExampleRepository implements IExampleRepository {
    private final String GET_EXPRESSION_EXAMPLES_QUERY = "SELECT * FROM examples WHERE expression_id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Example> getExpressionExamples(int expressionId) {
        return jdbcTemplate.query(GET_EXPRESSION_EXAMPLES_QUERY, new Object[]{expressionId}, (rs, rowNum) ->
            new Example(
                rs.getInt("id"),
                rs.getInt("expression_id"),
                rs.getString("sentence")
            ));
    }
}
