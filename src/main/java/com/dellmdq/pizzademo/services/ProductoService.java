package com.dellmdq.pizzademo.services;

import com.dellmdq.pizzademo.dtos.requests.ProductoDTO;
import com.dellmdq.pizzademo.dtos.requests.ProductoPostRequestDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import java.util.List;

public interface ProductoService {

    ProductoDTO create(ProductoPostRequestDTO productoPostRequestDTO) throws BadRequestException;

    List<Producto> findAll() throws NotFoundException;
}
