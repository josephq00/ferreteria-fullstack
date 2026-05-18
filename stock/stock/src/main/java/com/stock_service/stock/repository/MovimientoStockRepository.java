package com.stock_service.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stock_service.stock.model.MovimientoStock;

public interface MovimientoStockRepository extends JpaRepository<MovimientoStock, Long> {
}