package com.dellmdq.pizzademo.data.request;

import com.dellmdq.pizzademo.data.request.DetallesRequestDTOData;
import com.dellmdq.pizzademo.dtos.requests.DetalleRequestDTO;
import com.dellmdq.pizzademo.dtos.requests.PedidoRequestDTO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PedidosRequestDTOData {

    public static PedidoRequestDTO crearPedidoRequestDTO1(){
        PedidoRequestDTO pedidoRequestDTO = new PedidoRequestDTO();
        pedidoRequestDTO.setDireccion("20 de Septiembre 1832");
        pedidoRequestDTO.setEmail("juanperez@mail.com");
        pedidoRequestDTO.setTelefono("(0223) 5443322");
        pedidoRequestDTO.setHorario(LocalTime.of(20,30));

        List<DetalleRequestDTO> detalles = new ArrayList<>();
        detalles.add(DetallesRequestDTOData.crearDetalleRequestDTO1());
        detalles.add(DetallesRequestDTOData.crearDetalleRequestDTO2());
        pedidoRequestDTO.setDetalle(detalles);

        return pedidoRequestDTO;
    }

    public static PedidoRequestDTO crearPedidoRequestDTO2() {
        PedidoRequestDTO pedidoRequestDTO = new PedidoRequestDTO();
        pedidoRequestDTO.setDireccion("Independencia 2211");
        pedidoRequestDTO.setEmail("marcelopala@tyc.com");
        pedidoRequestDTO.setTelefono("(011) 5123123");
        pedidoRequestDTO.setHorario(LocalTime.of(21,50));

        List<DetalleRequestDTO> detalles = new ArrayList<>();
        detalles.add(DetallesRequestDTOData.crearDetalleRequestDTO1());
        detalles.add(DetallesRequestDTOData.crearDetalleRequestDTO2());
        pedidoRequestDTO.setDetalle(detalles);

        return pedidoRequestDTO;
    }
}
