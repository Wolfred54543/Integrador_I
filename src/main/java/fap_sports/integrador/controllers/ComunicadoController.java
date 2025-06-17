package fap_sports.integrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fap_sports.integrador.models.Comunicado;
import fap_sports.integrador.services.ComunicadoService;

@Controller
public class ComunicadoController {
    @Autowired
    private ComunicadoService comunicadoService;

    @GetMapping("/formularioComunicados")
    public String formularioComunicados(Model model) {
        model.addAttribute("comunicado", new Comunicado());
        model.addAttribute("comunicados", comunicadoService.getAllComunicados());
        return "vistas/comunicados"; 
    }

    @PostMapping("/registrarComunicados")
    public String registrarComunicados(@ModelAttribute Comunicado comunicado) {
        comunicadoService.registrarComunicado(comunicado); 
        return "redirect:/formularioComunicados";
    }
}
