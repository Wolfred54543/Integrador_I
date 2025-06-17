package fap_sports.integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_id") // Asegúrate de que coincida con el nombre en la base de datos
    private Long tipoId;

    @Column(name = "tipo_nombre") // Asegúrate de que coincida con el nombre en la base de datos
    private String tipoNombre;

    // Getters y Setters
    public Long getTipoId() {
        return tipoId;
    }

    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipoNombre() {
        return tipoNombre; // Este es el nombre correcto
    }

    public void setTipoNombre(String tipoNombre) {
        this.tipoNombre = tipoNombre; // Este es el nombre correcto
    }
}