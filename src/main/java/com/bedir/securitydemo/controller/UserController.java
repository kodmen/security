package com.bedir.securitydemo.controller;

import com.bedir.securitydemo.service.Dto.UserDto;
import com.bedir.securitydemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

   @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto){
        return ResponseEntity.ok(service.save(dto));
   }

}
