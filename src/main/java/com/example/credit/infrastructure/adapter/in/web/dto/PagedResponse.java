package com.example.credit.infrastructure.adapter.in.web.dto;

import java.util.List;

public record PagedResponse<T>(
        List<T> content,
        Integer page,
        Integer size,
        Long totalElements,
        Integer totalPage
) {
}
