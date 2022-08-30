package com.dellmdq.pizzademo.entities;

import javax.persistence.Id;
import java.util.UUID;

public class PedidoDetalle {

    @Id
    private UUID id;
    //anotacion para evitar loop infinito con el atributo
    private PedidoCabecera pedidoCabecera;
    private Producto producto;
    private Integer cantidad;
    private Double precioUnitario;
}
