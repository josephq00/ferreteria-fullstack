package com.ferreteria.sales_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="detalle_ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idProducto;
    private Integer cantidad;
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name="id_venta")
    private Venta venta;
}