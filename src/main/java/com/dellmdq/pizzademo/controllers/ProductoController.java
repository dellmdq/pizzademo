package com.dellmdq.pizzademo.controllers;

import com.dellmdq.pizzademo.dtos.responses.ProductoResponseDTO;
import com.dellmdq.pizzademo.dtos.requests.ProductoPostRequestDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import com.dellmdq.pizzademo.services.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
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
            ProductoResponseDTO productoResponseDTO = productoService.create(productoPostRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoResponseDTO);
        }
        catch (BadRequestException exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductoResponseDTO> productos = productoService.findAll()
                .stream()
                .map(producto -> modelMapper.map(producto, ProductoResponseDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        Producto producto = productoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        productoService.deleteById(id);
    }

}
