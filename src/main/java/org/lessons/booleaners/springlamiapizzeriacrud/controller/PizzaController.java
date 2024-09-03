package org.lessons.booleaners.springlamiapizzeriacrud.controller;

import org.lessons.booleaners.springlamiapizzeriacrud.model.Pizza;
import org.lessons.booleaners.springlamiapizzeriacrud.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    //repository field con autowired per d.i.
    @Autowired
    private PizzaRepository repo;

    @GetMapping()
    public String pizzas(Model model) {
        List<Pizza> pizzas = repo.findAll();
        model.addAttribute("pizza", pizzas);
        return "/pizzas/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pizza", repo.findById(id).get());
        return "/pizzas/show";
    }

    @GetMapping("/findByNameContains/{name}")
    public String findByNameContains(@PathVariable("name") String name, Model model) {
        model.addAttribute("pizza", repo.findByNameContains(name));
        return "/pizzas/index";
    }
}
