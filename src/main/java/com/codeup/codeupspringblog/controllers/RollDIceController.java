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
        int diceRoll1 = (int) Math.ceil(Math.random() * 6);
        int diceRoll2 = (int) Math.ceil(Math.random() * 6);
        int diceTotal = diceRoll1 + diceRoll2;
        if (guess == diceRoll1 && guess == diceRoll2 ) {
            message = "WOW you guessed both dice right!";
        } else if (guess == diceRoll1){
            message = "Good job you guessed dice 1 right";
        } else if (guess == diceRoll2) {
            message = "Good job you guessed dice 2 right";
        } else if (guess == diceTotal) {
            message = "Your total for both dice equal your guess";
        }else {
            message = "Better luck next time....";
        }
        model.addAttribute("message", message);
        model.addAttribute("guess", guess);
        model.addAttribute("diceRoll1", diceRoll1);
        model.addAttribute("diceRoll2", diceRoll2);
        model.addAttribute("diceTotal",diceTotal);
        return "rolldice";
    }
}
