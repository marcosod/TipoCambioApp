package com.mbravov.cambioapp.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TipoCambioExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public TipoCambioExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus= httpStatus;
    }
}
