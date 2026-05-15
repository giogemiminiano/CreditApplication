package com.example.credit.application.service;

import com.example.credit.domain.exception.InvalidStatusTransitionException;
import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.model.CreditStatus;
import com.example.credit.domain.port.out.CreditApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChangeStatusServiceTest {
    @Mock
    private CreditApplicationRepository repository;

    @InjectMocks
    private ChangeStatusService service;

    @Test
    void changeCreditStatusTestSuccess(){
        CreditApplication credit = this.generateCreditApplication();
        Optional<CreditApplication> list = Optional.of(credit);

        when(repository.findById(any(UUID.class))).thenReturn(list);

        when(repository.save(any(CreditApplication.class))).thenReturn(credit);

        boolean success = service.changeStatus(UUID.randomUUID(),"UNDER_REVIEW","Sin comentario.");
        assertTrue(success);

    }

    @Test
    void changeCreditStatusTestFail(){
        CreditApplication credit = this.generateCreditApplication();
        Optional<CreditApplication> list = Optional.of(credit);
        when(repository.findById(any(UUID.class))).thenReturn(list);
        assertThrows(InvalidStatusTransitionException.class,()->service.changeStatus(UUID.randomUUID(),"CERRADO","Sin comentario."));


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
