
package com.proyectotv.service.impl;

import com.proyectotv.dao.TipopDao;
import com.proyectotv.domain.Tipop;
import com.proyectotv.service.TipopService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipopServiceImpl implements TipopService{
    
    @Autowired
    private TipopDao tipopDao;
    
    @Override
    public List<Tipop> getTipops() {
        return tipopDao.findAll();
    }
    
    @Override
    public Tipop getTipop(Tipop tipop) {
        return tipopDao.findById(tipop.getIdTipop()).orElse(null);
    }
    
    @Override
    public void deleteTipop(Tipop tipop) {
        tipopDao.delete(tipop);
    }
    
    @Override
    public void saveTipop(Tipop tipop) {
        tipopDao.save(tipop);
    }
    
}
