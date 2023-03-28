
package com.proyectotv.service.impl;

import com.proyectotv.dao.FacturaDao;
import com.proyectotv.dao.ProductoDao;
import com.proyectotv.dao.PerfilDao;
import com.proyectotv.dao.SuscripcionDao;
import com.proyectotv.domain.Factura;
import com.proyectotv.domain.Producto;
import com.proyectotv.domain.Perfil;
import com.proyectotv.domain.Suscripcion;
import com.proyectotv.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacturaServiceImpl implements FacturaService{
    
    @Autowired
    private FacturaDao facturaDao;
    
    @Autowired
    private ProductoDao productoDao;
    
    @Autowired
    private PerfilDao perfilDao;
    
    @Autowired
    private SuscripcionDao suscripcionDao;
    
    @Override
    public List<Factura> getFacturas() {
        return facturaDao.findAll();
    }
    
    @Override
    public Factura getFactura(Factura factura) {
        return facturaDao.findById(factura.getIdFactura()).orElse(null);
    }
    
    @Override
    public void deleteFactura(Factura factura) {
        facturaDao.delete(factura);
    }
    
    @Override
    public void saveFactura(Factura factura) {
        Producto producto = factura.getProducto();
        producto = productoDao.save(producto);
        factura.setProducto(producto);
        facturaDao.save(factura);
        
        Perfil perfil = factura.getPerfil();
        perfil = perfilDao.save(perfil);
        factura.setPerfil(perfil);
        facturaDao.save(factura);
        
        Suscripcion suscripcion = factura.getSuscripcion();
        suscripcion = suscripcionDao.save(suscripcion);
        factura.setSuscripcion(suscripcion);
        facturaDao.save(factura);
    }
    
}
