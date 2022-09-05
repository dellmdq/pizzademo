package com.dellmdq.pizzademo.data.request;

import com.dellmdq.pizzademo.dtos.requests.ProductoRequestDTO;

public class ProductosRequestDTOData {

    public static ProductoRequestDTO crearProductoRequestDTO1(){
        ProductoRequestDTO productoRequestDTO = new ProductoRequestDTO();
        productoRequestDTO.setNombre("Muzzarella");
        productoRequestDTO.setDescripcionCorta("Pizza con muzzarella y aceitunas");
        productoRequestDTO.setDescripcionLarga("");
        productoRequestDTO.setPrecioUnitario(950.00D);
        return productoRequestDTO;
    }

    public static ProductoRequestDTO crearProductoRequestDTO2(){
        ProductoRequestDTO productoRequestDTO = new ProductoRequestDTO();
        productoRequestDTO.setNombre("Jamón y morrones");
        productoRequestDTO.setDescripcionCorta("Pizza de jamón y morrones");
        productoRequestDTO.setDescripcionLarga("");
        productoRequestDTO.setPrecioUnitario(1150.00D);
        return productoRequestDTO;
    }

    public static ProductoRequestDTO crearProductoRequestPutDTO1(){
        ProductoRequestDTO productoRequestDTO = new ProductoRequestDTO();
        productoRequestDTO.setNombre("Muzzarella");
        productoRequestDTO.setDescripcionCorta("Pizza con muzzarella y aceitunas");
        productoRequestDTO.setDescripcionLarga("Pizza con muzzarella, aceitunas y oregano");
        productoRequestDTO.setPrecioUnitario(1200.00D);
        return productoRequestDTO;
    }
}
