package com.daily.practice.data.repository.contract;

import com.daily.practice.data.domain.Gap;

import java.util.List;

public interface IGapRepository {
    List<Gap> getGapsByExampleId(int exampleId);
}
