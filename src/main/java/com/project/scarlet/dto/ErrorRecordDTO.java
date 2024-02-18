package com.project.scarlet.dto;

import org.springframework.http.HttpStatus;

public record ErrorRecordDTO(HttpStatus errorCode, String message) {
}
