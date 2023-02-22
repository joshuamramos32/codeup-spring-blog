package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("First post title", "First post body", 1);
        Post post2 = new Post("Second post title", "Second post body", 2);
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{postId}")
    public String postsId(@PathVariable long postId, Model model){
        Post post = new Post("Post title", "Post content", 1);
        Post post1 = new Post("1","1",2);
        model.addAttribute("post", post);
        model.addAttribute("post1", post1);
        return "posts/show" ;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate(){
      return "This will be the page to show the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "This will be the post page that creates the new post" ;
    }
}

