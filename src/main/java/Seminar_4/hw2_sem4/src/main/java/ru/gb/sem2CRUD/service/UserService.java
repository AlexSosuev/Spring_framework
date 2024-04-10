package ru.gb.sem2CRUD.service;

import lombok.AllArgsConstructor;
import ru.gb.sem2CRUD.model.User;
import ru.gb.sem2CRUD.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    public void updateById(int id, User user){
        userRepository.updateById(id, user);
    }
}