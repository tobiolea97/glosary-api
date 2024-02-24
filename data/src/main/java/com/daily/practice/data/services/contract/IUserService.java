package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.User;
import com.daily.practice.data.request.PersistUserRequest;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.response.PersistResponse2;

public interface IUserService {
    PersistResponse2<User> update(PersistUserRequest request);
}
