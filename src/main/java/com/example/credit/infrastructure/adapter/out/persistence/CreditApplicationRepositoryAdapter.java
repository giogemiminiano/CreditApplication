package com.example.credit.infrastructure.adapter.out.persistence;

import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.port.out.CreditApplicationRepository;
import com.example.credit.infrastructure.adapter.out.persistence.entity.CreditApplicationEntity;
import com.example.credit.infrastructure.adapter.out.persistence.mapper.CreditApplicationMapper;
import com.example.credit.infrastructure.adapter.out.persistence.repository.JpaCreditApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreditApplicationRepositoryAdapter implements CreditApplicationRepository {

    private final JpaCreditApplicationRepository repository;
    private final CreditApplicationMapper creditApplicationMapper;


    @Override
    public CreditApplication save(CreditApplication creditApplication) {
        log.info(creditApplication.toString());
        CreditApplicationEntity creditApplicationEntity = creditApplicationMapper.toEntity(creditApplication);
        log.info(creditApplicationEntity.toString());
        CreditApplicationEntity savedEntity = repository.save(creditApplicationEntity);
        return creditApplicationMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<CreditApplication> findById(UUID id) {
        return repository.findById(id).map(creditApplicationMapper::toDomain);
    }

    @Override
    public List<CreditApplication> findAll() {
        return repository.findAll().stream().map(creditApplicationMapper::toDomain).toList();
    }
}
