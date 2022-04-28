package com.example.currencygifservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangeRatesClient", url = "${oxr.url}")
public interface ExchangeRatesClient {
    @GetMapping("/historical/{date}.json")
    String getHistorical(@RequestParam String app_id, @PathVariable String date,
                         @RequestParam String symbols, @RequestParam String base);
}
