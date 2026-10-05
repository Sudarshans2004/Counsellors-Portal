package com.miniproject.Counsellors_Portal.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Enquiry {
    private int id;
    private String name;
    private String status;
    private String studentName;
    private String studentPhone;
    private String courseName;
    private String classMode;
    private Date createdDate;
    private Date udatedDate;
}
