package ru.gb.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthServiceTest {
    @InjectMocks
    private AuthService authService;
    @Mock
    UserRepository userRepository;
    @Mock
    SessionRepository sessionRepository;

    @Test
    public void testRegister() {
        User user = new User("root", "root");
        authService.register(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    public void testLogin() {
        User user = new User("root", "root");
        Session session = new Session(user);

        when(userRepository.findByUserName("root")).thenReturn(Optional.of(user));

        authService.login("root", "root");

        Mockito.verify(sessionRepository, Mockito.times(1)).save(session);
    }

    @Test
    public void testLogout() {
        User user = new User("root", "root");
        Session session = new Session(user);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(sessionRepository.findByUser(user)).thenReturn(Optional.of(session));

        authService.logout(1L);

        Mockito.verify(sessionRepository, Mockito.times(1)).delete(session);
    }
}