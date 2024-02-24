package com.daily.practice.business.service.contract;

import com.daily.practice.business.response.DataResponse_old;

public interface IHomeService {
    DataResponse_old getStats(int userId);
}
