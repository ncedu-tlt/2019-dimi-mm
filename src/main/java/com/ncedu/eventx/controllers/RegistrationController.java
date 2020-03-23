package com.ncedu.eventx.controllers;

import com.ncedu.eventx.models.DTO.UserDTO;
import com.ncedu.eventx.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    /*@Autowired
    private UsersService userService;

    @GetMapping(value = "/registration",
                produces = { MediaType.APPLICATION_JSON_VALUE
                })
    @ResponseBody
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid UserDTO userForm) {

        userService.createRegisteredUser(userForm);

        return "redirect:/";
    } */

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