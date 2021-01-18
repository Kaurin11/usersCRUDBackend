package com.example.demo.service.impl;

import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.request.UpdateStatusRequest;
import com.example.demo.dto.request.UpdateUserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = _userRepository.findAll();

        return users.stream()
                .map(user -> mapUserToUserResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUser(Long id) throws Exception {
       User user = getUserById(id);

       return mapUserToUserResponse(user);
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) throws Exception {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setCity(request.getCity());
        user.setStatus(request.isStatus());
        try {
            User savedUser = _userRepository.save(user);
            return mapUserToUserResponse(savedUser);
        } catch (Exception ex) {
            throw new Exception("User with email already exist");
        }
    }

    @Override
    public UserResponse updateStatus(Long id, UpdateStatusRequest request) throws Exception {
        User user = getUserById(id);

        user.setStatus(request.isStatus());

        User savedUser = _userRepository.save(user);

        return  mapUserToUserResponse(savedUser);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User user = getUserById(id);

        _userRepository.delete(user);

    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest request) throws Exception {
        User user = getUserById(id);

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setCity(request.getCity());

        User updatedUser = _userRepository.save(user);

        return mapUserToUserResponse(updatedUser);
    }

    private User getUserById(Long id) throws Exception {
        User user = _userRepository.findOneById(id);

        if (user == null) {
            throw new Exception("User not found");
        }
        return user;
    }

    private UserResponse mapUserToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setAddress(user.getAddress());
        userResponse.setCity(user.getCity());
        userResponse.setStatus(user.isStatus());

        return userResponse;
    }
}
