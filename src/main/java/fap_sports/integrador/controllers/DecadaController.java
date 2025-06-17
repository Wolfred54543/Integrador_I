package fap_sports.integrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fap_sports.integrador.models.Decada;
import fap_sports.integrador.services.DecadaService;

@Controller
public class DecadaController {
    @Autowired
    private DecadaService decadaService;

    @GetMapping("/formularioDecadas")
    public String formularioDecadas(Model model) {
        model.addAttribute("decada", new Decada());
        model.addAttribute("decadas", decadaService.getAllDecadas());
        return "vistas/decadas"; 
    }

    @PostMapping("/registrarDecadas")
    public String registrarDecadas(@ModelAttribute Decada decada) {
        decadaService.registrarDecada(decada); 
        return "redirect:/formularioDecadas";
    }
}
