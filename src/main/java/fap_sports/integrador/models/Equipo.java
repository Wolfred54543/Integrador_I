package fap_sports.integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equ_id") 
    private Long equId;

    @Column(name = "equ_nombre")
    private String equNombre; 

    @Column(name = "equ_descripcion")
    private String equDescripcion;

    @Column(name = "equ_url_logo")
    private String equLogo;

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public String getEquNombre() {
        return equNombre;
    }

    public void setEquNombre(String equNombre) {
        this.equNombre = equNombre;
    }

    public String getEquDescripcion() {
        return equDescripcion;
    }

    public void setEquDescripcion(String equDescripcion) {
        this.equDescripcion = equDescripcion;
    }

    public String getEquLogo() {
        return equLogo;
    }

    public void setEquLogo(String equLogo) {
        this.equLogo = equLogo;
    }

    

}
