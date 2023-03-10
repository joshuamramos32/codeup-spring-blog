package com.codeup.codeupspringblog.controllers;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<Post> posts = postDao.findAll();
       model.addAttribute("posts",posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsHome(@PathVariable long id, Model model) {
        Post post = postDao.findById(id);
        User user = post.getUser();
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId() == loggedInUser.getId()) {
            model.addAttribute("post", post);
            model.addAttribute("userEmail", user.getEmail());
            return "posts/show";
        } else {

            return "redirect:/posts";
        }
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/save")
    public String savePost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post origPost = postDao.findById(post.getId()); {
                if (origPost == null || user.getId() == origPost.getUser().getId()) {
                    post.setUser(user);
                    postDao.save(post);
                    emailService.preparedAndSendPost(post);
            }
            return "redirect:/posts";
        }
    }

        @GetMapping("/posts/{id}/edit")
        public String editPostForm (Model model,@PathVariable long id){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Post post = postDao.findById(id);
            if (user.getId() == post.getUser().getId()) {
                model.addAttribute("post", post);
                return "posts/create";
            }else{

            return "redirect:/posts";
        }
    }



}

