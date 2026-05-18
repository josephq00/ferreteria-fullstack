package com.ferreteria.sales_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferreteria.sales_service.model.DetalleVenta;


public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
}