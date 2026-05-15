package com.example.credit.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;

public record ChangeStatusRequest (
        @NotBlank
        String status,

        String reason
){
}
