package fap_sports.integrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fap_sports.integrador.repositories.EquipoRepository;
import fap_sports.integrador.models.Equipo;
import fap_sports.integrador.services.EquipoService;

@Controller
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping("/formularioEquipos")
    public String formularioEquipos(Model model) {
        model.addAttribute("equipo", new Equipo());
        model.addAttribute("equipos", equipoService.getAllEquipos());
        return "vistas/equipos"; 
    }

    @PostMapping("/registrarEquipos")
    public String registrarEquipos(@ModelAttribute Equipo equipo) {
        equipoService.registrarEquipo(equipo); 
        return "redirect:/formularioEquipos";
    }
}
