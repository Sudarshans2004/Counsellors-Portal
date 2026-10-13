package com.miniproject.Counsellors_Portal.repository;

import com.miniproject.Counsellors_Portal.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnquiryRepo extends JpaRepository<Enquiry ,Integer> {

      @Query( value = "select * from enquiry_tbl where counsellor_id=:counsellorId" ,nativeQuery = true)
      public List<Enquiry> getEnquiresByCounsellorId(Integer counsellorId);


}
