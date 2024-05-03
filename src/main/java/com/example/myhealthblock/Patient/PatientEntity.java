package com.example.myhealthblock.Patient;

import com.example.myhealthblock.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Patient")
@NoArgsConstructor
public class PatientEntity {
    public PatientEntity(String userId){
        this.userId = userId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String userId;

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime lastEditDate;

}
