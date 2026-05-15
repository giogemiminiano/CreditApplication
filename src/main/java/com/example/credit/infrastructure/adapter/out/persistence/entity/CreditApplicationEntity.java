package com.example.credit.infrastructure.adapter.out.persistence.entity;

import com.example.credit.domain.model.CreditStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="credit_applications")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditApplicationEntity {

    @Id
    private UUID id;
    @Column(name="customer_name")
    private String customerName;
    @Column(name="customer_email")
    private String customerEmail;
    @Column(name="customer_rfc")
    private String customerRFC;
    @Column(name="requested_amount")
    private BigDecimal requestedAmount;
    @Column(name="currency")
    private String currency;
    @Column(name="term_months")
    private Integer termMonths;
    @Column(name="annual_interest_rate")
    private BigDecimal annualInterestRate;
    @Column(name="monthly_payment")
    private BigDecimal monthlyPayment;
    @Column(name="total_to_pay")
    private BigDecimal totalToPay;
    @Column(name="amount_usd")
    private BigDecimal amountUSD;
    @Column(name="amount_eur")
    private BigDecimal amountEUR;
    @Column(name="exchange_rate_date")
    private LocalDate exchangeRateDate;
    @Enumerated(EnumType.STRING)
    private CreditStatus status;
    @Column(name="status_reason")
    private String statusReason;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
