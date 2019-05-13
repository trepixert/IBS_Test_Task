package com.ibs.task.controllers;

import com.ibs.task.models.User;
import com.ibs.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomePageController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String home(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "home";
    }

    @GetMapping("edit/{id}")
    public String update(@PathVariable(name = "id") int id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "fragments/update-user";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") int id, @Valid User user,
                         BindingResult result, Model model
    ) {
        if(result.hasErrors()){
            user.setId(id);
            return "fragments/update-user";
        }
        userService.update(user);
        model.addAttribute("users",userService.getAllUsers());
        return "redirect:/home";
    }

    @GetMapping("addingUser")
    public String add(){
        return "addingUser";
    }

    @PostMapping("addingUser")
    public String add(@Valid User user, Model model){
        userService.save(user);
        model.addAttribute("users",userService.getAllUsers());
        return "redirect:/home";
    }
}
