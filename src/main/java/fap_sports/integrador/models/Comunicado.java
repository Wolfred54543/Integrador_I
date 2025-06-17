package fap_sports.integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "comunicados")
public class Comunicado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "com_id") 
    private Long comId;

    @Column(name = "com_titulo")
    private String comTitulo; 

    @Column(name = "com_descripcion")
    private String comDescripcion;

    @Column(name = "com_imagen")
    private String comImagen;

    
    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getComTitulo() {
        return comTitulo;
    }

    public void setComTitulo(String comTitulo) {
        this.comTitulo = comTitulo;
    }

    public String getComDescripcion() {
        return comDescripcion;
    }

    public void setComDescripcion(String comDescripcion) {
        this.comDescripcion = comDescripcion;
    }

    public String getComImagen() {
        return comImagen;
    }

    public void setComImagen(String comImagen) {
        this.comImagen = comImagen;
    }

}
