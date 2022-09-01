package com.dellmdq.pizzademo.services;

import com.dellmdq.pizzademo.dtos.responses.ProductoResponseDTO;
import com.dellmdq.pizzademo.dtos.requests.ProductoPostRequestDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.BadRequestException;

import java.util.List;
import java.util.UUID;

public interface ProductoService {

    ProductoResponseDTO create(ProductoPostRequestDTO productoPostRequestDTO) throws BadRequestException;

    List<Producto> findAll();

    Producto findById(UUID id);

    void deleteById(UUID id);
}
