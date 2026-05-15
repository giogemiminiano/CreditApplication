package com.example.credit.application.service;

import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.model.CreditStatus;
import com.example.credit.domain.model.ExchangeRate;
import com.example.credit.domain.port.in.CreateCreditApplicationUseCase;
import com.example.credit.domain.port.out.CreditApplicationRepository;
import com.example.credit.domain.port.out.ExchangeRateProvider;
import com.example.credit.domain.service.CreditCalculator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateCreditApplicationService implements CreateCreditApplicationUseCase {

    private final CreditApplicationRepository creditApplicationRepository;
    private final ExchangeRateProvider exchangeRateProvider;
    @Override
    public CreditApplication create(CreditApplication creditApplication) {
        creditApplication.setId(UUID.randomUUID());
        creditApplication.setStatus(CreditStatus.CREATED);
        creditApplication.setCreatedAt(LocalDateTime.now());
        creditApplication.setUpdatedAt(LocalDateTime.now());
        BigDecimal monthlyPayment = CreditCalculator.getMonthlyPayment(creditApplication.getTermMonths(),
                creditApplication.getAnnualInterestRate(),creditApplication.getRequestedAmount());
        creditApplication.setMonthlyPayment(monthlyPayment);
        creditApplication.setTotalToPay(CreditCalculator.getTotalToPay(monthlyPayment,creditApplication.getTermMonths()));
        try {
            ExchangeRate rates = exchangeRateProvider.listRates();
            creditApplication.setAmountUSD(creditApplication.getRequestedAmount().multiply(rates.getRateUSD()).setScale(2, RoundingMode.HALF_UP));
            creditApplication.setAmountEUR(creditApplication.getRequestedAmount().multiply(rates.getRateEUR()).setScale(2, RoundingMode.HALF_UP));
            creditApplication.setExchangeRateDate(rates.getDate());
        }catch (Exception ex){
            log.warn("No se pudo conectar con frankfurter.");
        }
        log.info(creditApplication.toString());
        return creditApplicationRepository.save(creditApplication);
    }
}
