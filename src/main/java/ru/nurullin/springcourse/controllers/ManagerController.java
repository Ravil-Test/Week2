package ru.nurullin.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nurullin.springcourse.dao.PersonDAO;
import ru.nurullin.springcourse.models.Person;

@Controller
@RequestMapping("/people1")
public class ManagerController {

    private final PersonDAO personDAO;

    @Autowired
    public ManagerController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String manindex(Model model) {
        model.addAttribute("peopleman", personDAO.manindex());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String manshow(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.manshow(id));
        return "people1/manshow";
    }

    @GetMapping("/newman")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people1/newman";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAO.mansave(person);
        return "redirect:/people1";
    }

    @GetMapping("/{id}/manedit")
    public String manedit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.manshow(id));
        return "people1/manedit";
    }

    @PatchMapping("/{id}")
    public String manupdate(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDAO.manupdate(id, person);
        return "redirect:/people1";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people1";
    }
}