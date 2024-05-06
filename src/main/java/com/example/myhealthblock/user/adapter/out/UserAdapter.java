package com.example.myhealthblock.user.adapter.out;

import com.example.myhealthblock.user.User;
import com.example.myhealthblock.user.UserOutport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        return (entity != null) ? new User(entity.getId(), entity.getUserId(), entity.getPw(), entity.getRole()) : null;
    }
}
