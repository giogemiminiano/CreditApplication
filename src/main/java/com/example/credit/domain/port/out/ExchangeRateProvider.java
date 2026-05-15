package com.example.credit.domain.port.out;

import com.example.credit.domain.model.ExchangeRate;

public interface ExchangeRateProvider {
    ExchangeRate listRates();
}
