package com.example.currencygifservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangeRatesClient", url = "${oxr.url}")
public interface ExchangeRatesClient {
    @GetMapping("/historical/{date}.json")
    String getHistoricalRates(@RequestParam("app_id") String appId, @PathVariable String date,
                         @RequestParam String symbols, @RequestParam String base);

    @GetMapping("/latest.json")
    String getLatestRates(
            @RequestParam("app_id") String appId);
}
