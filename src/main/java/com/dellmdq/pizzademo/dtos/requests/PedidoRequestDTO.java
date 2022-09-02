package com.dellmdq.pizzademo.dtos.requests;

import com.dellmdq.pizzademo.enums.Estado;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class PedidoRequestDTO {

    private String direccion;
    private String email;
    //todo buscar regexp para telefonos de argentina
    private String telefono;
    private LocalTime horario;
    private List<DetalleRequestDTO> detalle;

}
