package fap_sports.integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fap_sports.integrador.models.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

}
