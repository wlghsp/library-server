package com.example.libraryserver.service.user;

import com.example.libraryserver.domain.user.User;
import com.example.libraryserver.domain.user.UserRepository;
import com.example.libraryserver.dto.user.request.UserCreateRequest;
import com.example.libraryserver.dto.user.request.UserUpdateRequest;
import com.example.libraryserver.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getUserId(), request.getName(), request.getPassword()));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        user.updateUser(request.getName(), request.getAge());
    }
    @Transactional
    public void deleteUser(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }

}
