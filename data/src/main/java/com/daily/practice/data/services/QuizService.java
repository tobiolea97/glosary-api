package com.daily.practice.data.services;

import com.daily.practice.data.domain.QuizItem;
import com.daily.practice.data.repository.contract.IQuizRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.IQuizService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import com.daily.practice.data.utils.errors.ErrorCodes;
import com.daily.practice.data.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService implements IQuizService {
    private final IQuizRepository quizRepository;
    @Override
    public DataResponse<List<QuizItem>> getQuizItemsForUserAndTopic(int userId, int topicId) {
        DataResponse<List<QuizItem>> dataResponse = new DataResponse<>();
        try {
            List<QuizItem> quizItems = quizRepository.getQuizItemsForUserAndTopic(userId, topicId);
            dataResponse = new DataResponse<>(Results.OK, null, quizItems, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }
}
