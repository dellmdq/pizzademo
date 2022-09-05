package com.dellmdq.pizzademo.services;

import com.dellmdq.pizzademo.dtos.requests.ProductoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.ProductoResponseDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import com.dellmdq.pizzademo.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductoService {

    ProductoResponseDTO create(ProductoRequestDTO productoRequestDTO) throws BadRequestException;

    List<ProductoResponseDTO> findAll();

    ProductoResponseDTO findById(UUID id) throws NotFoundException;

    void deleteById(UUID id) throws NotFoundException;

    void update(UUID id, ProductoRequestDTO productoRequestDTO) throws NotFoundException;

    Double getProductoPrecioUnitario(UUID id) throws NotFoundException;
}
