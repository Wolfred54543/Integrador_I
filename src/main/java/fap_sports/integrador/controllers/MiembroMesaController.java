package fap_sports.integrador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiembroMesaController {
    @GetMapping("/miembroMesa")
    public String miembroMesa() {
        return "vistas/miembroMesa";
    }
}