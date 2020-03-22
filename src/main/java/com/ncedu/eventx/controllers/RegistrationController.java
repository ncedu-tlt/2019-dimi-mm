package com.ncedu.eventx.controllers;

import com.ncedu.eventx.models.DTO.UserDTO;
import com.ncedu.eventx.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UsersService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDTO());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid UserDTO userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }

        if (!userService.createRegisteredUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";
    }

    /*final UsersService usersService;

    public RegistrationController(UsersService usersService) {
        this.usersService = usersService;
    }
    UsersMapper usersMapper = Mappers.getMapper(UsersMapper.class);

    @GetMapping(value = "/registration")
    public String registrationForm(Model model) {

        model.addAttribute("user", new UserDTO());
        return "registrationPages/RegistrationPage";
    }

    @PostMapping(value = "/registration")
    @ResponseBody
    public UserForCreateDTO registrationSubmit(@RequestBody UserDTO user) {

        usersService.createRegisteredUser(user);
        return usersMapper.toUserForCreateDTO(usersService.getUserById(user.getId()));
    } */
}