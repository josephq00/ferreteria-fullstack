package com.ferreteria.sales_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ferreteria.sales_service.model.Venta;
import com.ferreteria.sales_service.service.VentaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VentaController {

    private final VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> listar(){
        return ResponseEntity.ok(ventaService.listarVentas());
    }

    @PostMapping
    public ResponseEntity<Venta> crear(@RequestBody Venta venta){
        return ResponseEntity.ok(ventaService.crearVenta(venta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtener(@PathVariable Long id){
        return ResponseEntity.ok(ventaService.obtenerVenta(id));
    }
}