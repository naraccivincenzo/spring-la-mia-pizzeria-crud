package org.lessons.booleaners.springlamiapizzeriacrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping("/")
    public String home(Model model) {
        return "/pages/homepage";
    }


}
