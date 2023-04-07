
package com.proyectotv.service.impl;

import com.proyectotv.dao.UbicacionDao;
import com.proyectotv.domain.Ubicacion;
import com.proyectotv.service.UbicacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbicacionServiceImpl implements UbicacionService{
    
    @Autowired
    private UbicacionDao ubicacionDao;
    
    @Override
    public List<Ubicacion> getUbicaciones() {
        return ubicacionDao.findAll();
    }
    
    @Override
    public Ubicacion getUbicacion(Ubicacion ubicacion) {
        return ubicacionDao.findById(ubicacion.getIdUbicacion()).orElse(null);
    }
    
    @Override
    public void deleteUbicacion(Ubicacion ubicacion) {
        ubicacionDao.delete(ubicacion);
    }
    
    @Override
    public void saveUbicacion(Ubicacion ubicacion) {
        ubicacionDao.save(ubicacion);
    }
}
