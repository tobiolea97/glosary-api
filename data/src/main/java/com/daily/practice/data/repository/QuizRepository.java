package com.daily.practice.data.repository;

import com.daily.practice.data.domain.Example;
import com.daily.practice.data.domain.QuizItem;
import com.daily.practice.data.repository.contract.IQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuizRepository implements IQuizRepository {
    private final String GET_QUIZ_LIST_FOR_USER_AND_TOPIC =
            "SELECT TOP 10 exp.id AS expression_id, exa.id AS example_id, sentence, alternative_answer_1," +
            "              wrong_answer_1, wrong_answer_2, wrong_answer_3, wrong_answer_4" +
            "  FROM USER_EXPRESSIONS uex, EXPRESSIONS exp, EXAMPLES exa, GAPS gap" +
            " WHERE user_id = ?" +
            "   AND score < 5" +
            "   AND learn = true" +
            "   AND uex.expression_id = exp.id" +
            "   AND exp.id = exa.expression_id" +
            "   AND exa.id = gap.example_id" +
            "   AND exp.topic_type_id = ?" +
            "  ORDER BY LAST_COMPLETED ASC, SCORE ASC";
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<QuizItem> getQuizItemsForUserAndTopic(int userId, int topicId) {
        return jdbcTemplate.query(GET_QUIZ_LIST_FOR_USER_AND_TOPIC, new Object[]{userId, topicId}, (rs, rowNum) ->
            new QuizItem(
                rs.getInt("expression_id"),
                rs.getInt("example_id"),
                rs.getString("sentence"),
                rs.getString("alternative_answer_1"),
                rs.getString("wrong_answer_1"),
                rs.getString("wrong_answer_2"),
                rs.getString("wrong_answer_3"),
                rs.getString("wrong_answer_4")
            )
        );
    }
}
