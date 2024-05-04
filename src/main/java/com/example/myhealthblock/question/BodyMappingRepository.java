package com.example.myhealthblock.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyMappingRepository extends JpaRepository<BodyPartMappingEntity, Integer> {
}
