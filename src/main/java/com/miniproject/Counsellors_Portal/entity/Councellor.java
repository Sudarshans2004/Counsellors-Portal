package com.miniproject.Counsellors_Portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Councellor {
    @Id
    private int id;
    private String councellorName;
    private String pwd;
    private String phoneNo;
    private String emailId;
}
