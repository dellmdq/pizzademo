package com.dellmdq.pizzademo.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductoResponseDTO {

    private UUID id;
    private String nombre;
    private String descripcionCorta;
    private String descripcionLarga;
    private Double precioUnitario;
}
