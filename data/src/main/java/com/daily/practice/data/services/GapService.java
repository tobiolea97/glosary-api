package com.daily.practice.data.services;

import com.daily.practice.data.domain.Example;
import com.daily.practice.data.domain.Gap;
import com.daily.practice.data.repository.contract.IGapRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;
import com.daily.practice.data.services.contract.IGapService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import com.daily.practice.data.utils.errors.ErrorCodes;
import com.daily.practice.data.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GapService implements IGapService {
    private final IGapRepository gapRepository;
    @Override
    public DataResponse2<List<Gap>> getGapsByExampleId(int exampleId) {
        DataResponse2<List<Gap>> dataResponse = new DataResponse2<>();
        try {
            List<Gap> examples = gapRepository.getGapsByExampleId(exampleId);
            dataResponse = new DataResponse2<List<Gap>>(Results.OK, null, examples, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }
}
