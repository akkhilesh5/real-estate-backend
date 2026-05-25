package com.realestate.app.service;

import java.util.List;

import com.realestate.app.dto.RegisterUserDto;
import com.realestate.app.dto.UserDto;

public interface UserService {

	UserDto registerUser(RegisterUserDto userDto);

    String loginUser(String email, String password);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    void deleteUser(Long userId);
}