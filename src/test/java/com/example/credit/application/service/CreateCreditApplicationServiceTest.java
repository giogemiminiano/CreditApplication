package com.example.credit.application.service;


import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.model.ExchangeRate;
import com.example.credit.domain.port.out.CreditApplicationRepository;
import com.example.credit.infrastructure.adapter.out.external.FrankfurterExchangeRateAdapter;
import com.example.credit.infrastructure.adapter.out.external.dto.FrankfurterResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCreditApplicationServiceTest {


    @Mock
    private CreditApplicationRepository repository;

    @Mock
    private FrankfurterExchangeRateAdapter adapter;

    @InjectMocks
    private CreateCreditApplicationService service;


    @Test
    void createCreditApplicationSuccessTest(){
        CreditApplication credit = this.generateCreditApplication();

        ExchangeRate exchangeRate = new ExchangeRate(LocalDate.now(),BigDecimal.valueOf(11.11),BigDecimal.valueOf(12.12));

        when(adapter.listRates()).thenReturn(exchangeRate);

        when(repository.save(any(CreditApplication.class))).thenReturn(credit);

        CreditApplication creditApplication = service.create(credit);

        assertNotNull(creditApplication);

    }



    @Test
    void createCreditApplicationFrankFurtFails(){

        CreditApplication credit = this.generateCreditApplication();

        when(repository.save(any(CreditApplication.class))).thenReturn(credit);

        when(adapter.listRates()).thenThrow(new RuntimeException("Frank furter down"));
        CreditApplication creditApplication = service.create(credit);

        assertNotNull(creditApplication);

    }

    CreditApplication generateCreditApplication(){
        CreditApplication credit = new CreditApplication();
        credit.setCustomerEmail("test@mail.com");
        credit.setCustomerRFC("PERJ850101ABC");
        credit.setCustomerName("Omar");
        credit.setRequestedAmount(BigDecimal.valueOf(1000));
        credit.setCurrency("MXN");
        credit.setTermMonths(12);
        credit.setAnnualInterestRate(BigDecimal.valueOf(0.18));
        return credit;
    }

}
