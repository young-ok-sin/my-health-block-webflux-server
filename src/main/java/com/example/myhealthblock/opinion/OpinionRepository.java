package com.example.myhealthblock.opinion;

import com.example.myhealthblock.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository  extends JpaRepository<OpinionEntity, Integer> {
    List<OpinionEntity> findByUser(UserEntity user);
}
