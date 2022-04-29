package com.example.currencygifservice.services;

import com.example.currencygifservice.client.GiphyClient;
import com.example.currencygifservice.config.GiphyProperty;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GifService {
    private final GiphyClient giphyClient;
    private final GiphyProperty giphyProperty;

    public String getGifUrl(String tag) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(giphyClient.getRandomGif(giphyProperty.getApiKey(), tag), JsonObject.class);
        return jsonObject
                .getAsJsonObject("data")
                .getAsJsonObject("images")
                .getAsJsonObject("downsized")
                .get("url")
                .getAsString();
    }
}
