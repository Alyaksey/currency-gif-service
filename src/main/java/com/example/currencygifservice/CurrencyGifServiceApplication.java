package com.example.currencygifservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CurrencyGifServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyGifServiceApplication.class, args);
    }

}
