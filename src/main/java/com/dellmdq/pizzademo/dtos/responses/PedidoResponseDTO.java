package com.dellmdq.pizzademo.dtos.responses;

import com.dellmdq.pizzademo.enums.Estado;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PedidoResponseDTO {

    private UUID id;
    private LocalDate fecha;
    private String direccion;
    private String email;
    private String telefono;
    private LocalTime horario;
    List<PedidoDetalleResponseDTO> detalles;
    private Double total;
    private Boolean descuento;
    private Estado estado;

}
