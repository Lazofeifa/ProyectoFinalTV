package com.proyectotv.service;

import com.proyectotv.domain.Cliente;
import java.util.List;

public interface ClienteService {
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void deleteCliente(Cliente cliente);
    
    public void saveCliente(Cliente cliente);
}
