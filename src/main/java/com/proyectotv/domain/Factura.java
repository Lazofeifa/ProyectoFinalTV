
package com.proyectotv.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="factura")
public class Factura implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private Long idFactura;
    
    private String fecha;
    private double total;

    @JoinColumn(name="id_producto", referencedColumnName="id_producto")
    @ManyToOne
    private Producto producto;
    
    @JoinColumn(name="id_suscripcion", referencedColumnName="id_suscripcion")
    @ManyToOne
    private Suscripcion suscripcion;
    
    @JoinColumn(name="id_perfil", referencedColumnName="id_perfil")
    @ManyToOne
    private Perfil perfil;
    
    public Factura() {
    }

    public Factura(String fecha, double total) {
        this.fecha = fecha;
        this.total = total;

    }
    
    
    
    
    
}
