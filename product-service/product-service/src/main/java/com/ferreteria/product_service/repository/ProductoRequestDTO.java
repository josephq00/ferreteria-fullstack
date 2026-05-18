package com.ferreteria.product_service.repository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductoRequestDTO {

    @NotBlank
    private String nombre;

    private String descripcion;

    @NotBlank
    private String sku;

    @Positive
    private Double precioVenta;

    private Long idCategoria;
    private Long idMarca;
}