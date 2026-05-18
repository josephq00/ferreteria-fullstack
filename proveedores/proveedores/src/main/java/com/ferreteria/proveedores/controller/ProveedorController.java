package com.ferreteria.proveedores.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ferreteria.proveedores.model.Proveedor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProveedorController {

    private final com.ferreteria.proveedores.service.ProveedorService service;

    @GetMapping
    public ResponseEntity<List<com.ferreteria.proveedores.model.Proveedor>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<com.ferreteria.proveedores.model.Proveedor> crear(@RequestBody com.ferreteria.proveedores.model.Proveedor p){
        return ResponseEntity.ok(service.crear(p));
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.ferreteria.proveedores.model.Proveedor> obtener(@PathVariable Long id){
        return ResponseEntity.ok(service.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.ferreteria.proveedores.model.Proveedor> actualizar(@PathVariable Long id,@RequestBody Proveedor p){
        return ResponseEntity.ok(service.actualizar(id,p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}