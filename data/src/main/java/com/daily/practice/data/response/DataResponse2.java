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
public class DataResponse2<T> {
    private String result;
    private String error;
    private T data;
    @JsonIgnore
    private HttpStatus status;
}
