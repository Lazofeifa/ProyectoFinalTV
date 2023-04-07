
package com.proyectotv.service.impl;

import com.proyectotv.dao.ProductoDao;
import com.proyectotv.domain.Producto;
import com.proyectotv.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public List<Producto> getProductos() {
        return productoDao.findAll();
    }
    
    @Override
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    
    @Override
    public void deleteProducto(Producto producto) {
        productoDao.delete(producto);
    }
    
    @Override
    public void saveProducto(Producto producto) {
        productoDao.save(producto);
    }
}
