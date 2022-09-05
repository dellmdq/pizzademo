package com.dellmdq.pizzademo.data.response;

import com.dellmdq.pizzademo.dtos.responses.PedidoDetalleResponseDTO;

import java.util.UUID;

public class PedidoDetalleResponseDTOData {

    //crearCabecera1 y pedidoResponseDTO1, producto1
    public static PedidoDetalleResponseDTO crearDetalleResponseDTO1(){
        PedidoDetalleResponseDTO detalleResponseDTO = new PedidoDetalleResponseDTO();
        detalleResponseDTO.setProducto(UUID.fromString("32f5a99a-76cc-42d6-84bb-1d40cd1b9f6b"));
        detalleResponseDTO.setCantidad(1);
        detalleResponseDTO.setImporte(950.00D);
        detalleResponseDTO.setNombre("Muzzarella");
        return detalleResponseDTO;
    }

    public static PedidoDetalleResponseDTO crearDetalleResponseDTO2() {
        PedidoDetalleResponseDTO detalleResponseDTO = new PedidoDetalleResponseDTO();
        detalleResponseDTO.setProducto(UUID.fromString("94e38a1d-bf6e-4f00-9a7f-ba21495631bb"));
        detalleResponseDTO.setCantidad(3);
        detalleResponseDTO.setImporte(2800.00D);
        detalleResponseDTO.setNombre("Jamón y morrones");
        return detalleResponseDTO;
    }
}
