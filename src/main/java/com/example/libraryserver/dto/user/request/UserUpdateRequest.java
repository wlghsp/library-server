package com.example.libraryserver.dto.user.request;

import lombok.Getter;

@Getter
public class UserUpdateRequest {
    private long id;
    private String name;
    private Integer age;
}
