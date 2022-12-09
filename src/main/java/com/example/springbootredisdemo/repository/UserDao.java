package com.example.springbootredisdemo.repository;

import com.example.springbootredisdemo.model.UserModel;

import java.util.List;

public interface UserDao {
    boolean createUser(UserModel user);

    List<UserModel> getAllUsers();

    UserModel getUserById(Long id);

    boolean deletedUserById(Long id);

    UserModel updateUserById(Long id, UserModel userModel);
}
