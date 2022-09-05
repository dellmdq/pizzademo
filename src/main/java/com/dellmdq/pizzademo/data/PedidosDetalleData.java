package com.dellmdq.pizzademo.data;

import com.dellmdq.pizzademo.entities.PedidoDetalle;

import java.util.UUID;

public class PedidosDetalleData {

    public static PedidoDetalle pedidoDetalle1() {
        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setId(UUID.fromString("0d3ff85e-7d71-4d8a-9ebf-5279f3f6fc63"));
        pedidoDetalle.setProducto(ProductosData.crearProducto1());
        pedidoDetalle.setCantidad(1);
        pedidoDetalle.setPrecioUnitario(ProductosData.crearProducto1().getPrecioUnitario());
        return pedidoDetalle;
    }

    public static PedidoDetalle pedidoDetalle2(){
        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setId(UUID.fromString("dab75edb-fae9-4a26-9025-e448201229bf"));
        pedidoDetalle.setProducto(ProductosData.crearProducto2());
        pedidoDetalle.setCantidad(3);
        pedidoDetalle.setPrecioUnitario(ProductosData.crearProducto2().getPrecioUnitario());
        return pedidoDetalle;
    }


}
