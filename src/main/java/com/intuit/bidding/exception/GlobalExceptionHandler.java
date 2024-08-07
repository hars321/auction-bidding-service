package com.intuit.bidding.exception;

import com.intuit.bidding.core.entity.ApiResponse;
import com.intuit.bidding.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {
        return ResponseUtil.errorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
