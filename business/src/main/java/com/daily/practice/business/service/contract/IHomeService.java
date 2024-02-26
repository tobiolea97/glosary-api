package com.daily.practice.business.service.contract;

import com.daily.practice.business.domain.Stat;
import com.daily.practice.business.response.DataResponse;

import java.util.List;

public interface IHomeService {
    DataResponse<List<Stat>> getStats(int userId);
}
