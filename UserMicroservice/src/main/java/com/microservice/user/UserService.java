package com.microservice.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UniversalResponse registerUser(RegisterDTO request) {
        Users users = Users.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        userRepository.saveAndFlush(users);

        // todo: check if email valid
        // todo: check if email not taken
        //FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:9001/api/v1/fraudCheck/{customerId}"
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUDMICROSERVICE/api/v1/fraudCheck/{customerId}",
                FraudCheckResponse.class,users.getUserId());
        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }
        return UniversalResponse.builder()
                .message("Registration successful")
                .status("0")
                .build();
    }

}