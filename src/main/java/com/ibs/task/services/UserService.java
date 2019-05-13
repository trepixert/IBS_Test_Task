package com.ibs.task.services;

import com.ibs.task.models.User;

import java.util.Map;

public interface UserService {
    Map<Integer, User> getAllUsers();
    void save(User user);
    User findById(Integer id);
    void update(User user);
}
