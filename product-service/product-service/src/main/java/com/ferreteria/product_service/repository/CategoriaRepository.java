package com.ferreteria.product_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ferreteria.product_service.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
