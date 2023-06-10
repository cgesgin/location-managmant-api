package com.cgesgin.locationmanagmentapi.exception;

import lombok.Data;

@Data
public class ErrorModel {
    private String message;
    private String code;
}
