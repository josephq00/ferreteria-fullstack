package com.stock_service.stock.controller;

import com.stock_service.stock.model.Inventario;
import com.stock_service.stock.service.InventarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventario")
@RequiredArgsConstructor
@CrossOrigin("*")
public class InventarioController {

    private final InventarioService inventarioService;

    // Listar inventario
    @GetMapping
    public ResponseEntity<List<Inventario>> listar() {
        return ResponseEntity.ok(inventarioService.listarInventario());
    }

    // Crear inventario
    @PostMapping
    public ResponseEntity<Inventario> crear(@RequestBody Inventario inv) {
        return ResponseEntity.ok(inventarioService.crearInventario(inv));
    }

    // Obtener por producto
    @GetMapping("/{idProducto}")
    public ResponseEntity<Inventario> obtener(@PathVariable Long idProducto) {
        return ResponseEntity.ok(inventarioService.obtenerPorProducto(idProducto));
    }

    // Entrada de stock
    @PutMapping("/entrada/{idProducto}/{cantidad}")
    public ResponseEntity<Inventario> entrada(
            @PathVariable Long idProducto,
            @PathVariable Integer cantidad) {

        return ResponseEntity.ok(
                inventarioService.entradaStock(idProducto, cantidad)
        );
    }

    // Salida de stock
    @PutMapping("/salida/{idProducto}/{cantidad}")
    public ResponseEntity<Inventario> salida(
            @PathVariable Long idProducto,
            @PathVariable Integer cantidad) {

        return ResponseEntity.ok(
                inventarioService.salidaStock(idProducto, cantidad)
        );
    }
}