package com.ferreteria.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<com.ferreteria.customer_service.model.Cliente, Long> {
}