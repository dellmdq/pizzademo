package com.dellmdq.pizzademo.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PedidoDetalleResponseDTO {
    private UUID producto;
    private String nombre;
    private Integer cantidad;
    private Double importe;
}
