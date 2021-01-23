package ru.dobrenky.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dobrenky.blog.repository.PostRepository;

@Controller
public class MainController {

    private PostRepository postRepository;

    @Autowired
    public MainController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("/")
    public String index() {
        System.out.println(postRepository.count());
        return "index";
    }
}

