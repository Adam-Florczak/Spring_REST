package com.github.adamflorczak.CurrencyConverter;

import com.github.adamflorczak.CurrencyConverter.ExchangeRate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/curency-exchanges")
public class CurrencyExchangeController {

    RestTemplate restTemplate = new RestTemplate();




    public ExchangeRate getResponse() {
        String currency = "USD";
        String API_ADDRESS = "http://apilayer.net/api/live?access_key=706d265e2874ea57513039bbd7e46a20&format=1";
        return restTemplate.getForObject(
                API_ADDRESS + "&quotes={currency}",
                ExchangeRate.class, currency);
    }

    @GetMapping
    public String exchange(@RequestParam String fromCurr, @RequestParam String toCurr, @RequestParam Double amount ){

        double firstCurrency = getResponse().getQuotes().get("USD" + fromCurr.toUpperCase());
        double secondCurrency = getResponse().getQuotes().get("USD" + toCurr.toUpperCase());
        double fxRate = secondCurrency  / firstCurrency ;
        double result = amount * fxRate;

        return "Przekonwertowałeś " + fromCurr.toUpperCase() + " " + amount + " na " + toCurr.toUpperCase() + " " + result;
       // return BigDecimal.valueOf(result);
    }

}
