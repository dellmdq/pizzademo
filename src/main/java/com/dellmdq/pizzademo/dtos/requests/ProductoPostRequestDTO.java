package com.dellmdq.pizzademo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoPostRequestDTO {

    @NotBlank(message = "Ingrese un nombre válido por favor")
    private String nombre;

    @NotBlank(message = "Ingrese una descripción válida por favor")
    private String descripcionCorta;

    private String descripcionLarga;
    private Double precioUnitario;

}
