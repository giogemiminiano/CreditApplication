package com.example.credit.domain.service;

import com.example.credit.domain.exception.InvalidStatusTransitionException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCalculatorTest {

    @Test
    void validateStatusChangeTestSuccess(){
        assertDoesNotThrow(()->CreditCalculator.validateStatusChange("CREATED","UNDER_REVIEW"));
    }


    @Test
    void validateStatusChangeTestFail(){
        assertThrows(InvalidStatusTransitionException.class,()->CreditCalculator.validateStatusChange("Creado","UNDER_REVIEW"));
    }

    @Test
    void getMonthlyPaymentTestSuccess(){
        assertNotEquals(BigDecimal.valueOf(0.0),CreditCalculator.getMonthlyPayment(12,
                BigDecimal.valueOf(12.12),BigDecimal.valueOf(11.11)));
    }

    @Test
    void getTotalToPayTestSuccess(){
        assertNotEquals(BigDecimal.valueOf(0.0),CreditCalculator.getTotalToPay(BigDecimal.valueOf(0.5),6));

    }
}
