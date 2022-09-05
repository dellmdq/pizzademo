package com.dellmdq.pizzademo.data;

import com.dellmdq.pizzademo.entities.PedidoCabecera;
import com.dellmdq.pizzademo.entities.PedidoDetalle;
import com.dellmdq.pizzademo.enums.Estado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PedidosCabeceraData {

    public static PedidoCabecera pedidoCabecera1(){
        PedidoCabecera pedido = new PedidoCabecera();
        pedido.setId(UUID.fromString("2cba3cc1-3373-475b-8833-c9eea8cb3114"));
        pedido.setDireccion("20 de Septiembre 1832");
        pedido.setEmail("juanperez@mail.com");
        pedido.setTelefono("(0223) 5443322");
        pedido.setHorario(LocalTime.of(20,30));
        pedido.setFechaAlta(LocalDate.of(2022,9,3));
        pedido.setMontoTotal(950.00D);
        pedido.setAplicoDescuento(false);
        pedido.setEstado(Estado.RECIBIDO);

        //creo detalles
        List<PedidoDetalle> detalleList = new ArrayList<>();
        detalleList.add(PedidosDetalleData.pedidoDetalle1());

        pedido.setDetalles(detalleList);
        return pedido;
    }

    public static PedidoCabecera pedidoCabecera2(){
        PedidoCabecera pedido = new PedidoCabecera();
        pedido.setId(UUID.fromString("0ae5eab0-1e29-4cb5-ae95-a600a5d35d5d"));
        pedido.setDireccion("Independencia 2211");
        pedido.setEmail("marcelopala@tyc.com");
        pedido.setTelefono("(011) 5123123");
        pedido.setHorario(LocalTime.of(21,50));
        pedido.setFechaAlta(LocalDate.of(2022,9,3));
        pedido.setMontoTotal(3080.00D);
        pedido.setAplicoDescuento(true);
        pedido.setEstado(Estado.RECIBIDO);

        //creo detalles
        List<PedidoDetalle> detalleList = new ArrayList<>();
        detalleList.add(PedidosDetalleData.pedidoDetalle1());
        detalleList.add(PedidosDetalleData.pedidoDetalle2());

        pedido.setDetalles(detalleList);
        return pedido;
    }
}
