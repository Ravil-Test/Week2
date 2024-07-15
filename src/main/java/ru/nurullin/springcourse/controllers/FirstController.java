package ru.nurullin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;

@Controller
public class FirstController {

    @GetMapping("/home")
    public String homePage(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);

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
