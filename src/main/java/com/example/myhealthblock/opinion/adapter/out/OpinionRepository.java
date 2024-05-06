package com.example.myhealthblock.opinion.adapter.out;

import com.example.myhealthblock.user.adapter.out.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository  extends JpaRepository<OpinionEntity, Integer> {
    List<OpinionEntity> findByUser(UserEntity user);
}
