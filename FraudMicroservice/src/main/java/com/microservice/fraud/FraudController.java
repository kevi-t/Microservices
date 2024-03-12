package com.microservice.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraudCheck")
@AllArgsConstructor
@Slf4j
public class FraudController {
    private final FraudHistoryService fraudHistoryService;

    @GetMapping(path = "{userId}")
    public FraudCheckResponse isFraudster(@PathVariable("userId") Long userId) {
        boolean isFraudulentCustomer = fraudHistoryService.isFraudulentCustomer(userId);
        log.info("fraud check request for customer {}",userId);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
}