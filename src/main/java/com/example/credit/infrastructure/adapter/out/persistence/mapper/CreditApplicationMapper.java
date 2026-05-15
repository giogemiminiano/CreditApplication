package com.example.credit.infrastructure.adapter.out.persistence.mapper;

import com.example.credit.domain.model.CreditApplication;
import com.example.credit.infrastructure.adapter.out.persistence.entity.CreditApplicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditApplicationMapper {

    CreditApplicationEntity toEntity(CreditApplication creditApplication);

    CreditApplication toDomain(CreditApplicationEntity creditApplicationEntity);
}
