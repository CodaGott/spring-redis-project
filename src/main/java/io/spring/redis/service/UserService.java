package io.spring.redis.service;

import io.spring.redis.model.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    List<User> getAllUsers();

    User getAUser(Long id);

    boolean deleteUserById(Long id);

    boolean updateUserById(User user, Long id);
}
