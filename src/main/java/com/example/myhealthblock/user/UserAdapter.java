package com.example.myhealthblock.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserAdapter implements UserOutport {
    private final UserRepository userRepository;

    @Override
    public boolean create(String id, String pw, String role) {
        UserEntity q = new UserEntity(id, pw, role);
        this.userRepository.save(q);

        return true;
    }

    @Override
    public User getUser(String id) {
        UserEntity entity = this.userRepository.findByUserId(id);

        return (entity != null) ? new User(entity.getUserId(), entity.getPw(), entity.getRole()) : null;
    }
}
