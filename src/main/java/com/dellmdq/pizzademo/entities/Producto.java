package com.dellmdq.pizzademo.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nombre;
    private String descripcionCorta;
    private String descripcionLarga;
    private Double precioUnitario;
}
