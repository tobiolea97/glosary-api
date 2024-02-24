package com.daily.practice.data.services;

import com.daily.practice.data.domain.User;
import com.daily.practice.data.repository.contract.IUserRepository;
import com.daily.practice.data.request.PersistUserRequest;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.response.PersistResponse2;
import com.daily.practice.data.services.contract.IUserService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import com.daily.practice.data.utils.errors.ErrorCodes;
import com.daily.practice.data.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public PersistResponse2<User> update(PersistUserRequest request) {
        PersistResponse2<User> persistResponse = new PersistResponse2<>();
        User user = new User(request.getId(), request.getFirstName(), request.getLastName(), request.getQuestionsPerQuiz());
        try {
            user = userRepository.update(user);
            persistResponse = new PersistResponse2<>(Results.OK, null, user, HttpStatus.OK);
        } catch(Exception e) {
            persistResponse = Tools.getBadRequest2(ErrorCodes.COULD_NOT_SAVE_RECORD, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        }
        return persistResponse;
    }
}
