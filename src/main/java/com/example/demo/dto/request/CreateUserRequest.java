package com.example.demo.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private boolean status;
}
