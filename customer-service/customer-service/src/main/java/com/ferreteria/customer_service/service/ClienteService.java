package com.ferreteria.customer_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ferreteria.customer_service.model.Cliente;
import com.ferreteria.customer_service.repository.ClienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // listar
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    // crear
    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    // buscar por id
    public Cliente obtenerCliente(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    // actualizar
    public Cliente actualizarCliente(Long id, Cliente cliente){
        Cliente c = obtenerCliente(id);
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setEmail(cliente.getEmail());
        c.setTelefono(cliente.getTelefono());
        c.setDireccion(cliente.getDireccion());
        c.setRutDni(cliente.getRutDni());
        return clienteRepository.save(c);
    }

    // eliminar
    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }
}