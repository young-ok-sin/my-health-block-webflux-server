package com.example.myhealthblock.user.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    UserEntity findByUserId(String userId);
}
