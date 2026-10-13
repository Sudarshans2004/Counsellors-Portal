package com.miniproject.Counsellors_Portal.controller;

import com.miniproject.Counsellors_Portal.dto.DashBoardResponse;
import com.miniproject.Counsellors_Portal.dto.ViewEnqsFilterRequest;
import com.miniproject.Counsellors_Portal.entity.Enquiry;
import com.miniproject.Counsellors_Portal.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EnquiryController {
    private EnquiryService enquiryService;

    EnquiryController(EnquiryService enquiryService){
        this.enquiryService=enquiryService;
    }

    public String filterEnquries(ViewEnqsFilterRequest viewEnqsFilterRequest,HttpServletRequest request, Model model){
        HttpSession session=request.getSession(false);
        Integer counsellorId = (Integer) session.getAttribute("counsellorId");
        List<Enquiry> enqList = enquiryService.getAllEnquiry(counsellorId);
        model.addAttribute("enquiries",enqList);
        return"viewEnquiries";
    }

    @GetMapping("/viewEnquiries")
    public String getEnquiries(ViewEnqsFilterRequest filterRequest,
                               HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("counsellorId") == null) {
            return "redirect:/";
        }
        Integer counsellorId = (Integer) session.getAttribute("counsellorId");

        List<Enquiry> enqList = enquiryService.getEnquiriesWithFilter(filterRequest, counsellorId);
        model.addAttribute("enquiries", enqList);
        return "viewEnquiries";   // opens WEB-INF/views/viewEnquiries.jsp
    }

    @GetMapping("/enquiry")
    public String enquiryPage(Model model) {
        model.addAttribute("enq", new Enquiry());
        return "enquiryForm";
    }

    @GetMapping("/editEnquiry")
    public String editEnquiry(@RequestParam("enqId") Integer enqId,
                              HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("counsellorId") == null) {
            return "redirect:/";
        }

        Enquiry enquiry = enquiryService.getEnquiryById(enqId);
        model.addAttribute("enq", enquiry);      // was "enquiry"
        return "enquiryForm";
    }


    @PostMapping("/addEnq")
    public String addEnquiry(@ModelAttribute("enq") Enquiry enq,
                             HttpServletRequest request, Model model) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("counsellorId") == null) {
            return "redirect:/";   // not logged in
        }
        Integer counsellorId = (Integer) session.getAttribute("counsellorId");

        boolean saved = enquiryService.addEnquiry(enq, counsellorId);
        if (saved) {
            model.addAttribute("smsg", "Enquiry added");
            model.addAttribute("enq", new Enquiry());   // clears the form
        } else {
            model.addAttribute("emsg", "Failed to add enquiry");
        }
        return "enquiryForm";
    }
}
