package com.dellmdq.pizzademo.services.impl;

import com.dellmdq.pizzademo.dtos.requests.ProductoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.ProductoResponseDTO;
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
import java.util.stream.Collectors;

@Service
@Slf4j//todo logs
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductoResponseDTO create(ProductoRequestDTO productoRequestDTO) throws BadRequestException {

        //todo manejo de excepciones
        Producto producto = modelMapper.map(productoRequestDTO, Producto.class);
        Producto productoCreated = productoRepository.save(producto);//todo validar que no exista el nombre en la bd
        ProductoResponseDTO result = modelMapper.map(productoCreated, ProductoResponseDTO.class);
        return result;
    }

    @Override
    public List<ProductoResponseDTO> findAll() {
        return productoRepository.findAll().stream()
                .map(producto -> modelMapper.map(producto, ProductoResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Producto findById(UUID id) throws NotFoundException{
        return productoRepository.findById(id).orElseThrow(() -> (new NotFoundException(String.format("Producto con UUID: %s no fue encontrado.", id))));
    }

    @Override
    public void deleteById(UUID id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void update(UUID id, ProductoRequestDTO productoRequestDTO) throws NotFoundException {

        Producto productoExistente = this.findById(id);

        //seteo todos los valores de acuerdo a la lógica del put y lo guardo en la bd
        productoExistente.setNombre(productoRequestDTO.getNombre());
        productoExistente.setDescripcionCorta(productoRequestDTO.getDescripcionCorta());
        productoExistente.setDescripcionLarga(productoRequestDTO.getDescripcionLarga());
        productoExistente.setPrecioUnitario(productoRequestDTO.getPrecioUnitario());
        Producto productoGuardado = productoRepository.save(productoExistente);
    }

    //todo optional agrear el PATCH

    @Override
    public Double getProductoPrecioUnitario(UUID id) throws NotFoundException {
        Producto producto = this.findById(id);//todo mejorar armando metodo en repo que solo me traiga el precio
        return producto.getPrecioUnitario();
    }



}
