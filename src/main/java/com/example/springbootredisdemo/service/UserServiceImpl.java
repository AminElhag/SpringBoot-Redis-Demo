package com.example.springbootredisdemo.service;

import com.example.springbootredisdemo.model.UserModel;
import com.example.springbootredisdemo.repository.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean createUser(UserModel user) {
        return userDao.createUser(user);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public UserModel getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean deletedUserById(Long id) {
        return userDao.deletedUserById(id);
    }

    @Override
    public UserModel updateUserById(Long id, UserModel userModel) {
        return userDao.updateUserById(id,userModel);
    }
}
