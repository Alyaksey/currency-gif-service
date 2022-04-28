package com.example.currencygifservice.config;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix="oxr")
@Getter
@Setter
public class OXRProperty {
    @NotBlank
    private String appId;
    @URL
    private String url;
    @NotBlank
    private String base;
}
