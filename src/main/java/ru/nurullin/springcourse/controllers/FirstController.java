package ru.nurullin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nurullin.springcourse.config.Operations;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping
    public String home(){
        return "first/home";
    }

    @PostMapping
    public String home(
            @RequestParam(name = "first_number", defaultValue = "0") String first_number,
            @RequestParam(name = "second_number", defaultValue = "0") String second_number,
            @RequestParam(name = "operation", required = false) Operations operation,
            @RequestParam(name = "result_field", required = false, defaultValue = "") String result_field,
            Model model) {

        StringBuilder builder = new StringBuilder();
        builder.append(result_field);

        String result = result_field + "\n";
        try {
            int first = Integer.parseInt(first_number);
            int second = Integer.parseInt(second_number);

            switch (operation) {
                case ADDITION: result = first + second + "";
                    break;
                case SUBTRACTION: result = first - second + "";
                    break;
                case MULTIPLICATION: result = first * second + "";
                    break;
                case DIVISION: result = first / second + "";
                    break;
                default: result = "Ошибка ввода данных";
            }
        } catch (Exception e) {
            result = "Ошибка ввода данных";
        }

        builder.insert(0, result + "\n");

        model.addAttribute("operation", operation);
        model.addAttribute("first_number", first_number);
        model.addAttribute("second_number", second_number);
        model.addAttribute("result_field", builder.toString());
        return "first/home";
    }

}
