package org.lessons.booleaners.springlamiapizzeriacrud.controller;

import org.lessons.booleaners.springlamiapizzeriacrud.model.Pizza;
import org.lessons.booleaners.springlamiapizzeriacrud.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository repo;

    @GetMapping()
    public String pizzas(Model model, @RequestParam(name = "name", required = false) String name) {
        List<Pizza> pizzas;
        if(name != null && !name.isEmpty()) {
            pizzas = repo.findByNameContainingIgnoreCaseOrderByNameAsc(name);
        } else {
            pizzas = repo.findAll();
        }
        model.addAttribute("pizza", pizzas);
        return "/pizzas/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pizza", repo.findById(id).get());
        return "/pizzas/show";
    }

}
