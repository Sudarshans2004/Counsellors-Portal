package com.miniproject.Counsellors_Portal.service;

import com.miniproject.Counsellors_Portal.dto.ViewEnqsFilterRequest;
import com.miniproject.Counsellors_Portal.entity.Councellor;
import com.miniproject.Counsellors_Portal.entity.Enquiry;
import com.miniproject.Counsellors_Portal.repository.CouncellorRepo;
import com.miniproject.Counsellors_Portal.repository.EnquiryRepo;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    private final EnquiryRepo enquiryRepo;
    private final CouncellorRepo councellorRepo;

    public EnquiryServiceImpl(EnquiryRepo enquiryRepo, CouncellorRepo councellorRepo) {
        this.enquiryRepo = enquiryRepo;
        this.councellorRepo = councellorRepo;
    }

    @Override
    public Boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception {
        Councellor councellor = councellorRepo.findById(counsellorId).orElse(null);
        if (councellor == null) {
            throw new Exception("No Counsellor found");
        }
        enq.setCouncellor(councellor);
        Enquiry saved = enquiryRepo.save(enq);
        if(saved.getEnqId()!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<Enquiry> getAllEnquiry(Integer counsellorId) {
        return enquiryRepo.getEnquiresByCounsellorId(counsellorId);
    }

    @Override
    public List<Enquiry> getEnquiriesWithFilter(ViewEnqsFilterRequest filterRequest, Integer counsellorId) {

        Enquiry enquiry = new Enquiry();

        if (StringUtils.hasText(filterRequest.getClassMode()))  enquiry.setClassMode(filterRequest.getClassMode());
        if (StringUtils.hasText(filterRequest.getCourseName())) enquiry.setCourseName(filterRequest.getCourseName());
        if (StringUtils.hasText(filterRequest.getEnqStatus()))  enquiry.setEnqStatus(filterRequest.getEnqStatus());

        Councellor councellor = councellorRepo.findById(counsellorId).orElse(null);
        enquiry.setCouncellor(councellor);

        Example<Enquiry> example = Example.of(enquiry);
        return enquiryRepo.findAll(example);       // was: return List.of();
    }

    @Override
    public Enquiry getEnquiryById(Integer enqId) {
        return enquiryRepo.findById(enqId).orElse(null);
    }
}