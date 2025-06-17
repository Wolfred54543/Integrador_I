package fap_sports.integrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fap_sports.integrador.models.Decada;
import fap_sports.integrador.models.Licenciado;
import fap_sports.integrador.models.Tipo;
import fap_sports.integrador.repositories.DecadaRepository;
import fap_sports.integrador.repositories.LicenciadoRepository;
import fap_sports.integrador.repositories.TipoRepository;

import java.util.List;

@Service
public class LicenciadoService {
    @Autowired
    private LicenciadoRepository licenciadoRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private DecadaRepository decadaRepository;

    public Licenciado registerLicenciado(Licenciado licenciado) {
        return licenciadoRepository.save(licenciado);
    }

    public List<Licenciado> getAllLicenciados() {
        return licenciadoRepository.findAll();
    }

    public void deleteLicenciado(Long id) {
        licenciadoRepository.deleteById(id);
    }
    public Licenciado getLicenciadoById(Long id) {
        return licenciadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Licenciado no encontrado con ID: " + id));
    }

    public void updateLicenciado(Licenciado licenciado) {
        licenciadoRepository.save(licenciado);
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