package com.ferreteria.product_service.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String sku;

    @Column(name="precio_venta")
    private Double precioVenta;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    @Column(name="id_marca")
    private Long idMarca;
}
