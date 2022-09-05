package com.dellmdq.pizzademo.data.response;

import com.dellmdq.pizzademo.dtos.responses.ProductoResponseDTO;

import java.util.UUID;

public class ProductosResponseDTOData {

    //response prod1
    public static ProductoResponseDTO crearProductoResponseDTO1(){
        ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO();
        productoResponseDTO.setNombre("Muzzarella");
        productoResponseDTO.setDescripcionCorta("Pizza con muzzarella y aceitunas");
        productoResponseDTO.setDescripcionLarga("");
        productoResponseDTO.setPrecioUnitario(950.00D);
        return  productoResponseDTO;
    }
}
