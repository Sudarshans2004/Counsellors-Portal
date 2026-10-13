package com.miniproject.Counsellors_Portal.service;

import com.miniproject.Counsellors_Portal.dto.ViewEnqsFilterRequest;
import com.miniproject.Counsellors_Portal.entity.Councellor;
import com.miniproject.Counsellors_Portal.entity.Enquiry;

import java.util.List;

public interface EnquiryService {

    public Boolean addEnquiry( Enquiry enq , Integer counsellorId) throws Exception;

    public List<Enquiry> getAllEnquiry(Integer counsellorId);

    public List<Enquiry> getEnquiriesWithFilter(ViewEnqsFilterRequest filterRequest, Integer counsellorId);

    public Enquiry getEnquiryById(Integer enqId);

}
