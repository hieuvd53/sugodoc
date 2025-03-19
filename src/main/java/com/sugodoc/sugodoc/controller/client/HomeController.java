package com.sugodoc.sugodoc.controller.client;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sugodoc.sugodoc.domain.User;
import com.sugodoc.sugodoc.domain.dto.RegisterDTO;
import com.sugodoc.sugodoc.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class HomeController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public HomeController(UserService userService,PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "/client/homepage/show";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "/client/auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("registerUser") RegisterDTO registerDTO) {
        //TODO: process POST request
        User user = this.userService.registerDTOtoUser(registerDTO);
        String hassPassword = this.passwordEncoder.encode(registerDTO.getPassword());
        user.setPassword(hassPassword);
        user.setRole(this.userService.getRoleById(2));

        this.userService.handleSaveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/client/auth/login";
    }

}
