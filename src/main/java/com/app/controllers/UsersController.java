package com.app.controllers;

import com.app.entities.Users;
import com.app.entities.UsersInfo;
import com.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/u")
public class UsersController {
    UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<Users> users = (List<Users>) usersRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/showFormForAdd")
    public String addUsers(Model model) {
        Users users = new Users();
        UsersInfo usersInfo = new UsersInfo();
        model.addAttribute("users", users);
        model.addAttribute("usersInfo", usersInfo);
        return "users-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("tempUser") int id, Model model) {
        Users users = usersRepository
                .findById(Integer.toUnsignedLong(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid id" + id));
        model.addAttribute("users", users);

        return "users-form";
    }


    @PostMapping("/save")
    public String saveUsers(@ModelAttribute("users") Users users, @ModelAttribute("usersInfo") UsersInfo usersInfo) {
        users.setUsersInfo(usersInfo);
        usersRepository.save(users);
//        model.addAttribute("users", usersRepository.findAll());
        return "users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        usersRepository.deleteById(id);
        return "users";
    }
}
