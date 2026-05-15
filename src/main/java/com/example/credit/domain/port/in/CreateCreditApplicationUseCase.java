package com.example.credit.domain.port.in;

import com.example.credit.domain.model.CreditApplication;

public interface CreateCreditApplicationUseCase {

    CreditApplication create(CreditApplication creditApplication);
}
