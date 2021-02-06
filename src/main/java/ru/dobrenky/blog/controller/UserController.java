package ru.dobrenky.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.dobrenky.blog.model.User;
import ru.dobrenky.blog.model.dto.UserDTO;
import ru.dobrenky.blog.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        User regUser = new User(user.getUserName(), user.getEmail(), user.getPassword());
        userRepository.save(regUser);
        return new ModelAndView("redirect:/");
    }
}
