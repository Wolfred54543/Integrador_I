package fap_sports.integrador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PartidoController {
    @GetMapping("/formularioPartidos")
    public String formularioPartidos() {
        return "vistas/partidos";
    }
}
