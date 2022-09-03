package com.dellmdq.pizzademo.services;

import com.dellmdq.pizzademo.dtos.requests.PedidoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoResponseDTO;
import com.dellmdq.pizzademo.exceptions.BadRequestException;

public interface PedidoService {

    PedidoResponseDTO create(PedidoRequestDTO pedido) throws BadRequestException;


}
