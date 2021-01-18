package com.example.demo.controller;

import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.request.UpdateUserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService _userService;

    public UserController(IUserService userService) {
        _userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return _userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) throws Exception {
        return _userService.getUser(id);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) throws Exception {
        return _userService.createUser(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception {
        _userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) throws Exception {
        return _userService.updateUser(id,request);
    }
}
