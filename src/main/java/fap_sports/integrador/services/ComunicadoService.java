package fap_sports.integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fap_sports.integrador.models.Comunicado;
import fap_sports.integrador.repositories.ComunicadoRepository;

@Service
public class ComunicadoService {
    @Autowired
    private ComunicadoRepository comunicadoRepository;


    public Comunicado registrarComunicado(Comunicado comunicado) {
        return comunicadoRepository.save(comunicado);
    }

    public List<Comunicado> getAllComunicados() {
        return comunicadoRepository.findAll();
    }

    public void deleteComunicado(Long id) {
        comunicadoRepository.deleteById(id);
    }

    public Comunicado getComunicadoById(Long id) {
        return comunicadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comunicado no encontrado con ID: " + id));
    }

    public void updateComunicado(Comunicado comunicado) {
        comunicadoRepository.save(comunicado);
    }
}
