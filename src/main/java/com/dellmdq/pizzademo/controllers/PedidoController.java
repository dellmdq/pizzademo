package com.dellmdq.pizzademo.controllers;

import com.dellmdq.pizzademo.dtos.requests.PedidoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoResponseDTO;
import com.dellmdq.pizzademo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PedidoRequestDTO pedido){
        PedidoResponseDTO pedidoResponseDTO = pedidoService.create(pedido);
        return ResponseEntity.ok(pedidoResponseDTO);
    }

    //todo listar pedidos por fecha

}
