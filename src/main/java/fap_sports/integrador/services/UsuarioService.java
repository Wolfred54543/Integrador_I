package fap_sports.integrador.services;

import fap_sports.integrador.models.Decada;
import fap_sports.integrador.models.Tipo;
import fap_sports.integrador.models.Usuario;
import fap_sports.integrador.repositories.DecadaRepository;
import fap_sports.integrador.repositories.TipoRepository;
import fap_sports.integrador.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private DecadaRepository decadaRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registrarUsuario(Usuario usuario) {
        String contraseniaEncriptada = passwordEncoder.encode(usuario.getContrasenia());
        usuario.setContrasenia(contraseniaEncriptada);
        
        // Guardar el usuario
        usuarioRepository.save(usuario);
    }

    public boolean existeCorreo(String correo) {
        return usuarioRepository.existsByEmail(correo);
    }

    public boolean existeDni(String dni) {
        return usuarioRepository.existsByDni(dni);
    }

    public boolean existeTelefono(String telefono) {
        return usuarioRepository.existsByTelefono(telefono);
    }




    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Licenciado no encontrado con ID: " + id));
    }

    public void updateUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }


    public Tipo getTipoById(Long tipoId) {
        return tipoRepository.findById(tipoId)
                .orElseThrow(() -> new RuntimeException("Tipo no encontrado con ID: " + tipoId));
    }

    public List<Tipo> getAllTipos() {
        return tipoRepository.findAll();
    }

    public Decada getDecadaById(Long decId) {
        return decadaRepository.findById(decId)
                .orElseThrow(() -> new RuntimeException("Decada no encontrada con ID: " + decId));
    }

    public List<Decada> getAllDecadas() {
        return decadaRepository.findAll();
    }
}