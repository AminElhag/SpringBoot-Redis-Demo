package com.example.springbootredisdemo.repository;

import com.example.springbootredisdemo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String KEY = "USER";
    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean createUser(UserModel user) {
        try {
            redisTemplate.opsForHash().put(KEY, String.valueOf(user.getId()), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> userModels = redisTemplate.opsForHash().values(KEY);
        return userModels;
    }

    @Override
    public UserModel getUserById(Long id) {
        UserModel userModel = (UserModel) redisTemplate.opsForHash().get(KEY, String.valueOf(id));
        if (userModel != null) {
            return userModel;
        }
        return null;
    }

    @Override
    public boolean deletedUserById(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY,String.valueOf(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserModel updateUserById(Long id, UserModel userModel) {
        if (redisTemplate.opsForHash().hasKey(KEY,String.valueOf(id))){
            redisTemplate.opsForHash().delete(KEY,String.valueOf(id));
            userModel.setId(id);
            redisTemplate.opsForHash().put(KEY,String.valueOf(id),userModel);
            return userModel;
        }
        return null;

    }
}
