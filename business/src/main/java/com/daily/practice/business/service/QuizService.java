package com.daily.practice.business.service;

import com.daily.practice.business.domain.QuizItem;
import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.external.service.response.GetQuizItemsResponse;
import com.daily.practice.business.external.service.response.GetResponseParser;
import com.daily.practice.business.response.DataResponse_old;
import com.daily.practice.business.service.contract.IQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService implements IQuizService {
    private final IDataExternalService externalService;
    @Override
    public DataResponse_old getQuiz(int userId, int topicId) {
        DataResponse_old response = new DataResponse_old();
        GetResponseParser<GetQuizItemsResponse> quizItemGetResponseParser = new GetResponseParser<>();
        // parsers
        try {
            List<QuizItem> quizItems = (List<QuizItem>) quizItemGetResponseParser.getData(externalService.getQuizItemsForUserAndTopic(userId, topicId), GetQuizItemsResponse.class);
            // get quiz
            // here I should prepare the response so that I randomize the order of the answers
            response = new DataResponse_old();
        } catch (Exception e) {
            response = new DataResponse_old();
        } finally {
            return response;
        }
    }
}
