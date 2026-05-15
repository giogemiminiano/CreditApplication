package com.example.credit.application.service;

import com.example.credit.domain.exception.GetCreditApplicationException;
import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.model.CreditStatus;
import com.example.credit.domain.port.out.CreditApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetCreditApplicationServiceTest {

    @Mock
    private CreditApplicationRepository repository;

    @InjectMocks
    private GetCreditApplicationService service;

    @Test
    void getCreditApplicationTestSuccess(){
        CreditApplication credit = this.generateCreditApplication();
        Optional<CreditApplication> list = Optional.of(credit);

        when(repository.findById(any(UUID.class))).thenReturn(list);

        CreditApplication result = service.getApplicationById(UUID.randomUUID());

        assertNotNull(result);
    }

    @Test
    void getCreditApplicationTestFail(){
        assertThrows(GetCreditApplicationException.class,()->service.getApplicationById(UUID.randomUUID()));
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
