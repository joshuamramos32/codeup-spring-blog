package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDIceController {
    @GetMapping("/roll-dice/{guess}")
    public String getDice(@PathVariable int guess, Model model) {
        String message;
        int diceRoll = (int) Math.ceil(Math.random() * 6);
        if (guess == diceRoll) {
            message = "Good job! You guessed right!";
        } else {
            message = "Better luck next time...";
        }
        model.addAttribute("message", message);
        model.addAttribute("guess", guess);
        model.addAttribute("diceRoll", diceRoll);
        return "rolldice";
    }
}
