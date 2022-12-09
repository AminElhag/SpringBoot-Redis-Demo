package com.example.springbootredisdemo.controller;

import com.example.springbootredisdemo.model.UserModel;
import com.example.springbootredisdemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    private ResponseEntity<String> createUser(@RequestBody UserModel user) {
        boolean result = userService.createUser(user);
        if (result) {
            return ResponseEntity.ok("User Created !!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Don't created !!");
    }

    @GetMapping()
    private ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> usersModels;
        usersModels = userService.getAllUsers();
        return ResponseEntity.ok(usersModels);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        UserModel userModel;
        userModel = userService.getUserById(id);
        if (userModel != null) {
            return ResponseEntity.ok(userModel);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        boolean result = false;
        result = userService.deletedUserById(id);
        if (result) {
            return ResponseEntity.ok("User Deleted");
        }
        return ResponseEntity.ok("User not found");
    }

    @PutMapping("/{id}")
    private ResponseEntity<UserModel> updateUserById(@PathVariable Long id, @RequestBody UserModel userModel) {
        UserModel result;
        result = userService.updateUserById(id, userModel);
        if (result != null) {
            return ResponseEntity.ok(userModel);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
