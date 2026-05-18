package com.ferreteria.sales_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ferreteria.sales_service.model.Venta;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final com.ferreteria.sales_service.repository.VentaRepository ventaRepository;

    public List<Venta> listarVentas(){
        return ventaRepository.findAll();
    }

    public Venta crearVenta(Venta venta){
        venta.setFecha(LocalDateTime.now());
        venta.setEstadoPago("PENDIENTE");

        venta.getDetalles().forEach(d -> d.setVenta(venta));

        return ventaRepository.save(venta);
    }

    public Venta obtenerVenta(Long id){
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }
}