package com.daily.practice.data.services;

import com.daily.practice.data.domain.UserTopic;
import com.daily.practice.data.repository.contract.IUserTopicRepository;
import com.daily.practice.data.request.CreateUserTopicRequest;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.response.PersistResponse2;
import com.daily.practice.data.services.contract.IUserTopicService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import com.daily.practice.data.utils.errors.ErrorCodes;
import com.daily.practice.data.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UserTopicService implements IUserTopicService {
    private final IUserTopicRepository userTopicRepository;
    @Override
    public PersistResponse2<UserTopic> assignTopicToUser(CreateUserTopicRequest request) {
        PersistResponse2<UserTopic> persistResponse = new PersistResponse2<>();
        try {
            UserTopic userTopic = userTopicRepository.create(request.getUserId(), request.getTopicId());
            persistResponse = new PersistResponse2<>(Results.OK, null, userTopic, HttpStatus.OK);
        } catch(UncategorizedSQLException e) {
            persistResponse = Tools.getBadRequest2(ErrorCodes.SQL_ERROR, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        } catch (Exception e) {
            persistResponse = Tools.getBadRequest2(ErrorCodes.COULD_NOT_SAVE_RECORD, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        } finally {
            return persistResponse;
        }
    }
}
