package com.example.credit.infrastructure.adapter.in.web;

import com.example.credit.domain.model.CreditApplication;
import com.example.credit.domain.port.in.ChangeStatusUseCase;
import com.example.credit.domain.port.in.CreateCreditApplicationUseCase;
import com.example.credit.domain.port.in.GetCreditApplicationUseCase;
import com.example.credit.domain.port.in.ListCreditApplicationUseCase;
import com.example.credit.infrastructure.adapter.in.web.dto.ChangeStatusRequest;
import com.example.credit.infrastructure.adapter.in.web.dto.CreateCreditApplicationRequest;
import com.example.credit.infrastructure.adapter.in.web.dto.CreditApplicationResponse;
import com.example.credit.infrastructure.adapter.in.web.dto.ErrorResponse;
import com.example.credit.infrastructure.adapter.in.web.mapper.CreditApplicationDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/credit-applications")
@Slf4j
@Tag(name="Solicitud de Credito", description = "Gestion de solicitudes")
public class CreditApplicationController {

    private final CreateCreditApplicationUseCase createCreditApplicationUseCase;
    private final ChangeStatusUseCase changeStatusUseCase;
    private final GetCreditApplicationUseCase getCreditApplicationUseCase;
    private final ListCreditApplicationUseCase listCreditApplicationUseCase;

    private final CreditApplicationDtoMapper creditApplicationDtoMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear solicitud de credito")
    public CreditApplicationResponse create(@RequestBody @Valid CreateCreditApplicationRequest createCreditApplicationRequest){
        log.info("__create__init__");
        CreditApplication creditApplicationDomain = creditApplicationDtoMapper.toDomain(createCreditApplicationRequest);
        CreditApplication creditApplicationCreated =  createCreditApplicationUseCase.create(creditApplicationDomain);
        return creditApplicationDtoMapper.toResponse(creditApplicationCreated);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar solicitu de credito")
    public CreditApplicationResponse findApplicationById(@PathVariable UUID id){
        log.info("__findApplicationById__init__");
        CreditApplication creditApplication = getCreditApplicationUseCase.getApplicationById(id);
        return creditApplicationDtoMapper.toResponse(creditApplication);
    }

    @GetMapping
    @Operation(summary = "Listar solicitudes de credito")
    public List<CreditApplicationResponse> findAll(){
        log.info("__findAll__init__");
        return listCreditApplicationUseCase.findAll().stream().map(creditApplicationDtoMapper::toResponse).toList();
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Actualizar estado de la solicitud de credito")
    public ResponseEntity<Void> changeStatus(@PathVariable UUID id, @RequestBody @Valid ChangeStatusRequest requestStatus){
        log.info("__changeStatus__init__");
        changeStatusUseCase.changeStatus(id,requestStatus.status(), requestStatus.reason());
        return ResponseEntity.noContent().build();
    }

}
