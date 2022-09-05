package com.dellmdq.pizzademo.data.response;

import com.dellmdq.pizzademo.dtos.responses.PedidoDetalleResponseDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoResponseDTO;
import com.dellmdq.pizzademo.enums.Estado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PedidosResponseDTOData {

    //response de crearCabecera1
    public static PedidoResponseDTO pedidoResponseDTO1(){
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
        pedidoResponseDTO.setFecha(LocalDate.of(2022,9,3));
        pedidoResponseDTO.setDireccion("20 de Septiembre 1832");
        pedidoResponseDTO.setEmail("juanperez@mail.com");
        pedidoResponseDTO.setTelefono("(0223) 5443322");
        pedidoResponseDTO.setHorario(LocalTime.of(20,30));
        
        List<PedidoDetalleResponseDTO> detalleResponseDTOList = new ArrayList<>();
        detalleResponseDTOList.add(PedidoDetalleResponseDTOData.crearDetalleResponseDTO1());
        pedidoResponseDTO.setDetalle(detalleResponseDTOList);

        pedidoResponseDTO.setTotal(950.00D);
        pedidoResponseDTO.setDescuento(false);
        pedidoResponseDTO.setEstado(Estado.RECIBIDO);
        return pedidoResponseDTO;
    }

    public static PedidoResponseDTO pedidoResponseDTO2() {
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
        pedidoResponseDTO.setFecha(LocalDate.of(2022,9,3));
        pedidoResponseDTO.setDireccion("Independencia 2211");
        pedidoResponseDTO.setEmail("marcelopala@tyc.com");
        pedidoResponseDTO.setTelefono("(011) 5123123");
        pedidoResponseDTO.setHorario(LocalTime.of(21,50));

        List<PedidoDetalleResponseDTO> detalleResponseDTOList = new ArrayList<>();
        detalleResponseDTOList.add(PedidoDetalleResponseDTOData.crearDetalleResponseDTO1());
        detalleResponseDTOList.add(PedidoDetalleResponseDTOData.crearDetalleResponseDTO2());
        pedidoResponseDTO.setDetalle(detalleResponseDTOList);

        pedidoResponseDTO.setTotal(3080.00D);
        pedidoResponseDTO.setDescuento(true);
        pedidoResponseDTO.setEstado(Estado.RECIBIDO);
        return pedidoResponseDTO;
    }
}
