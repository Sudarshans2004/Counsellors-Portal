package com.miniproject.Counsellors_Portal.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "enquiry_tbl")
public class Enquiry {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer enqId;
    private String enqStatus;
    private String studentName;
    private String studentPhone;
    private String courseName;
    private String classMode;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createdDate;
    @UpdateTimestamp
    private Date udatedDate;

    @ManyToOne
    @JoinColumn(name = "counsellor_id")
    private Councellor councellor;
}
