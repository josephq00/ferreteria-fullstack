package com.ferreteria.sales_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferreteria.sales_service.model.Venta;


public interface VentaRepository extends JpaRepository<Venta, Long> {
}