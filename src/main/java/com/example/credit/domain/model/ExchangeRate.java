package com.example.credit.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ExchangeRate {
    private LocalDate date;
    private BigDecimal rateUSD;
    private BigDecimal rateEUR;
}
