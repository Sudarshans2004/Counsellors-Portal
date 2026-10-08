package com.miniproject.Counsellors_Portal.controller;

import com.miniproject.Counsellors_Portal.dto.DashBoardResponse;
import com.miniproject.Counsellors_Portal.entity.Councellor;
import com.miniproject.Counsellors_Portal.service.CounsellorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CouncellorController {

    private final CounsellorService counsellorService;

    public CouncellorController(CounsellorService counsellorService) {
        this.counsellorService = counsellorService;
    }

    // Login page
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("counsellor", new Councellor());
        return "index";
    }

    // Typing /login in the address bar goes back to the login page
    @GetMapping("/login")
    public String loginRedirect() {
        return "redirect:/";
    }

    @PostMapping("/login")
    public String handleLoginBtn(@ModelAttribute("counsellor") Councellor councellor,
                                 HttpServletRequest request, Model model) {

        Councellor c = counsellorService.login(councellor.getEmail(), councellor.getPwd());

        if (c == null) {
            model.addAttribute("emsg", "Invalid Credentials");
            return "index";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("counsellorId", c.getCounsellorId());

        DashBoardResponse dashBoardResponse = counsellorService.getDashInfo(c.getCounsellorId());
        model.addAttribute("dashBoardInfo", dashBoardResponse);
        return "dashboard";
    }

    // Register page
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("counsellor", new Councellor());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute("counsellor") Councellor councellor, Model model) {

        Councellor byEmail = counsellorService.findByEmail(councellor.getEmail());

        if (byEmail != null) {
            model.addAttribute("emsg", "Duplicate Email");
            return "register";
        }

        boolean isRegister = counsellorService.register(councellor);

        if (isRegister) {
            model.addAttribute("smsg", "Registration successful");
            model.addAttribute("counsellor", new Councellor());   // clears the form
        } else {
            model.addAttribute("emsg", "Registration Failure");
        }
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}