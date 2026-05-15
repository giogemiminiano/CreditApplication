package com.example.credit.infrastructure.adapter.out.external.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
public record FrankfurterResponse(
        BigDecimal amount,
        String base,
        LocalDate date,
        Map<String,BigDecimal> rates
) {
}

