package com.project.scarlet.exception;

import com.project.scarlet.dto.ErrorRecordDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidFieldException.class)
    @ResponseBody
    public ResponseEntity<ErrorRecordDTO> handleInvalidEnumValueException(InvalidFieldException ex) {
        ErrorRecordDTO errorResponse = new ErrorRecordDTO(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}