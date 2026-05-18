package com.ferreteria.proveedores.service;

import com.ferreteria.proveedores.model.Proveedor;
import com.ferreteria.proveedores.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProveedorService {

    private final ProveedorRepository repo;

    public List<Proveedor> listar() {
        return repo.findAll();
    }

    public Proveedor crear(Proveedor p) {
        log.info("Proveedor creado {}", p.getRazonSocial());
        return repo.save(p);
    }

    public Proveedor obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no existe"));
    }

    public Proveedor actualizar(Long id, Proveedor nuevo) {
        Proveedor p = obtener(id);
        p.setRutEmpresa(nuevo.getRutEmpresa());
        p.setRazonSocial(nuevo.getRazonSocial());
        p.setContactoVendedor(nuevo.getContactoVendedor());
        p.setCategoriaInsumos(nuevo.getCategoriaInsumos());
        return repo.save(p);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}