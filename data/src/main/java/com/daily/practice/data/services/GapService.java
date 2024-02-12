package com.daily.practice.data.services;

import com.daily.practice.data.domain.Example;
import com.daily.practice.data.domain.Gap;
import com.daily.practice.data.repository.contract.IGapRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.IGapService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GapService implements IGapService {
    private final IGapRepository gapRepository;
    @Override
    public DataResponse getGapsByExampleId(int exampleId) {
        DataResponse dataResponse = new DataResponse();
        try {
            List<Gap> examples = gapRepository.getGapsByExampleId(exampleId);
            dataResponse = new DataResponse(Results.OK, "", examples, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(e, "");
        } finally {
            return dataResponse;
        }
    }
}
