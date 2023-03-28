
package com.proyectotv.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="comentario")
public class Comentario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comentario")
    private Long idComentario;
    
    private String detalle;
    
    @JoinColumn(name="id_factura", referencedColumnName="id_factura")
    @ManyToOne
    private Factura factura;

    public Comentario() {
    }

    public Comentario(String detalle) {
        this.detalle = detalle;
    }
    
}
