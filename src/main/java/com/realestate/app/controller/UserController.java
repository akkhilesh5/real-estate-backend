package com.realestate.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.realestate.app.dto.LoginDto;
import com.realestate.app.dto.RegisterUserDto;
import com.realestate.app.dto.UserDto;
import com.realestate.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody RegisterUserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.registerUser(userDto));
    }

    // LOGIN USER
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
        String response = userService.loginUser(
                loginDto.getUserEmail(),
                loginDto.getUserPassword()
        );
        return ResponseEntity.ok(response);
    }

    // GET ALL USERS
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}