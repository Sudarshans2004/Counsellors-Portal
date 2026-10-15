package com.miniproject.Counsellors_Portal.service;

import com.miniproject.Counsellors_Portal.dto.DashBoardResponse;
import com.miniproject.Counsellors_Portal.entity.Councellor;
import com.miniproject.Counsellors_Portal.entity.Enquiry;
import com.miniproject.Counsellors_Portal.repository.CouncellorRepo;
import com.miniproject.Counsellors_Portal.repository.EnquiryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RegisterServiceImpl implements CounsellorService{

    private EnquiryRepo enquiryRepo;
    private CouncellorRepo councellorRepo;

    public RegisterServiceImpl(CouncellorRepo councellorRepo, EnquiryRepo enquiryRepo){
        this.councellorRepo=councellorRepo;
        this.enquiryRepo=enquiryRepo;
    }

    @Override
    public Councellor findByEmail(String email) {
        return  councellorRepo.findByEmail(email);
    }

    @Override
    public boolean register(Councellor councellor) {
        Councellor savedCounsellor = (Councellor) councellorRepo.save(councellor);
        if(null!= savedCounsellor.getCounsellorId()) return true;
        return false;
    }

    @Override
    public Councellor login(String email, String pwd) {
        Councellor councellor = councellorRepo.findByEmailAndPwd(email, pwd);
        return councellor;
    }

    @Override
    public DashBoardResponse getDashInfo(Integer counsellorId) {

        List<Enquiry> enquiryList = enquiryRepo.getEnquiresByCounsellorId(counsellorId);

        int total    = enquiryList.size();
        int enrolled = (int) enquiryList.stream().filter(e -> "Enrolled".equals(e.getEnqStatus())).count();
        int lost     = (int) enquiryList.stream().filter(e -> "Lost".equals(e.getEnqStatus())).count();
        int open     = (int) enquiryList.stream().filter(e -> "Open".equals(e.getEnqStatus())).count();

        DashBoardResponse response = new DashBoardResponse();
        response.setTotalEnqs(total);
        response.setEnrollEnqs(enrolled);
        response.setLostEnqs(lost);
        response.setOpenEnqs(open);

        return response;      // your old code returned null
    }
}