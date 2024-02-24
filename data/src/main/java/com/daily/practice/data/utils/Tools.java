package com.daily.practice.data.utils;

import com.daily.practice.data.response.*;
import org.springframework.http.HttpStatus;

public class Tools {
    public static <T> DataResponse<T> getDataResponseError(String code, String message) {
        ErrorResponse errorResponse = new ErrorResponse(message, message);
        return new DataResponse<T>(
                Results.ERROR,
                errorResponse,
                null,
                HttpStatus.BAD_REQUEST
        );
    }

    public static <T> PersistResponse<T> getBadRequest(String code, String description) {
        return getPersistErrorResponse(code, description, HttpStatus.BAD_REQUEST);
    }

    public static <T> PersistResponse<T> getBadGateway2(String code, String description) {
        return getPersistErrorResponse(code, description, HttpStatus.BAD_GATEWAY);
    }

    private static <T> PersistResponse<T> getPersistErrorResponse(String message, String descriptions, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(message,descriptions);
        return new PersistResponse<T>(
                Results.ERROR,
                errorResponse,
                null,
                httpStatus
        );
    }

}
