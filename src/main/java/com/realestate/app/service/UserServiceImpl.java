package com.realestate.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.app.dto.RegisterUserDto;
import com.realestate.app.dto.UserDto;
import com.realestate.app.entity.User;
import com.realestate.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

 // REGISTER USER
    @Override
    public UserDto registerUser(RegisterUserDto userDto) {

        // Check duplicate email
        if (userRepository.findByUserEmail(userDto.getUserEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // 1. ModelMapper transforms properties seamlessly
        User user = modelMapper.map(userDto, User.class);

        // 2. 👇 UPDATE THIS LINE: Pull the dynamic role field right out of the DTO!
        user.setRole(userDto.getRole()); 

        // 3. Commit tracking to your DB
        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDto.class);
    }
    
    // LOGIN USER
    @Override
    public String loginUser(String email, String password) {

        Optional<User> userOptional = userRepository.findByUserEmail(email);

        if (userOptional.isEmpty()) {
            return "User not found";
        }

        User user = userOptional.get();

        if (user.getUserPassword().equals(password)) {
            return "Login Successful";
        } else {
            return "Invalid Password";
        }
    }

    // GET ALL USERS
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    // GET USER BY ID
    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return modelMapper.map(user, UserDto.class);
    }

    // DELETE USER
    @Override
    public void deleteUser(Long userId) {

        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(userId);
    }
}