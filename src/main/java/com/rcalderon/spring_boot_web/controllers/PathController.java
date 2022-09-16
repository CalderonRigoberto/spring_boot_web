package com.rcalderon.spring_boot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathController {

    @GetMapping("/string/{texto}")
    public String variable(@PathVariable(name = "texto") String texto, Model model) {
        model.addAttribute("texto", "El texto es " + texto);
        return "variables/ver";
    }
}
