package fap_sports.integrador.controllers;

import fap_sports.integrador.models.Decada;
import fap_sports.integrador.models.Rol;
import fap_sports.integrador.models.Tipo;
import fap_sports.integrador.models.Usuario;
import fap_sports.integrador.services.RolService;
import fap_sports.integrador.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistroController {

    private final UsuarioService usuarioService;
    private final RolService rolService;

    public RegistroController(UsuarioService usuarioService, RolService rolService) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
    }

    @GetMapping("/registro")
    public String mostrarRegistroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.listarRoles());
        model.addAttribute("tipos", usuarioService.getAllTipos()); // Obtener tipos desde UsuarioService
        model.addAttribute("decadas", usuarioService.getAllDecadas()); // Obtener décadas desde UsuarioService
        model.addAttribute("usuarios", usuarioService.getAllUsuarios()); // Asegúrate de cargar la lista de licenciados
        return "vistas/registrarLicenciado";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario, @RequestParam Long tipoId, @RequestParam Long decId) {
        try {
            // Obtener tipo y década por ID
            Tipo tipo = usuarioService.getTipoById(tipoId);
            Decada decada = usuarioService.getDecadaById(decId);
            usuario.setTipo(tipo);
            usuario.setDecada(decada);
            
            // Asignar rol si no hay
            if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
                Rol rolInvitado = rolService.obtenerRolPorId(3L);
                if (rolInvitado != null) {
                    List<Rol> roles = new ArrayList<>();
                    roles.add(rolInvitado);
                    usuario.setRoles(roles);
                }
            }

            usuarioService.registrarUsuario(usuario);
            return "redirect:/registro";

        } catch (Exception e) {
            return "vistas/registrarLicenciado"; // Manejo de errores simple
        }
    }
    @PostMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/registro";
    }
}