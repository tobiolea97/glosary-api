package com.daily.practice.data.services.contract;

import com.daily.practice.data.request.PersistUserRequest;
import com.daily.practice.data.response.PersistResponse;

public interface IUserService {
    PersistResponse update(PersistUserRequest request);
}
