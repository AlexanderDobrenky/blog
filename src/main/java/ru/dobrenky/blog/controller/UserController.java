package ru.dobrenky.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.dobrenky.blog.exception.UserAlreadyExistException;
import ru.dobrenky.blog.model.dto.UserDTO;
import ru.dobrenky.blog.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public ModelAndView registerNewUserForm(Model model) {
        UserDTO userDTO = new UserDTO();
        return new ModelAndView("registration", "user", userDTO);
    }

    @PostMapping("/registration")
    public ModelAndView register(@ModelAttribute("user") @Valid UserDTO user, Errors errors) {
        if (errors.hasErrors()) {
            return new ModelAndView("registration", "user", user);
        }

        try {
            userService.createNewUserAccount(user);
        } catch (UserAlreadyExistException e) {
            errors.reject("form.registration.validation.userAlreadyRegistered");
            return new ModelAndView("registration", "user", user);
        }
        return new ModelAndView("redirect:/");
    }
}
