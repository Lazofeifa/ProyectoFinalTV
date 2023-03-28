
package com.proyectotv.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    
    private String descripcion;
    private String detalle;
    private double precio;

    public Producto() {
    }

    public Producto(String descripcion, String detalle, double precio) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
    }
    
}
