package com.example.myhealthblock.patient.adapter.out;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "UrgentDataSearchHistory")
public class UrgentDataSearchHistoryEntity {

    public UrgentDataSearchHistoryEntity() {
        date = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String doctorId;

    @Column
    private String patientId;

    @Column
    private String reason;

    @Column
    private String content;

    @Column
    private LocalDateTime date;
}
