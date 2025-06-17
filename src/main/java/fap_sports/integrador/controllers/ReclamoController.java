package fap_sports.integrador.controllers;

import fap_sports.integrador.models.Reclamo;
import fap_sports.integrador.services.ReclamoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReclamoController {

    private final DelegadoController delegadoController;

    private static final Logger logger = LoggerFactory.getLogger(RegistroController.class);

    private final ReclamoService reclamoService;

    public ReclamoController(ReclamoService reclamoService, DelegadoController delegadoController) {
        this.reclamoService = reclamoService;
        this.delegadoController = delegadoController;

    }

    @GetMapping("/reclamoFormulario")
    public String mostrarReclamoForm(Model model) { 
        return "vistas/reclamoFormulario";
    }

    @PostMapping("/reclamoFormulario")
    public String registrarReclamo(
            @RequestParam("motivo") String motivo,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("solicitud") String solicitud,
            Model model) {

        try {
            if (motivo == null || motivo.trim().isEmpty()) {
                model.addAttribute("error", "El motivo no puede estar vacio.");
                return "vistas/reclamoFormulario";
            }
            if (descripcion == null || descripcion.trim().isEmpty()) {
                model.addAttribute("error", "La descripcion no puede estar vacia.");
                return "vistas/reclamoFormulario";
            }
            if (solicitud == null || solicitud.trim().isEmpty()) {
                model.addAttribute("error", "La solicitud no puede estar vacia.");
                return "vistas/reclamoFormulario";
            }

            logger.info("Recibiendo datos del formulario: nombre={}, apellido={}, fechaNacimiento={}, email={}, telefono={}, dni={}, roles={}",
                    motivo, descripcion, solicitud);

            Reclamo nuevoReclamo = new Reclamo(motivo,descripcion,solicitud);

            logger.info("Intentando registrar reclamo: {}", nuevoReclamo);

            reclamoService.registrarReclamo(nuevoReclamo);
            model.addAttribute("mensaje", "Reclamo registrado con exito");
            return "vistas/reclamoFormulario";

        } catch (Exception e) {
            logger.error("Error al registrar el reclamo", e);
            model.addAttribute("error", "Error al registrar el reclamo: " + e.getMessage());
            return "vistas/reclamoFormulario";
        }
    }

     @GetMapping("/reclamoHistorial")
        public String listarReclamos(Model model) {
        List<Reclamo> reclamos = reclamoService.listarReclamos();
        model.addAttribute("reclamos", reclamos);
        return "vistas/reclamoHistorial";
    }
}