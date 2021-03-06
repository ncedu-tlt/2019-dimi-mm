package com.ncedu.eventx.controllers;

import com.ncedu.eventx.models.entities.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "registrationPages/RegistrationPage";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationSubmit(@ModelAttribute @Valid UserEntity user, Model model, BindingResult bindingResult) {
        model.addAttribute(user);
        if (bindingResult.hasErrors()) {
            return "registrationPages/RegistrationPage";
        }
        return "primaryCabinetPages/LogIn";
    }
}