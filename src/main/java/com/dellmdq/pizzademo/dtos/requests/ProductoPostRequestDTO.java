package com.dellmdq.pizzademo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoPostRequestDTO {

    @NotBlank(message = "Ingrese un nombre válido por favor")
    private String nombre;

    @NotBlank(message = "Ingrese una descripción válida por favor")
    private String descripcionCorta;

    @NotBlank(message = "Ingrese una descripción válida por favor")
    @Max(value = 255, message = "Ha superado la cantidad máxima de 255 caracteres para la descripción")
    private String descripcionLarga;

    @Min(value = 1, message = "Ingrese un precio unitario válido por favor.")
    private Double precioUnitario;

}
