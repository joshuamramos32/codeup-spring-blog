package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String posts(Model model){
       model.addAttribute("posts",postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsHome(@PathVariable long id, Model model){
        Post post = postDao.getReferenceById(id);
        User user = post.getUser();
        model.addAttribute("post", post);
        model.addAttribute("userEmail", user.getEmail());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/save")
    public String savePost(@ModelAttribute Post post){
        User user = userDao.findById(1);
        post.setUser(user);
        postDao.save(post);
        emailService.preparedAndSendPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPostForm(Model model, @PathVariable long id) {
        model.addAttribute("post", postDao.findById(id));
        return "posts/create";
    }
}

