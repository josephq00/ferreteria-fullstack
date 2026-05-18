package com.ferreteria.product_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ferreteria.product_service.dto.ProductoRequestDTO;
import com.ferreteria.product_service.repository.ProductoResponseDTO;
import com.ferreteria.product_service.service.ProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/productos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProductoControlador {

    private final ProductoService productoService;

    // 🔹 1. LISTAR PRODUCTOS
    @GetMapping
    public ResponseEntity<List<com.ferreteria.product_service.repository.ProductoResponseDTO>> listaProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    // 🔹 2. CREAR PRODUCTO
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> agregaProducto(@RequestBody ProductoRequestDTO dto) {
        return ResponseEntity.ok(productoService.crearProducto(dto));
    }

    // 🔹 3. BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerProducto(id));
    }

    // 🔹 4. ACTUALIZAR PRODUCTO
    @PutMapping("/{id}")
    public ResponseEntity<com.ferreteria.product_service.repository.ProductoResponseDTO> actualizarProducto(
            @PathVariable Long id,
            @RequestBody ProductoRequestDTO dto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, dto));
    }

    // 🔹 5. ELIMINAR PRODUCTO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}