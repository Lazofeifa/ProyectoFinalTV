
package com.proyectotv.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="suscripcion")
public class Suscripcion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_suscripcion")
    private Long idSuscripcion;
    
    private String tiposus;

    public Suscripcion() {
    }

    public Suscripcion(String tiposus) {
        this.tiposus = tiposus;
    }
    
    
    
}
