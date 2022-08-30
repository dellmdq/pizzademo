package com.dellmdq.pizzademo.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

public class PedidoCabecera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String direccion;
    private String email;
    private String horario;
    private String fechaAlta;
    private String montoTotal;
    private Boolean aplicoDescuento;
    private Enum estado;
    private List<PedidoDetalle> listaDetalle;


}
