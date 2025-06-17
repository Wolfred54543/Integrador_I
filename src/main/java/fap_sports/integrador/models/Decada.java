package fap_sports.integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "decadas")
public class Decada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dec_id")
    private Long decId;

    @Column(name = "anio_inicio")
    private int anioInicio;

    @Column(name = "dec_mes")
    private String decMes;

    public Decada() {}

    public Decada(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Long getDecId() {
        return decId;
    }

    public void setDecId(Long decId) {
        this.decId = decId;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public String getDecMes() {
        return decMes;
    }

    public void setDecMes(String decMes) {
        this.decMes = decMes;
    }
    
}