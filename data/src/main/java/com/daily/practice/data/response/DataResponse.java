package com.daily.practice.data.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {
    private String result;
    private Object errors;
    private Object list;
    @JsonIgnore
    private HttpStatus status;
}
