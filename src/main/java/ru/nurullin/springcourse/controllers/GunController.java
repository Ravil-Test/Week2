package ru.nurullin.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nurullin.springcourse.dao.GunDAO;
import ru.nurullin.springcourse.models.Gun;

@Controller
@RequestMapping("/weapon")
public class GunController {

    private final GunDAO gunDAO;

    @Autowired
    public GunController(GunDAO gunDAO) {
        this.gunDAO = gunDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("weapon", gunDAO.index());
        return "weapon/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("gun", gunDAO.show(id));
        return "weapon/show";
    }

    @GetMapping("/new")
    public String newGun(@ModelAttribute("gun") Gun gun) {
        return "weapon/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("gun") Gun gun) {
        gunDAO.save(gun);
        return "redirect:/weapon";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("gun", gunDAO.show(id));
        return "weapon/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("gun") Gun gun, @PathVariable("id") int id) {
        gunDAO.update(id, gun);
        return "redirect:/weapon";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        gunDAO.delete(id);
        return "redirect:/weapon";
    }
}