package com.example.libraryserver.dto.user.response;


import com.example.libraryserver.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private long id;
    private String userId;
    private String name;
    private Integer age;

    public UserResponse(User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.name = user.getName();
        this.age = user.getAge();
    }
}
