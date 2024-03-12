package com.microservice.user;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UniversalResponse {
    private String message;
    private String status;
    private Object data;
}