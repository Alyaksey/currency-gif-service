package com.example.currencygifservice.services;

import com.example.currencygifservice.client.ExchangeRatesClient;
import com.example.currencygifservice.config.OXRProperty;
import com.example.currencygifservice.utils.NoSuchCurrencyException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class ExchangeRatesService {
    private final ExchangeRatesClient ratesClient;
    private final OXRProperty oXRProperty;
    private final GifService gifService;

    public String calculate(String currencyCode) {
        LocalDate yesterday = LocalDate.now(ZoneId.of("UTC")).minusDays(1);
        Gson gson = new Gson();
        try {
            double latestCurrency = gson
                    .fromJson(ratesClient.getLatestRates(oXRProperty.getAppId()), JsonObject.class)
                    .getAsJsonObject("rates")
                    .get(currencyCode)
                    .getAsDouble();
            double yesterdayCurrency = gson
                    .fromJson(ratesClient.getHistoricalRates(oXRProperty.getAppId(), yesterday.toString(), currencyCode, oXRProperty.getBase()), JsonObject.class)
                    .getAsJsonObject("rates")
                    .get(currencyCode)
                    .getAsDouble();
            String tag = Double.compare(latestCurrency, yesterdayCurrency) > 0 ? "rich" : "broke";
            return gifService.getGifUrl(tag);
        } catch (NullPointerException ex) {
            throw new NoSuchCurrencyException();
        }
    }
}
