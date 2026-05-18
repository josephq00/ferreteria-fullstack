package com.ferreteria.product_service.service;

import com.ferreteria.product_service.dto.ProductoRequestDTO;
import com.ferreteria.product_service.model.Categoria;
import com.ferreteria.product_service.model.Producto;
import com.ferreteria.product_service.repository.CategoriaRepository;
import com.ferreteria.product_service.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    // 🔹 LISTAR
    public List<com.ferreteria.product_service.repository.ProductoResponseDTO> listarProductos(){
        log.info("Listando productos del catálogo");
        return productoRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    // 🔹 OBTENER POR ID
    public com.ferreteria.product_service.repository.ProductoResponseDTO obtenerProducto(Long id){
        log.info("Buscando producto con ID {}", id);

        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        return convertirDTO(p);
    }

    // 🔹 CREAR
    public com.ferreteria.product_service.repository.ProductoResponseDTO crearProducto(ProductoRequestDTO dto){

        log.info("Creando producto {}", dto.getNombre());

        if(dto.getPrecioVenta() <= 0){
            throw new RuntimeException("El precio debe ser mayor a 0");
        }

        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoria no existe"));

        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setSku(dto.getSku());
        p.setPrecioVenta(dto.getPrecioVenta());
        p.setCategoria(categoria);
        p.setIdMarca(dto.getIdMarca());

        productoRepository.save(p);

        log.info("Producto creado correctamente: {}", p.getNombre());
        return convertirDTO(p);
    }

    // 🔹 ACTUALIZAR
    public com.ferreteria.product_service.repository.ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO dto){

        log.info("Actualizando producto ID {}", id);

        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if(dto.getPrecioVenta() <= 0){
            throw new RuntimeException("El precio debe ser mayor a 0");
        }

        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setSku(dto.getSku());
        p.setPrecioVenta(dto.getPrecioVenta());

        productoRepository.save(p);

        log.info("Producto actualizado correctamente");
        return convertirDTO(p);
    }

    // 🔹 ELIMINAR
    public void eliminarProducto(Long id){
        log.warn("Eliminando producto ID {}", id);

        if(!productoRepository.existsById(id)){
            throw new RuntimeException("Producto no existe");
        }

        productoRepository.deleteById(id);
    }

    // 🔹 CONVERTIR ENTITY → DTO
    private com.ferreteria.product_service.repository.ProductoResponseDTO convertirDTO(Producto p){
        return com.ferreteria.product_service.repository.ProductoResponseDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .descripcion(p.getDescripcion())
                .sku(p.getSku())
                .precioVenta(p.getPrecioVenta())
                .categoria(p.getCategoria().getNombreCategoria())
                .idMarca(p.getIdMarca())
                .build();
    }
}