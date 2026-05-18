package com.ferreteria.customer_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rutDni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
}