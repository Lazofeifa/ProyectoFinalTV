
package com.proyectotv.service.impl;

import com.proyectotv.dao.SuscripcionDao;
import com.proyectotv.domain.Suscripcion;
import com.proyectotv.service.SuscripcionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {
    
    @Autowired
    private SuscripcionDao suscripcionDao;
    
   
    @Override
    public List<Suscripcion> getSuscripciones() {
        return suscripcionDao.findAll();
    }
    
    @Override
    public Suscripcion getSuscripcion(Suscripcion suscripcion) {
        return suscripcionDao.findById(suscripcion.getIdSuscripcion()).orElse(null);
    }
  
    @Override
    public void deleteSuscripcion(Suscripcion suscripcion) {
        suscripcionDao.delete(suscripcion);
    }

    @Override
    public void saveSuscripcion(Suscripcion suscripcion) {
        suscripcionDao.save(suscripcion);
    }
}
