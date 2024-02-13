package com.daily.practice.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("DP-DATA-SERVICE")
public interface ExampleInterface {

    @GetMapping("/expression/{expressionId}")
    public ResponseEntity<?> getExample(@PathVariable int expressionId);

}
