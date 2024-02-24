package com.daily.practice.business.utils;

import com.daily.practice.business.response.*;
import com.daily.practice.business.utils.errors.AppException;
import org.springframework.http.HttpStatus;

public class Tools {
    public static PersistResponse_old getBadRequest2(String message, String descriptions) {
        return getPersistErrorResponse2(message,descriptions,HttpStatus.UNAUTHORIZED);
    }

    private static PersistResponse_old getPersistErrorResponse2(AppException e, String descriptions, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),e.getDescriptions());
        if(!descriptions.equals(""))
            errorResponse = new ErrorResponse(e.getMessage(),descriptions);
        return new PersistResponse_old(
                Results.ERROR,
                errorResponse,
                "",
                HttpStatus.BAD_REQUEST
        );
    }

    private static PersistResponse_old getPersistErrorResponse2(String message, String descriptions, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(message,descriptions);
        return new PersistResponse_old(
                Results.ERROR,
                errorResponse,
                "",
                HttpStatus.BAD_REQUEST
        );
    }

    public static DataResponse_old getDataResponseError2(String message, String descriptions) {
        ErrorResponse errorResponse = new ErrorResponse(message, descriptions);
        return new DataResponse_old(
                Results.ERROR,
                errorResponse,
                "",
                HttpStatus.BAD_REQUEST
        );
    }

    /**/

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
