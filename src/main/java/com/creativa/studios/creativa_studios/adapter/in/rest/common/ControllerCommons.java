package com.creativa.studios.creativa_studios.adapter.in.rest.common;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import java.net.http.HttpResponse;

import static org.hibernate.query.results.Builders.entity;

public final class ControllerCommons {
    private ControllerCommons() {}

    public static ResponseEntity<ErrorEntity> clientErrorException(HttpStatus status, String message) {
        return errorResponse(status, message);
    }

    public static ResponseEntity<ErrorEntity> errorResponse(HttpStatus status, String message) {
        ErrorEntity errorEntity = new ErrorEntity(status.value(), message);
        return ResponseEntity.status(status).body(errorEntity);
    }
}
