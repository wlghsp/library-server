package com.example.libraryserver.dto.user.response;


import com.example.libraryserver.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private long id;
    private String userId;
    private String name;

    private Integer age;

    public UserResponse(long id, String userId, String name, Integer age) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.name = user.getUserId();
        this.age = user.getAge();
    }


    public UserResponse(long id, User user) {
        this.id = id;
        this.userId = user.getUserId();
        this.name = user.getUserId();
        this.age = user.getAge();
    }



}
