package com.example.credit.infrastructure.adapter.in.web.mapper;

import com.example.credit.domain.model.CreditApplication;
import com.example.credit.infrastructure.adapter.in.web.dto.CreateCreditApplicationRequest;
import com.example.credit.infrastructure.adapter.in.web.dto.CreditApplicationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditApplicationDtoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "monthlyPayment", ignore = true)
    @Mapping(target = "totalToPay", ignore = true)
    @Mapping(target = "amountUSD", ignore = true)
    @Mapping(target = "amountEUR", ignore = true)
    @Mapping(target = "exchangeRateDate", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "statusReason", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CreditApplication toDomain(
            CreateCreditApplicationRequest createCreditApplicationRequest
    );

    CreditApplicationResponse toResponse(CreditApplication creditApplication);
}
