package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","World!");
        return "Hello";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, Model model){
        model.addAttribute("name",name);
        return "Hello";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @GetMapping("exponent/{num}/{pow}")
    @ResponseBody
    public String expoonent(@PathVariable int num, @PathVariable int pow) {
        return String.format("%d raised to the power %d gives the result of %d",num,pow, (int)(Math.pow(num,pow)));
    }


}
