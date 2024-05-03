package com.example.myhealthblock.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "AppUser")
@NoArgsConstructor
public class UserEntity {

    public UserEntity(String userId, String pw, String role) {
        this.userId = userId;
        this.pw = pw;
        this.role = role;
        createDate = LocalDateTime.now();
        lastEditDate = LocalDateTime.now();
    }

    public UserEntity(String userId, String pw, String role, LocalDateTime createDate, LocalDateTime lastEditDate) {
        this(userId, pw, role);
        this.createDate = createDate;
        this.lastEditDate = lastEditDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String userId;

    @Column(length = 200)
    private String pw;

    @Column(length = 200)
    private String role;

    private LocalDateTime createDate;

    private LocalDateTime lastEditDate;
}
