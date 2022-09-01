package com.dellmdq.pizzademo.controllers;

import com.dellmdq.pizzademo.dtos.requests.PedidoRequestDTO;
import com.dellmdq.pizzademo.entities.PedidoCabecera;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@RequestMapping("/pedidos")
public class PedidoController {
//todo hacer service. recordar aplicar descuento en la logica si lleva más de tres productos
//    @PostMapping
//    public ResponseEntity<?> create(@Valid @RequestBody PedidoRequestDTO pedido){
//        PedidoCabecera pedidoCabecera = pedidoService.save(pedido);
//        return ResponseEntity.ok(pedidoCabecera);
//    }

}
