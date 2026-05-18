package com.ferreteria.customer_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ferreteria.customer_service.model.Cliente;
import com.ferreteria.customer_service.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtener(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.obtenerCliente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.ferreteria.customer_service.model.Cliente> actualizar(@PathVariable Long id,@RequestBody com.ferreteria.customer_service.model.Cliente cliente){
        return ResponseEntity.ok(clienteService.actualizarCliente(id,cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}