package com.ibs.task.services;

import com.ibs.task.models.User;
import com.ibs.task.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public Map<Integer, User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void update(User user) {
        userRepo.update(user);
    }
}
