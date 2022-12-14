package com.dellmdq.pizzademo.services;

import com.dellmdq.pizzademo.dtos.requests.PedidoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoResponseDTO;
import com.dellmdq.pizzademo.exceptions.BadRequestException;

import java.time.LocalDate;
import java.util.List;

public interface PedidoService {

    PedidoResponseDTO crearPedido(PedidoRequestDTO pedido) throws BadRequestException;

    List<PedidoResponseDTO> listarPedidosPorFecha(LocalDate date);

}
