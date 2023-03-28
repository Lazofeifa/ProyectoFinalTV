
package com.proyectotv.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="tipop")
public class Tipop implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipop")
    private Long idTipop;
    private String tipoperfil;

    public Tipop() {
    }

    public Tipop(String tipoperfil) {
        this.tipoperfil = tipoperfil;
    }
}
