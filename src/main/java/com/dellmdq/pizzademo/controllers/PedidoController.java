package com.dellmdq.pizzademo.controllers;

import com.dellmdq.pizzademo.dtos.requests.PedidoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoResponseDTO;
import com.dellmdq.pizzademo.services.PedidoService;
import com.dellmdq.pizzademo.utils.PedidoUtils;
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

@RestController()
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoUtils pedidoUtils;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PedidoRequestDTO pedido){
        PedidoResponseDTO pedidoResponseDTO = pedidoService.create(pedido);
        return ResponseEntity.ok(pedidoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<?> listarPedidosPorFecha(@RequestParam(value = "fecha")
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
        List<PedidoResponseDTO> pedidos = pedidoService.listarPedidosPorFecha(fecha);
        return ResponseEntity.ok().body(pedidos);
    }

}
