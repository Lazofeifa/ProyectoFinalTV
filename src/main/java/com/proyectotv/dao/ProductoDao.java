
package com.proyectotv.dao;

import com.proyectotv.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoDao extends JpaRepository<Producto, Long>{
    
}
