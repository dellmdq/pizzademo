package com.dellmdq.pizzademo.services.impl;

import com.dellmdq.pizzademo.dtos.requests.ProductoDTO;
import com.dellmdq.pizzademo.dtos.requests.ProductoPostRequestDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import com.dellmdq.pizzademo.repositories.ProductoRepository;
import com.dellmdq.pizzademo.services.ProductoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductoDTO create(ProductoPostRequestDTO productoPostRequestDTO) throws BadRequestException {

        //todo manejo de excepciones
        //mapeo el dto al producto (entity) para poder guardarlo en bd
        Producto producto = modelMapper.map(productoPostRequestDTO, Producto.class);
        Producto productoCreated = productoRepository.save(producto);
        ProductoDTO result = modelMapper.map(productoCreated, ProductoDTO.class);
        return result;
    }
}
