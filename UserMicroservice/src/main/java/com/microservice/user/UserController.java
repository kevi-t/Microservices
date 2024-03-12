package com.microservice.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UniversalResponse> registerUser(@RequestBody RegisterDTO request) {
        try {
            log.info("new customer registration {}", request);
            return ResponseEntity.ok(userService.registerUser(request));
        }
        catch (Exception exception){
            log.info("Error",exception);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}