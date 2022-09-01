package com.dellmdq.pizzademo.controllers;

import com.dellmdq.pizzademo.dtos.requests.ProductoDTO;
import com.dellmdq.pizzademo.dtos.requests.ProductoPostRequestDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import com.dellmdq.pizzademo.services.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductoPostRequestDTO productoPostRequestDTO){
        try{
            ProductoDTO productoDTO = productoService.create(productoPostRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoDTO);
        }
        catch (BadRequestException exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() throws NotFoundException {
        List<ProductoDTO> productos = productoService.findAll()
                .stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }




}
