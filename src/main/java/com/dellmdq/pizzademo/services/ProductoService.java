package com.dellmdq.pizzademo.services;

import com.dellmdq.pizzademo.dtos.requests.ProductoDTO;
import com.dellmdq.pizzademo.dtos.requests.ProductoPostRequestDTO;
import com.dellmdq.pizzademo.exceptions.BadRequestException;

public interface ProductoService {

    ProductoDTO create(ProductoPostRequestDTO productoPostRequestDTO) throws BadRequestException;
}
