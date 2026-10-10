package com.miniproject.Counsellors_Portal.service;

import com.miniproject.Counsellors_Portal.dto.DashBoardResponse;
import com.miniproject.Counsellors_Portal.entity.Councellor;

public interface CounsellorService {

    public Councellor findByEmail(String email);
    public boolean register (Councellor councellor);

    public Councellor login(String email,String pwd);

    public DashBoardResponse getDashInfo(Integer counsellorId);
}
