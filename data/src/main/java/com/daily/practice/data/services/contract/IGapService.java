package com.daily.practice.data.services.contract;

import com.daily.practice.data.response.DataResponse;

public interface IGapService {
    DataResponse getGapsByExampleId(int exampleId);
}
