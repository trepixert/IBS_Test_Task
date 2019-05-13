package com.ibs.task.repo;

import com.ibs.task.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class UserRepo {
    private Map<Integer,User> allUsers = new HashMap<>();
    private Random random = new Random();

    public UserRepo() {
        allUsers.put(1,new User(1,"some@mail.ru","name","surname"));
        allUsers.put(2,new User(2,"someOne@mail.ru","name1","surname1"));
        allUsers.put(3,new User(3,"someTwo@mail.ru","name2","surname2"));
        allUsers.put(4,new User(4,"someThree@mail.ru","name3","surname3"));
        allUsers.put(5,new User(5,"someFour@mail.ru","name4","surname4"));
        allUsers.put(6,new User(6,"someFive@mail.ru","name5","surname5"));
    }

    public Map<Integer, User> getAllUsers() {
        return allUsers;
    }

    public void update(User user){
        if(allUsers.containsKey(user.getId())){
            getAllUsers().put(user.getId(),user);
        }
    }

    public void save(User user) {
        int newId =random.nextInt(150);
        while(true) {
            if(!allUsers.containsKey(newId)) {
                user.setId(newId);
                allUsers.put(newId, user);
                break;
            }
        }
    }

    public User findById(Integer id){
        return allUsers.get(id);
    }
}
