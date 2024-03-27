package com.example.emsbackend.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmsCoustomException extends RuntimeException{
    private String error_text;
    private String error_code;

    public EmsCoustomException(String error_text, String error_code) {
        super();
        this.error_text = error_text;
        this.error_code = error_code;
    }

    public EmsCoustomException(String error_text) {
        this.error_text = error_text;
    }
}
