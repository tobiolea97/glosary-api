package com.daily.practice.data.repository;

import com.daily.practice.data.domain.Gap;
import com.daily.practice.data.repository.contract.IGapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GapRepository implements IGapRepository {
    private static String SELECT_GAPS_BY_EXAMPLE_ID = "SELECT * FROM gaps WHERE example_id = ?";
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Gap> getGapsByExampleId(int exampleId) {
        return jdbcTemplate.query(SELECT_GAPS_BY_EXAMPLE_ID, new Object[]{exampleId}, (rs, rowNum) ->
                new Gap(
                        rs.getInt("id"),
                        rs.getInt("example_id"),
                        rs.getInt("order_number"),
                        rs.getString("alternative_answer_1"),
                        rs.getString("alternative_answer_2"),
                        rs.getString("alternative_answer_3"),
                        rs.getString("alternative_answer_4"),
                        rs.getString("wrong_answer_1"),
                        rs.getString("wrong_answer_2"),
                        rs.getString("wrong_answer_3"),
                        rs.getString("wrong_answer_4")
                )
        );
    }
}
