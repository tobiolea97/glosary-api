package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.Gap;
import com.daily.practice.data.response.DataResponse;

import java.util.List;

public interface IGapService {
    DataResponse<List<Gap>> getGapsByExampleId(int exampleId);
}
