package com.dellmdq.pizzademo.controllers;

import com.dellmdq.pizzademo.dtos.requests.PedidoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoResponseDTO;
import com.dellmdq.pizzademo.services.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> crearPedido(@Valid @RequestBody PedidoRequestDTO pedido){
        log.info("Request Crear Producto: " + pedido);
        PedidoResponseDTO pedidoResponseDTO = pedidoService.crearPedido(pedido);
        return ResponseEntity.ok(pedidoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<?> listarPedidosPorFecha(@RequestParam(value = "fecha")
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
        log.info(String.format("Busqueda de pedidos por fecha: %s", fecha));
        List<PedidoResponseDTO> pedidos = pedidoService.listarPedidosPorFecha(fecha);
        log.info(String.format("%d pedidos obtenidos en la fecha %s",pedidos.size(), fecha));
        return ResponseEntity.ok().body(pedidos);
    }

}
