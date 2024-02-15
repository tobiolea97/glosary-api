package com.daily.practice.business.service;

import com.daily.practice.business.feign.contract.IDataExternalService;
import com.daily.practice.business.service.contract.IWelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WelcomeService implements IWelcomeService {
    @Autowired
    IDataExternalService dataExternalService;
    @Override
    public Object getWelcomeScreenData() {
        return dataExternalService.getTopics();
    }
}
