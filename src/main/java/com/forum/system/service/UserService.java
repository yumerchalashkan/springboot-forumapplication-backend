package com.forum.system.service;

import com.forum.system.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
    User findById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
