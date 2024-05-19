package com.example.myhealthblock.patient.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrgentDataSearchHistoryRepository extends JpaRepository<UrgentDataSearchHistoryEntity, Integer> {
    List<UrgentDataSearchHistoryEntity> findAllByPatientId(String patientId);
}