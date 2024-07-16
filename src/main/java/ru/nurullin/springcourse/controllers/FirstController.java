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
            @RequestParam(name = "firstNumber", defaultValue = "0") int firstNumber,
            @RequestParam(name = "secondNumber", defaultValue = "0") int secondNumber,
            @RequestParam(name = "operation", required = false) Operations operation,
            @RequestParam(name = "result_field", required = false, defaultValue = "") String result_field,
            Model model) {

        StringBuilder builder = new StringBuilder();
        builder.append(result_field);

        String result = getResult(firstNumber, secondNumber, operation);

        builder.insert(0, result + "\n");

        model.addAttribute("operation", operation);
        model.addAttribute("first_number", firstNumber);
        model.addAttribute("second_number", secondNumber);
        model.addAttribute("result_field", builder.toString());
        return "first/home";
    }

    private static String getResult(int firstNumber, int secondNumber, Operations operation) {;
        switch (operation) {
            case ADDITION:
                return firstNumber + secondNumber + "";
            case SUBTRACTION:
                return firstNumber - secondNumber + "";
            case MULTIPLICATION:
                return firstNumber * secondNumber + "";
            case DIVISION:
                return firstNumber / secondNumber + "";
            default:
                return "Ошибка ввода данных";
        }
    }

}
