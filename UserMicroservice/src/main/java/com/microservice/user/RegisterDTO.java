package com.microservice.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RegisterDTO {
    String firstName;
    String lastName;
    String email;
}