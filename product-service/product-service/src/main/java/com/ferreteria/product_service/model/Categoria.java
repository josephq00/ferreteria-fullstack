package com.ferreteria.product_service.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="categorias")
@Data
public class Categoria {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre_categoria")
    private String nombreCategoria;

    @Column(name="pasillo_ubicacion")
    private String pasilloUbicacion;

}
