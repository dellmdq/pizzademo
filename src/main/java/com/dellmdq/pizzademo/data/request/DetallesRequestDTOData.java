package com.dellmdq.pizzademo.data.request;

import com.dellmdq.pizzademo.dtos.requests.DetalleRequestDTO;

import java.util.UUID;

public class DetallesRequestDTOData {

    public static DetalleRequestDTO crearDetalleRequestDTO1(){
        DetalleRequestDTO detalleRequestDTO = new DetalleRequestDTO();
        detalleRequestDTO.setProducto(UUID.fromString("32f5a99a-76cc-42d6-84bb-1d40cd1b9f6b"));
        detalleRequestDTO.setCantidad(1);
        return detalleRequestDTO;
    }

    public static DetalleRequestDTO crearDetalleRequestDTO2(){
        DetalleRequestDTO detalleRequestDTO = new DetalleRequestDTO();
        detalleRequestDTO.setProducto(UUID.fromString("94e38a1d-bf6e-4f00-9a7f-ba21495631bb"));
        detalleRequestDTO.setCantidad(3);
        return detalleRequestDTO;
    }

    public static DetalleRequestDTO crearDetalleRequestDTO3(){
        DetalleRequestDTO detalleRequestDTO = new DetalleRequestDTO();
        detalleRequestDTO.setProducto(UUID.fromString("d89c4e27-b7d2-430c-81d1-9b380e46a4f3"));
        detalleRequestDTO.setCantidad(2);
        return detalleRequestDTO;
    }



}
