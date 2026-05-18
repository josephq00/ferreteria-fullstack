package com.ferreteria.product_service.repository;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String sku;
    private Double precioVenta;
    private String categoria;
    private Long idMarca;
}