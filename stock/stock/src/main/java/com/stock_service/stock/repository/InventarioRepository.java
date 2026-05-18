package com.stock_service.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stock_service.stock.model.Inventario;
import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    
    // Este método es obligatorio para que funcione la línea 29 de tu servicio:
    Optional<Inventario> findByIdProducto(Long idProducto);
}