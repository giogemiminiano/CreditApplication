package com.example.credit.domain.service;

import com.example.credit.domain.exception.InvalidStatusTransitionException;
import com.example.credit.domain.model.CreditStatus;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Slf4j
public class CreditCalculator {

    private static final MathContext matchContext =  new MathContext(10,RoundingMode.HALF_UP);

    public static void validateStatusChange(String status, String newStatus){
        boolean isChanged = false;
        switch (status){
            case "CREATED":
                if(newStatus.equals(CreditStatus.UNDER_REVIEW.name())
                    ||newStatus.equals(CreditStatus.CANCELLED.name())){
                    isChanged = true;
                }
                break;
            case "UNDER_REVIEW":
                if(newStatus.equals(CreditStatus.APPROVED.name())
                    ||newStatus.equals(CreditStatus.REJECTED.name())
                    ||newStatus.equals(CreditStatus.CANCELLED.name())){
                    isChanged = true;
                }
                break;
            default:
                break;
        }
        if(!isChanged){
            throw new InvalidStatusTransitionException(status, newStatus);
        }
    }


    public static BigDecimal getMonthlyPayment(Integer termMonths,BigDecimal annualInterestRate, BigDecimal requestedAmount){
        BigDecimal monthlyPayment;
        BigDecimal monthlyRate = annualInterestRate.divide(new BigDecimal(12),10,RoundingMode.HALF_UP);
        double divisor = 1- Math.pow(1+monthlyRate.doubleValue(),-termMonths);
        monthlyPayment = requestedAmount.multiply(monthlyRate).divide(BigDecimal.valueOf(divisor),matchContext);
        return monthlyPayment;
    }

    public static BigDecimal getTotalToPay(BigDecimal monthlyPayment,Integer termMonths){
        return monthlyPayment.multiply(BigDecimal.valueOf(termMonths),matchContext);
    }
}
