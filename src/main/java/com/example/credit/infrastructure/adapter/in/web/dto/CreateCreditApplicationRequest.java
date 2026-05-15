package com.example.credit.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateCreditApplicationRequest(

    @NotBlank
    @Size(min=3,max=120)
    String customerName,

    @NotBlank
    @Email
    String customerEmail,

    @Size(min=12,max=13)
    String customerRFC,

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("5000000.00")
    BigDecimal requestedAmount,

    @NotBlank
    String currency,

    @NotNull
    @Min(6)
    @Max(60)
    Integer termMonths,

    @NotNull
    @DecimalMin("0.05")
    @DecimalMax("0.60")
    BigDecimal annualInterestRate
){
}
