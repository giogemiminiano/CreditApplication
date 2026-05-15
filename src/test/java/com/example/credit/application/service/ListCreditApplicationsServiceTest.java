package com.example.credit.application.service;

import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.model.CreditStatus;
import com.example.credit.domain.port.out.CreditApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListCreditApplicationsServiceTest {

    @Mock
    private CreditApplicationRepository repository;

    @InjectMocks
    private ListCreditApplicationsService service;

    @Test
    void ListCreditApplicationTestSuccess(){

        List<CreditApplication> list = new ArrayList<>();
        list.add(this.generateCreditApplication());

        when(repository.findAll()).thenReturn(list);

        assertNotNull(service.findAll());

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
