package com.example.myhealthblock.user.adapter.out;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.user.User;
import com.example.myhealthblock.user.UserOutport;
import com.example.myhealthblock.user.dto.UserEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
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
        UserEntity entity = getUserEntity(id);

        return (entity != null) ? new User(entity.getId(), entity.getUserId(), entity.getPw(), entity.getRole()) : null;
    }

    @Override
    public UserEntityDTO getUserEntityDTO(String id) {
        return new UserEntityDTO(getUserEntity(id));
    }

    private UserEntity getUserEntity(String id) {
        return this.userRepository.findByUserId(id);
    }
}
