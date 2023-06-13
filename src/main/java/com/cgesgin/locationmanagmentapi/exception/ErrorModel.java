package com.cgesgin.locationmanagmentapi.exception;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorModel implements Serializable {
    private String message;
    private String code;
}
