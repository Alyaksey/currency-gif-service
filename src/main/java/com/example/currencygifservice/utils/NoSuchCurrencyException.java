package com.example.currencygifservice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchCurrencyException extends RuntimeException {
    public NoSuchCurrencyException() {
        super("There's no such currency!");
    }
}
