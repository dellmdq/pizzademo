package com.dellmdq.pizzademo.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductoDTO {

    private UUID id;
    private String nombre;
    private String descripcionCorta;
    private String descripcionLarga;
    private Double precioUnitario;
}
