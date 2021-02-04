package ru.dobrenky.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dobrenky.blog.model.Post;
import ru.dobrenky.blog.repository.PostRepository;

@Controller
public class MainController {

    private PostRepository postRepository;

    @Autowired
    public MainController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("postsCount", postRepository.count());
        model.addAttribute("posts", postRepository.findAll());
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

