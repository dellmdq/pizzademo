package com.dellmdq.pizzademo.data;

import com.dellmdq.pizzademo.entities.PedidoCabecera;
import com.dellmdq.pizzademo.entities.PedidoDetalle;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.enums.Estado;
import com.dellmdq.pizzademo.utils.PedidoUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PedidosData {

    private static PedidoUtils pedidoUtils = new PedidoUtils();

    public static PedidoDetalle crearDetalle1(){
        Producto prod1 = ProductosData.crearProducto1();

        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setCantidad(1);
        pedidoDetalle.setProducto(prod1);
        pedidoDetalle.setId(prod1.getId());
        pedidoDetalle.setPrecioUnitario(prod1.getPrecioUnitario());
        return pedidoDetalle;
    }

    public static PedidoDetalle crearDetalle2(){
        Producto prod3 = ProductosData.crearProducto3();

        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setCantidad(2);
        pedidoDetalle.setProducto(prod3);
        pedidoDetalle.setId(prod3.getId());
        pedidoDetalle.setPrecioUnitario(prod3.getPrecioUnitario());
        return pedidoDetalle;
    }

    public static PedidoDetalle crearDetalle3(){
        Producto prod2 = ProductosData.crearProducto2();

        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setCantidad(1);
        pedidoDetalle.setProducto(prod2);
        pedidoDetalle.setId(prod2.getId());
        pedidoDetalle.setPrecioUnitario(prod2.getPrecioUnitario());
        return pedidoDetalle;
    }

    public static PedidoCabecera crearCabecera1(){
        PedidoCabecera cabecera = new PedidoCabecera();
        cabecera.setId(UUID.randomUUID());
        cabecera.setDireccion("20 de Septiembre 1832");
        cabecera.setEmail("juanperez@mail.com");
        cabecera.setTelefono("(0223) 5443322");
        cabecera.setHorario(LocalTime.of(20,30));
        cabecera.setFechaAlta(LocalDate.of(2022,7,22));
        cabecera.setEstado(Estado.RECIBIDO);

        List<PedidoDetalle> detalles = new ArrayList<>();
        detalles.add(crearDetalle1());
        cabecera.setDetalles(detalles);
        cabecera.setAplicoDescuento(pedidoUtils.descuentoTresArticulosAplicable(cabecera.getDetalles()));
        cabecera.setMontoTotal(pedidoUtils.calcularMontoTotal(detalles));

        return cabecera;
    }

    public static PedidoCabecera crearCabecera2(){
        PedidoCabecera cabecera = new PedidoCabecera();
        cabecera.setId(UUID.randomUUID());
        cabecera.setDireccion("Independencia 2211");
        cabecera.setEmail("marcelopala@tyc.com");
        cabecera.setTelefono("(011) 5123123");
        cabecera.setHorario(LocalTime.of(21,50));
        cabecera.setFechaAlta(LocalDate.of(2022,7,22));
        cabecera.setEstado(Estado.RECIBIDO);

        List<PedidoDetalle> detalles = new ArrayList<>();
        detalles.add(crearDetalle1());
        detalles.add(crearDetalle2());
        detalles.add(crearDetalle3());
        cabecera.setDetalles(detalles);
        cabecera.setAplicoDescuento(pedidoUtils.descuentoTresArticulosAplicable(cabecera.getDetalles()));
        cabecera.setMontoTotal(pedidoUtils.calcularMontoTotal(detalles));

        return cabecera;
    }
}
