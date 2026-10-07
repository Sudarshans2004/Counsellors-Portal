package com.miniproject.Counsellors_Portal.repository;

import com.miniproject.Counsellors_Portal.entity.Councellor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouncellorRepo extends JpaRepository {
    public Councellor findByEmailAndPwd(String email,String pwd);

    public Councellor findByEmail(String email);
}
