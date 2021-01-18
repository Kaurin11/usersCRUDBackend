package com.example.demo.service;

import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.request.UpdateStatusRequest;
import com.example.demo.dto.request.UpdateUserRequest;
import com.example.demo.dto.response.UserResponse;

import java.util.List;

public interface IUserService {

    List<UserResponse> getAllUsers();

    UserResponse getUser(Long id) throws Exception;

    UserResponse createUser(CreateUserRequest request) throws Exception;

    UserResponse updateStatus(Long id, UpdateStatusRequest request) throws Exception;

    void deleteUser (Long id) throws Exception;

    UserResponse updateUser(Long id, UpdateUserRequest request) throws Exception;
}
