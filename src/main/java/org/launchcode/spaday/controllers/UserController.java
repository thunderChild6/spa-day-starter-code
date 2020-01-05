package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        //TODO
        System.out.println("add method reached--get");
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        System.out.println("add method reached--post " + user.getPassword() +" "+ verify);
        model.addAttribute(user);
        model.addAttribute(verify);
        if (user.getPassword().equals(verify)) {
            System.out.println("passwords match");
        return "user/index";
        } else {
            System.out.println("passwords don't match");
            return "user/add";
        }

    }

}
