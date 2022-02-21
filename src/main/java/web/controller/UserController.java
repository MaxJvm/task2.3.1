package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getAll(Model model) {
        List<User> users = new ArrayList<>(userService.getAllUsers());
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/user/{id}")
    public String getUser(Model model, @PathVariable long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @PostMapping("/save/{id}")
    public String saveUser(@PathVariable long id, @RequestParam String name, @RequestParam String surname) {
        if (id == 0) {
            userService.saveUser(new User(name, surname));
        } else {
            userService.updateUser(id, name, surname);
        }
        return "redirect:/";
    }

}