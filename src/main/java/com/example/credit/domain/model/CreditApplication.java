package com.example.credit.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreditApplication {
    private UUID id;
    private String customerName;
    private String customerEmail;
    private String customerRFC;
    private BigDecimal requestedAmount;
    private String currency;
    private Integer termMonths;
    private BigDecimal annualInterestRate;
    private BigDecimal monthlyPayment;
    private BigDecimal totalToPay;
    private BigDecimal amountUSD;
    private BigDecimal amountEUR;
    private LocalDate exchangeRateDate;
    private CreditStatus status;
    private String statusReason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
