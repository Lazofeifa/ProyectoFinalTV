
package com.proyectotv.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="ubicacion")
public class Ubicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ubicacion")
    private Long idUbicacion;
    private String pais;
    private String ciudad;

    public Ubicacion() {
    }

    public Ubicacion(String pais, String ciudad) {
        this.pais = pais;
        this.ciudad = ciudad;
    }

    
}
