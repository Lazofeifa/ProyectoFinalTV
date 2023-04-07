package com.proyectotv.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long idCliente;
    
    private String nombre;
    private String apellidos;
    private String telefono;
    
    @JoinColumn(name="id_ubicacion", referencedColumnName="id_ubicacion")
    @ManyToOne
    private Ubicacion ubicacion;
    
    @JoinColumn(name="id_suscripcion", referencedColumnName="id_suscripcion")
    @ManyToOne
    private Suscripcion suscripcion;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String telefono, Ubicacion ubicacion, Suscripcion suscripcion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.suscripcion = suscripcion;
    }
    
    
    
}
