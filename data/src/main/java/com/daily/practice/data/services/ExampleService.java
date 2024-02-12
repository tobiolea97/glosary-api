package com.daily.practice.data.services;

import com.daily.practice.data.domain.Example;
import com.daily.practice.data.domain.Expression;
import com.daily.practice.data.repository.contract.IExampleRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.IExampleService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService implements IExampleService {
    private final IExampleRepository exampleRepository;
    @Override
    public DataResponse getExpressionExamples(int expressionId) {
        DataResponse dataResponse = new DataResponse();
        try {
            List<Example> expression = exampleRepository.getExpressionExamples(expressionId);
            dataResponse = new DataResponse(Results.OK, "", expression, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(e, "");
        } finally {
            return dataResponse;
        }
    }
}
