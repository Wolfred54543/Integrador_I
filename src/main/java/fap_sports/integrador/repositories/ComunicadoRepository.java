package fap_sports.integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fap_sports.integrador.models.Comunicado;

public interface ComunicadoRepository extends JpaRepository<Comunicado, Long> {
    
}
