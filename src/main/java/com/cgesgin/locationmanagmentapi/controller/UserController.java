package com.cgesgin.locationmanagmentapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgesgin.locationmanagmentapi.core.dto.UserDto;
import com.cgesgin.locationmanagmentapi.core.dto.UserLoginDto;
import com.cgesgin.locationmanagmentapi.exception.BusinessException;
import com.cgesgin.locationmanagmentapi.service.userservice.IUserService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody @Valid UserLoginDto userLoginDto) throws BusinessException {
        return new ResponseEntity<>(userService.login(userLoginDto),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody @Valid UserDto userDto) throws BusinessException {
        return new ResponseEntity<>(userService.register(userDto),HttpStatus.OK);
    }

}
