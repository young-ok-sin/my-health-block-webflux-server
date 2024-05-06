package com.example.myhealthblock.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientAdapter implements PatientOutport {
    private final PatientRepository patientRepository;
    @Override
    public boolean create(String id) {
        PatientEntity p = new PatientEntity(id);
        this.patientRepository.save(p);

        return true;
    }
}
