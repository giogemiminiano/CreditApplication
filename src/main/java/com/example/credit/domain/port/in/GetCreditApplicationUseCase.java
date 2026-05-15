package com.example.credit.domain.port.in;

import com.example.credit.domain.model.CreditApplication;

import java.util.UUID;

public interface GetCreditApplicationUseCase {


    CreditApplication getApplicationById(UUID id);
}
