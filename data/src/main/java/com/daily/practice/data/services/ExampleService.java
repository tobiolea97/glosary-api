package com.daily.practice.data.services;

import com.daily.practice.data.domain.Example;
import com.daily.practice.data.domain.Expression;
import com.daily.practice.data.repository.contract.IExampleRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;
import com.daily.practice.data.services.contract.IExampleService;
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
public class ExampleService implements IExampleService {
    private final IExampleRepository exampleRepository;
    @Override
    public DataResponse2<List<Example>> getExpressionExamples(int expressionId) {
        DataResponse2<List<Example>> dataResponse = new DataResponse2<>();
        try {
            List<Example> examples = exampleRepository.getExpressionExamples(expressionId);
            dataResponse = new DataResponse2(Results.OK, null, examples, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }

    /*
    @Override
    public DataResponse2<List<Example>> getExpressionExamples2(int expressionId) {
        DataResponse2<List<Example>> dataResponse = new DataResponse2();
        try {
            List<Example> examples = exampleRepository.getExpressionExamples(expressionId);
            dataResponse = new DataResponse2<>(Results.OK, null, examples, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            //dataResponse = Tools.getDataResponseError(e, "");
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse2<Example> getExpressionExamples3(int expressionId) {
        DataResponse2<Example> dataResponse = new DataResponse2();
        try {
            List<Example> examples = exampleRepository.getExpressionExamples(expressionId);
            dataResponse = new DataResponse2<>(Results.OK, null, examples.get(0), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            //dataResponse = Tools.getDataResponseError(e, "");
        } finally {
            return dataResponse;
        }
    }
    */
}
