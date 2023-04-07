
package com.proyectotv.dao;

import com.proyectotv.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioDao extends JpaRepository<Comentario, Long>{
    
}
