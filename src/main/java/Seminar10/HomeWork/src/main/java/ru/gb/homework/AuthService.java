package ru.gb.homework;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public Optional<User> login(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            sessionRepository.save(new Session(user.get()));
            System.out.println("Логирование прошло успешно");
            return user;
        }
        System.out.println("Пользователь с данным логином или паролем не найден");
        return Optional.empty();
    }

    public User register(User user) {
        userRepository.save(user);
        return user;
    }

    public void logout(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Optional<Session> session = sessionRepository.findByUser(user.get());
            session.ifPresent(sessionRepository::delete);
            System.out.println("Сессия удачно закрыта");
        } else {
            System.out.println("Пользователь с данным id не найден");
        }
    }
}