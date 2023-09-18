package com.example.libraryserver.domain.user;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(unique = true, nullable = false, length = 20)
    private String userId;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(nullable = false, length = 20)
    private String name;
    private Integer age;

    public User(String userId, String name, String password) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 userId(%s)이 들어왔습니다", userId));
        }
        this.userId = userId;
        this.password = password;
        this.name = name;

    }

    public void updateUser(String name, Integer age) {
        this.userId = name;
        this.age = age;
    }

}
