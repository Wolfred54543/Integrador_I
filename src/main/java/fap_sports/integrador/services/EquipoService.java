package fap_sports.integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fap_sports.integrador.models.Equipo;
import fap_sports.integrador.repositories.EquipoRepository;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;


    public Equipo registrarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public void eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
    
    public Equipo getEquipoById(Long id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));
    }

    public void actualizarEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }
}
