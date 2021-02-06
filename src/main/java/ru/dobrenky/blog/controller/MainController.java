package ru.dobrenky.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dobrenky.blog.model.Post;
import ru.dobrenky.blog.repository.PostRepository;
import ru.dobrenky.blog.repository.UserRepository;

@Controller
public class MainController {

    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public MainController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("postsCount", postRepository.count());
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "/index";
    }

    @GetMapping("/post/create")
    public String postCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping("/post/create")
    public ModelAndView post(Model model, @ModelAttribute Post post) {
        postRepository.save(post);
        // TODO: redirect
        return new ModelAndView("redirect:/");
    }
}

