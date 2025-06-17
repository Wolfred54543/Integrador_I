package fap_sports.integrador.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamos")
public class Reclamo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_id")
    private Long recId;

    @Column(name = "rec_motivo", nullable = false)
    private String recMotivo;

    @Column(name = "rec_descripcion", nullable = false)
    private String recDescripcion;

    @Column(name = "rec_solicitud", nullable = false)
    private String recSolicitud;

    public Reclamo(){}

    public Reclamo(String recMotivo, String recDescripcion, String recSolicitud) {
        this.recMotivo = recMotivo;
        this.recDescripcion = recDescripcion;
        this.recSolicitud = recSolicitud;
    }

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getRecMotivo() {
        return recMotivo;
    }

    public void setRecMotivo(String recMotivo) {
        this.recMotivo = recMotivo;
    }

    public String getRecDescripcion() {
        return recDescripcion;
    }

    public void setRecDescripcion(String recDescripcion) {
        this.recDescripcion = recDescripcion;
    }

    public String getRecSolicitud() {
        return recSolicitud;
    }

    public void setRecSolicitud(String recSolicitud) {
        this.recSolicitud = recSolicitud;
    }

    @Override
    public String toString() {
        return "Reclamo{" +
                "id=" + recId +
                ", motivo='" + recMotivo + '\'' +
                ", descripcion='" + recDescripcion + '\'' +
                ", solicitud=" + recSolicitud +
                '}';
    }

}

