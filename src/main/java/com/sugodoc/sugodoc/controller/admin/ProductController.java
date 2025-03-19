package com.sugodoc.sugodoc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sugodoc.sugodoc.domain.User;

@Controller
public class ProductController {

    @GetMapping("/admin/product")
    public String getProduct() {
        return "admin/product/show";
    }

    // create page
    @RequestMapping("/admin/product/create")
    public String getCreateUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/product/create";
    }
}
