package com.example.demo.controller;

import com.example.demo.dto.request.UpdateStatusRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.service.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{id}/status")
public class UserStatusController {

    private final IUserService _userService;

    public UserStatusController(IUserService userService) {
        _userService = userService;
    }

    @PatchMapping()
    public UserResponse updateStatus (@PathVariable Long id, @RequestBody UpdateStatusRequest request) throws Exception {
        return _userService.updateStatus(id, request);
    }
}
