package com.example.credit.domain.port.in;

import com.example.credit.domain.model.CreditApplication;

import java.util.List;
import java.util.UUID;

public interface ListCreditApplicationUseCase {


    List<CreditApplication> findAll();
}
