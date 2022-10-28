package com.telustimesheet.telus.config.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class TelusResponse<T> implements Serializable {

    private String status;
    private String code;
    private String message;
    private T data;

    public TelusResponse() {
        super();
    }

    public TelusResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public TelusResponse(String status, String code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
