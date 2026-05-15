package com.example.credit.domain.port.out;

import com.example.credit.domain.model.CreditApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CreditApplicationRepository {
    CreditApplication save(CreditApplication creditApplication);
    Optional<CreditApplication> findById(UUID ID);

    List<CreditApplication> findAll();

}
