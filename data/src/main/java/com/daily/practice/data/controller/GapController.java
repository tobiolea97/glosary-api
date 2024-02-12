package com.daily.practice.data.controller;

import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.IGapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gap")
@RequiredArgsConstructor
public class GapController {
    private final IGapService gapService;
    @GetMapping("/example/{exampleId}")
    public ResponseEntity<?> getExample(@PathVariable int exampleId) {
        DataResponse response = gapService.getGapsByExampleId(exampleId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
