package com.microservice.fraud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fraudId;
    private Long userId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}