package com.example.credit.application.service;

import com.example.credit.domain.exception.GetCreditApplicationException;
import com.example.credit.domain.exception.InvalidStatusTransitionException;
import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.model.CreditStatus;
import com.example.credit.domain.port.in.ChangeStatusUseCase;
import com.example.credit.domain.port.out.CreditApplicationRepository;
import com.example.credit.domain.service.CreditCalculator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChangeStatusService implements ChangeStatusUseCase {

    private final CreditApplicationRepository creditApplicationRepository;


    @Override
    public boolean changeStatus(UUID id, String requestStatus, String reason) {
        Optional<CreditApplication> creditApplication = creditApplicationRepository.findById(id);
        if(creditApplication.isEmpty()){
            throw new GetCreditApplicationException(id.toString());
        }
        else {
            CreditApplication application = creditApplication.get();
            log.info(application.toString());
                CreditCalculator.validateStatusChange(application.getStatus().name(),requestStatus);
                application.setStatus(CreditStatus.valueOf(requestStatus));
                log.info(application.toString());
                creditApplicationRepository.save(application);
        }
        return true;
    }
}
