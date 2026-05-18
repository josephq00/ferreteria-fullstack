package com.ferreteria.product_service.repository;
import com.ferreteria.product_service.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

