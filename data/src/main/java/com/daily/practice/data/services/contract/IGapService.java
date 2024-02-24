package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.Gap;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;

import java.util.List;

public interface IGapService {
    DataResponse2<List<Gap>> getGapsByExampleId(int exampleId);
}
