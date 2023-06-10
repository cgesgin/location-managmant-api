package com.cgesgin.locationmanagmentapi.exception;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class BusinessException extends Exception {

    private List<ErrorModel> errors;

    public BusinessException(List<ErrorModel> errors) {
        this.errors = errors;
    }

}