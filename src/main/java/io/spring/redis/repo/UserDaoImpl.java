package io.spring.redis.repo;

import io.spring.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";

    @Override
    public boolean saveUser(User user) {

        try {
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        users= redisTemplate.opsForHash().values(KEY);
        return users;
    }

    @Override
    public User getUser(Long id) {
        User user;
        user = (User) redisTemplate.opsForHash().get(KEY, id.toString());
        return user;
    }

    @Override
    public boolean deleteUserById(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY,id.toString());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User user, Long id) {
        try {
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
