package com.daily.practice.business.service;

import com.daily.practice.business.domain.QuizItem;
import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.service.contract.IQuizService;
import com.daily.practice.business.utils.Results;
import com.daily.practice.business.utils.Tools;
import com.daily.practice.business.utils.errors.ErrorCodes;
import com.daily.practice.business.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService implements IQuizService {
    private final IDataExternalService externalService;
    @Override
    public DataResponse<List<QuizItem>> getQuiz(int userId, int topicId) {
        DataResponse<List<QuizItem>> response;
        // parsers
        try {
            List<QuizItem> quizItems = externalService.getQuizItemsForUserAndTopic(userId, topicId).getBody().getData();

            for(int i = 0; i < quizItems.size(); i++)
                quizItems.get(i).randomizeOptions();

            response = new DataResponse<>(Results.OK, null, quizItems, HttpStatus.OK);
        } catch (Exception e) {
            response = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        }
        return response;
    }
}
