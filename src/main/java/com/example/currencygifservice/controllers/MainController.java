package com.example.currencygifservice.controllers;

import com.example.currencygifservice.services.ExchangeRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ExchangeRatesService exchangeRatesService;

    @RequestMapping("/")
    public String welcome() {
        return "home";
    }

    @PostMapping(path = "/rate")
    public String count(@RequestParam String currency, Model model) {
        model.addAttribute("gifUrl", exchangeRatesService.calculate(currency));
        return "currency";
    }
}
