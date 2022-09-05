package com.dellmdq.pizzademo.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class ProductoResponseDTO {

    private UUID id;
    private String nombre;
    private String descripcionCorta;
    private String descripcionLarga;
    private Double precioUnitario;
}
