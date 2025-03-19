package com.sugodoc.sugodoc.controller.admin;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sugodoc.sugodoc.domain.User;
import com.sugodoc.sugodoc.service.UserService;

import jakarta.validation.Valid;


@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService,PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/")
    public String login(Model model){
        return "index";
    }

    // user list page
    @RequestMapping("/admin/user")
    public String getUserPage(Model model){
        List<User> listUser = this.userService.getAllUser();
        model.addAttribute("listUser", listUser);
        return "admin/user/show";
    }

    // create page
    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model){
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", this.userService.getRoles());
        return "admin/user/create";
    }

    // insert process
    @PostMapping("/admin/user/insert")
    public String insertUser(Model model,
        @ModelAttribute("newUser") @Valid User newUser,
        BindingResult newUserBindingResult
        ){

        //validate
        List<FieldError> errors = newUserBindingResult.getFieldErrors();
        for (FieldError error : errors ) {
            System.out.println (error.getField() + " - " + error.getDefaultMessage());
        }

        // nếu có lỗi return lai page create và hiển thị thông báo lỗi
        if(newUserBindingResult.hasErrors()){
            return "/admin/user/create";
        }

        String hassPassword = this.passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(hassPassword);
        newUser.setRole(this.userService.getRoleById(newUser.getRole().getId()));
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

    // update page
    @RequestMapping(value = "/admin/user/update/{id}", method = RequestMethod.GET)
    public String getUserUpdatePage(Model model, @PathVariable long id){
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/edit";
    }

    // update process
    @RequestMapping(value = "/admin/user/update/{id}", method = RequestMethod.POST)
    public String updateUser(Model model, @ModelAttribute("user") User user){
        User currentUser = this.userService.getUserById(user.getId());
        if (currentUser != null) {
            currentUser.setAddress(user.getAddress());
            currentUser.setFullName(user.getFullName());
            currentUser.setPhone(user.getPhone());
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    // detail page
    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id){
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }
}
