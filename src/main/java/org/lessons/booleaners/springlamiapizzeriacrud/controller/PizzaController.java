package org.lessons.booleaners.springlamiapizzeriacrud.controller;

import org.lessons.booleaners.springlamiapizzeriacrud.model.Pizza;
import org.lessons.booleaners.springlamiapizzeriacrud.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
