package com.dellmdq.pizzademo.enums;

public enum Estado {
    RECIBIDO("Recibido"),
    PREPARACION("En preparación"),
    EN_CAMINO("En camino"),
    ENTREGADO("Entregado"),
    CANCELADO("Cancelado");

    private final String nombre;

    Estado(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
