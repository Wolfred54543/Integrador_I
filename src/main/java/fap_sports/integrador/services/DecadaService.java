package fap_sports.integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fap_sports.integrador.models.Decada;
import fap_sports.integrador.repositories.DecadaRepository;

@Service
public class DecadaService {

    @Autowired
    private DecadaRepository decadaRepository;


    public Decada registrarDecada(Decada decada) {
        return decadaRepository.save(decada);
    }

    public List<Decada> getAllDecadas() {
        return decadaRepository.findAll();
    }

    public void eliminarDecada(Long id) {
        decadaRepository.deleteById(id);
    }
    
    public Decada getDecadaById(Long id) {
        return decadaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));
    }

    public void actualizarDecada(Decada decada) {
        decadaRepository.save(decada);
    }
}
