package com.stock_service.stock.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ID que viene del microservicio PRODUCTOS
    @Column(unique = true)
    private Long idProducto;

    private Integer cantidadDisponible;
}