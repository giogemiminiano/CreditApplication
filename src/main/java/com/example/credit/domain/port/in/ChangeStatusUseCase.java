package com.example.credit.domain.port.in;

import java.util.UUID;

public interface ChangeStatusUseCase {

    boolean changeStatus(UUID id,String requestStatus, String reason);
}
