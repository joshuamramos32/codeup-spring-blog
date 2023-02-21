package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "This will be the post page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsId(){
        return "This will be the pageto view an idividual post" ;
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

