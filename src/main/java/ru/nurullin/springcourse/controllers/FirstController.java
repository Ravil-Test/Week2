package ru.nurullin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @GetMapping("/home")
    public String homePage() {
        return "first/home";
    }

    @GetMapping("/hello")
    public String helloPage() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String hello() {
        return "first/goodbye";
    }

}
