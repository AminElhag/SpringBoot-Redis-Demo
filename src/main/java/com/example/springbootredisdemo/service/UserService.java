package com.example.springbootredisdemo.service;

import com.example.springbootredisdemo.model.UserModel;

import java.util.List;

public interface UserService {
    boolean createUser(UserModel user);

    List<UserModel> getAllUsers();

    UserModel getUserById(Long id);

    boolean deletedUserById(Long id);

    UserModel updateUserById(Long id, UserModel userModel);
}
