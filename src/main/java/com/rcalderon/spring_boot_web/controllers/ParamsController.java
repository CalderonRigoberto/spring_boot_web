package com.rcalderon.spring_boot_web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "Desconocido") String texto,
            Model model) {
        model.addAttribute("resultado", "El texto enviado es " + texto);

        // Retorna la vista
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero,
            Model model) {
        model.addAttribute("resultado", "El saludo enviado es " + saludo + ", numero = " + numero);
        return "params/ver";
    }

    /**
     * HttpServletRequest, te ayuda a obtener todos los elementos que son
     * enviados a través de la urñ
     * 
     * @param request
     * @param model
     * @return
     */
    @GetMapping("/httpservletejemplo")
    public String param(HttpServletRequest request,
            Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {

        }

        model.addAttribute("resultado", "El saludo enviado es " + saludo + ", numero = " + numero);
        return "params/ver";
    }
}
