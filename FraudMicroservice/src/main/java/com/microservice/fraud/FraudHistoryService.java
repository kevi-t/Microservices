package com.microservice.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudHistoryService {
    private final FraudHistoryRepository fraudHistoryRepository;
    public boolean isFraudulentCustomer(Long userId) {
        fraudHistoryRepository.save(
                FraudHistory.builder()
                        .userId(userId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}