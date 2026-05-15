package com.example.credit.infrastructure.adapter.out.persistence.repository;

import com.example.credit.infrastructure.adapter.out.persistence.entity.CreditApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCreditApplicationRepository extends JpaRepository<CreditApplicationEntity, UUID> {

}
