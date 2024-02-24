package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.User;
import com.daily.practice.data.request.PersistUserRequest;
import com.daily.practice.data.response.PersistResponse;

public interface IUserService {
    PersistResponse<User> update(PersistUserRequest request);
}
