
package com.proyectotv.service.impl;

import com.proyectotv.dao.PerfilDao;
import com.proyectotv.dao.ClienteDao;
import com.proyectotv.dao.TipopDao;
import com.proyectotv.domain.Perfil;
import com.proyectotv.domain.Cliente;
import com.proyectotv.domain.Tipop;
import com.proyectotv.service.PerfilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService{
    
    @Autowired
    private PerfilDao perfilDao;
    
    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private TipopDao tipopDao;
    
    @Override
    public List<Perfil> getPerfiles() {
        return perfilDao.findAll();
    }
    
    @Override
    public Perfil getPerfil(Perfil perfil) {
        return perfilDao.findById(perfil.getIdPerfil()).orElse(null);
    }

    @Override
    public void deletePerfil(Perfil perfil) {
        perfilDao.delete(perfil);
    }
    
    @Override
    public void savePerfil(Perfil perfil) {
        Cliente cliente = perfil.getCliente();
        cliente = clienteDao.save(cliente);
        perfil.setCliente(cliente);
        perfilDao.save(perfil);
        
        Tipop tipop = perfil.getTipop();
        tipop = tipopDao.save(tipop);
        perfil.setTipop(tipop);
        perfilDao.save(perfil);
    }
}
