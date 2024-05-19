package com.example.myhealthblock.patient.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
    PatientEntity findByUserId(String userId);
}
