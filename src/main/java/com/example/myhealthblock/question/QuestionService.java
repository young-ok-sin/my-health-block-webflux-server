package com.example.myhealthblock.question;

import com.example.myhealthblock.patient.PatientService;
import com.example.myhealthblock.patient.dto.PatientEntityDTO;
import com.example.myhealthblock.question.dto.QuestionEnrollDTO;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionAdapter outport;
    private final PatientService patientInport;

    public String enroll(QuestionEnrollDTO dto) {
        PatientEntityDTO patientDto = patientInport.getPatientEntityDTO(dto.getUserId());
        outport.create(patientDto.getEntity(), dto.getTitle(), dto.getCategory(), dto.getSymptom(), dto.getContent(), dto.getBodyParts(), null);

        return "";
    }
}
