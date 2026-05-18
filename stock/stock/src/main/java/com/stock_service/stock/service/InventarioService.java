package com.stock_service.stock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.stock_service.stock.model.Inventario;
import com.stock_service.stock.model.MovimientoStock;
import com.stock_service.stock.repository.InventarioRepository;
import com.stock_service.stock.repository.MovimientoStockRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventarioService {

    private final InventarioRepository inventarioRepo;
    private final MovimientoStockRepository movimientoRepo;

    public List<Inventario> listarInventario(){
        return inventarioRepo.findAll();
    }

    public Inventario crearInventario(Inventario inv){
        return inventarioRepo.save(inv);
    }

    public Inventario obtenerPorProducto(Long idProducto){
        return inventarioRepo.findByIdProducto(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto sin inventario"));
    }

    public Inventario entradaStock(Long idProducto, Integer cantidad){
        Inventario inv = obtenerPorProducto(idProducto);
        inv.setCantidadDisponible(inv.getCantidadDisponible() + cantidad);
        inventarioRepo.save(inv);
        registrarMovimiento(idProducto,"ENTRADA",cantidad);
        return inv;
    }

    public Inventario salidaStock(Long idProducto, Integer cantidad){
        Inventario inv = obtenerPorProducto(idProducto);

        if(inv.getCantidadDisponible() < cantidad){
            throw new RuntimeException("Stock insuficiente");
        }

        inv.setCantidadDisponible(inv.getCantidadDisponible() - cantidad);
        inventarioRepo.save(inv);
        registrarMovimiento(idProducto,"SALIDA",cantidad);
        return inv;
    }

    private void registrarMovimiento(Long idProducto,String tipo,Integer cantidad){
        MovimientoStock mov = MovimientoStock.builder()
                .idProducto(idProducto)
                .tipo(tipo)
                .cantidad(cantidad)
                .fecha(LocalDateTime.now())
                .build();
        movimientoRepo.save(mov);
    }
}