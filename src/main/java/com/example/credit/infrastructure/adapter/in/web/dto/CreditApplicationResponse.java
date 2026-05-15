package com.example.credit.infrastructure.adapter.in.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreditApplicationResponse (
        UUID id,
        String customerName,
        String customerEmail,
        BigDecimal requestedAmount,
        String currency,
        Integer termMonths,
        BigDecimal annualInterestRate,
        BigDecimal monthlyPayment,
        BigDecimal totalToPay,
        BigDecimal amountUSD,
        BigDecimal amountEUR,
        String status,
        LocalDateTime createdAt
){
}
