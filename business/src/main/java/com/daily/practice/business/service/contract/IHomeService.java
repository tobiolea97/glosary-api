package com.daily.practice.business.service.contract;

import com.daily.practice.business.response.DataResponse;

public interface IHomeService {
    DataResponse getStats(int userId);
}
