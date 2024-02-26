package com.daily.practice.business.response;

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
public class PersistResponse_old {
    private String result;
    private Object errors;
    private Object persistedObject;
    @JsonIgnore
    private HttpStatus status;
}
