package com.dellmdq.pizzademo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequestDTO {

    @NotBlank(message = "Ingrese un nombre válido por favor")
    private String nombre;

    @NotBlank(message = "Ingrese una descripción válida por favor")
    private String descripcionCorta;

    @NotNull
    private String descripcionLarga;

    @Min(value = 1, message = "Ingrese un precio unitario válido por favor.")
    private Double precioUnitario;

}
