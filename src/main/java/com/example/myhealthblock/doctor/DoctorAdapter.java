package com.example.myhealthblock.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DoctorAdapter implements DoctorOutport {
    private final DoctorRepository doctorRepository;
    @Override
    public boolean create(String id, String name, String field, String hospital, String introduction) {
        DoctorEntity q = new DoctorEntity(id, name, field, hospital, introduction);
        this.doctorRepository.save(q);

        return true;
    }
}
