package com.example.CRUD.service;

import com.example.CRUD.aspects.TrackUserAction;
import com.example.CRUD.model.User;
import com.example.CRUD.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @TrackUserAction
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @TrackUserAction
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @TrackUserAction
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    @TrackUserAction
    public void updateById(int id, User user){
        userRepository.updateById(id, user);
    }
}