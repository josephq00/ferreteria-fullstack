package com.ferreteria.proveedores.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rutEmpresa;
    private String razonSocial;
    private String contactoVendedor;
    private String categoriaInsumos;
}