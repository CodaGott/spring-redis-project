package io.spring.redis.repo;

import io.spring.redis.model.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> getAllUsers();

    User getUser(Long id);

    boolean deleteUserById(Long id);

    boolean updateUser(User user, Long id);
}
