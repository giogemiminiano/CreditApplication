package com.example.credit.infrastructure.adapter.out.external;


import com.example.credit.domain.model.ExchangeRate;
import com.example.credit.domain.port.out.ExchangeRateProvider;
import com.example.credit.infrastructure.adapter.out.external.dto.FrankfurterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FrankfurterExchangeRateAdapter implements ExchangeRateProvider {

    private static final String FRANK_FURTER_URL =
            "https://api.frankfurter.app/latest?from=MXN&to=USD,EUR";

    private final RestTemplate restTemplate;

    @Override
    @Cacheable("exchangeRate")
    public ExchangeRate listRates() {
        FrankfurterResponse frankfurterResponse =  restTemplate.getForObject(FRANK_FURTER_URL,FrankfurterResponse.class);
        if(frankfurterResponse == null){
            throw new RuntimeException("No se logro conectar con frankfurter");
        }
        BigDecimal rateUSD = frankfurterResponse.rates().get("USD");
        BigDecimal rateEUR = frankfurterResponse.rates().get("EUR");
        return ExchangeRate.builder().rateEUR(rateEUR).rateUSD(rateUSD).date(frankfurterResponse.date()).build();
    }
}


