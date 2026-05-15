package com.example.credit.application.service;

import com.example.credit.domain.exception.GetCreditApplicationException;
import com.example.credit.domain.exception.InvalidStatusTransitionException;
import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.port.in.GetCreditApplicationUseCase;
import com.example.credit.domain.port.out.CreditApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCreditApplicationService implements GetCreditApplicationUseCase {

    private final CreditApplicationRepository creditApplicationRepository;


    @Override
    public CreditApplication getApplicationById(UUID id){
        return creditApplicationRepository.findById(id).orElseThrow(()->
                new GetCreditApplicationException(id.toString()));
    }
}
