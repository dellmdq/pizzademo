package com.dellmdq.pizzademo.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class DetalleRequestDTO {
    @NotBlank
    private UUID producto;
    @Min(value = 0, message = "Cantidad no puede ser menor a uno")
    private Integer cantidad;
}
