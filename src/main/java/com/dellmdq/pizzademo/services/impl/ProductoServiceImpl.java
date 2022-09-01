package com.dellmdq.pizzademo.services.impl;

import com.dellmdq.pizzademo.dtos.responses.ProductoResponseDTO;
import com.dellmdq.pizzademo.dtos.requests.ProductoPostRequestDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import com.dellmdq.pizzademo.exceptions.NotFoundException;
import com.dellmdq.pizzademo.repositories.ProductoRepository;
import com.dellmdq.pizzademo.services.ProductoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductoResponseDTO create(ProductoPostRequestDTO productoPostRequestDTO) throws BadRequestException {

        //todo manejo de excepciones
        //mapeo el dto al producto (entity) para poder guardarlo en bd
        Producto producto = modelMapper.map(productoPostRequestDTO, Producto.class);
        Producto productoCreated = productoRepository.save(producto);
        ProductoResponseDTO result = modelMapper.map(productoCreated, ProductoResponseDTO.class);
        return result;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(UUID id) {
        return productoRepository.findById(id).orElseThrow(() -> (new NotFoundException(String.format("Producto con UUID: %s no fue encontrado.", id))));
    }

    @Override
    public void deleteById(UUID id) {
        productoRepository.deleteById(id);
    }


}
