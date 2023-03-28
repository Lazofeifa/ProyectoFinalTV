
package com.proyectotv.service.impl;

import com.proyectotv.dao.ClienteDao;
import com.proyectotv.dao.UbicacionDao;
import com.proyectotv.domain.Cliente;
import com.proyectotv.domain.Ubicacion;
import com.proyectotv.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private UbicacionDao ubicacionDao;
    
    @Override
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }
    
    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    
    @Override
    public void saveCliente(Cliente cliente) {
        Ubicacion ubicacion = cliente.getUbicacion();
        ubicacion = ubicacionDao.save(ubicacion);
        cliente.setUbicacion(ubicacion);
        clienteDao.save(cliente);
    }
}
