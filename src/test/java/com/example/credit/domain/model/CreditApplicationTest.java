package com.example.credit.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditApplicationTest {


    @Test
    void testGetterSetter(){
    CreditApplication credit = this.generateCreditApplication();
    assertEquals("Omar",credit.getCustomerName());
    assertEquals("PERJ850101ABC",credit.getCustomerRFC());
    assertEquals("test@mail.com",credit.getCustomerEmail());
    }


    CreditApplication generateCreditApplication(){
        CreditApplication credit = new CreditApplication();
        credit.setId(UUID.randomUUID());
        credit.setCustomerEmail("test@mail.com");
        credit.setCustomerRFC("PERJ850101ABC");
        credit.setCustomerName("Omar");
        credit.setStatus(CreditStatus.CREATED);
        credit.setRequestedAmount(BigDecimal.valueOf(1000));
        credit.setCurrency("MXN");
        credit.setTermMonths(12);
        credit.setAnnualInterestRate(BigDecimal.valueOf(0.18));
        return credit;
    }
}
