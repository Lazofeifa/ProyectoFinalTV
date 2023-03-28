
package com.proyectotv.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="perfil")
public class Perfil implements Serializable {
     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_perfil")
    private Long idPerfil;
    
    private String usuario;
    private String correo;
    private String contrasena;
    
    @JoinColumn(name="id_cliente", referencedColumnName="id_cliente")
    @ManyToOne
    private Cliente cliente;
    
    @JoinColumn(name="id_tipop", referencedColumnName="id_tipop")
    @ManyToOne
    private Tipop tipop;

    public Perfil() {
    }

    public Perfil(String usuario, String correo, String contrasena) {
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    
    
}
