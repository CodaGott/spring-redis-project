package io.spring.redis.service;

import io.spring.redis.model.User;
import io.spring.redis.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getAUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public boolean updateUserById(User user, Long id) {
        return userDao.updateUser(user, id);
    }
}
