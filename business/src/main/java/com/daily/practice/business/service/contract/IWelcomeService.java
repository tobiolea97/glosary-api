package com.daily.practice.business.service.contract;

import com.daily.practice.business.domain.TopicType;
import com.daily.practice.business.response.DataResponse_old;
import com.daily.practice.business.response.DataResponse;

import java.util.List;

public interface IWelcomeService {
    DataResponse<List<TopicType>> getWelcomeScreenData();
}
