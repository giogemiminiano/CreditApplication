package com.example.credit.application.service;

import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.port.in.ListCreditApplicationUseCase;
import com.example.credit.domain.port.out.CreditApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListCreditApplicationsService implements ListCreditApplicationUseCase {

    private final CreditApplicationRepository creditApplicationRepository;

    @Override
    public List<CreditApplication> findAll(){
        return creditApplicationRepository.findAll();
    }
}
