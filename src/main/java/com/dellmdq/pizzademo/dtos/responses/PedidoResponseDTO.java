package com.dellmdq.pizzademo.dtos.responses;

import com.dellmdq.pizzademo.enums.Estado;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString
public class PedidoResponseDTO {

    private LocalDate fecha;
    private String direccion;
    private String email;
    private String telefono;
    private LocalTime horario;
    List<PedidoDetalleResponseDTO> detalle;
    private Double total;
    private Boolean descuento;
    private Estado estado;

}
