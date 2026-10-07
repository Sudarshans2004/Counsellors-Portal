package com.miniproject.Counsellors_Portal.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Councellor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer counsellorId;
    private String councellorName;
    private String pwd;
    private String phoneNo;
    @Column(unique = true)
    private String email;
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
    private LocalDate updatedDate;


}
