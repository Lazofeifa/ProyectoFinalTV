
package com.proyectotv.service;

import com.proyectotv.domain.Producto;
import java.util.List;


public interface ProductoService {
    
    public List<Producto> getProductos();
    
    public Producto getProducto(Producto producto);
    
    public void deleteProducto(Producto producto);
    
    public void saveProducto(Producto producto);
    
}
