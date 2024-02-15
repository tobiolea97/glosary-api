package com.daily.practice.business.feign;

import com.daily.practice.business.feign.contract.IDataExternalService;
import com.daily.practice.business.feign.contract.IDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataService implements IDataService {

    private final IDataExternalService externalDataService;


    @Override
    public ResponseEntity getTopics() {
        return externalDataService.getTopics();
    }

    @Override
    public ResponseEntity getTopicTypes() {
        return externalDataService.getTopics();
    }
}
