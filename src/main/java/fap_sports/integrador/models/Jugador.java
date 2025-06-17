package fap_sports.integrador.models;


import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jug_id")
    private Long jugId;

    @Column(name = "jug_nombre")
    private String jugNombre;

    @Column(name = "jug_apellido")
    private String jugApellido;
    
    @Column(name = "jug_dni")
    private String jugDni;

}
