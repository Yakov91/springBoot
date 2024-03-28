package com.example.springBoot.controller;

import com.example.springBoot.model.User;
import com.example.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //@RequestMapping("/")
    @GetMapping("/")
    public String getAllUses(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all_users";
    }

    @GetMapping("/create_user")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping("/create_user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/update_user")
    public String getWhichUserUpdate(Model model) {
       model.addAttribute("userUpdate", new User());
       return "update_user";
    }

    @PostMapping("/update_user")
    public String getUpdateUser(@ModelAttribute("userUpdate") User user) {
        try {
            userService.updateUser(user.getId(), user);
        } catch (Exception e) {
            System.out.println("There is no such user!");
        }
        return "all_users"; //redirect:/
    }


    @GetMapping("/delete_user")
    public String getWhichUserDelete(Model model) {
        model.addAttribute("userDelete", new User());
        return "delete_user";
    }

    @PostMapping("/delete_user")
    public String deleteUser(@ModelAttribute("userDelete") User user) {
        try {
            userService.deleteUser(user.getId());
        } catch (Exception e) {
            System.out.println("There is no such user!");
        }
        return "redirect:/";
    }
}
