package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num}/{number}")
    @ResponseBody
    public String addNum(@PathVariable int num, @PathVariable int number) {
        return num + " plus " + number + " is " + (num + number);
    }

    @GetMapping("/subtract/{num}/{number}")
    @ResponseBody
    public String subtractNum(@PathVariable int num, @PathVariable int number) {
        return num + " minus " + number + " is " + (number - num);
    }

    @GetMapping("/multiply/{num}/{number}")
    @ResponseBody
    public String multiplyNum(@PathVariable int num, @PathVariable int number) {
        return num + " times " + number + " is " + (number * num);
    }


    @GetMapping("/divide/{num}/{number}")
    @ResponseBody
    public String divideNum(@PathVariable int num, @PathVariable int number) {
        return number + " divided by " + num + " is " + (number / num);
    }
}
