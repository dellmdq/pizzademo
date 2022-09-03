package com.dellmdq.pizzademo.controllers;

import com.dellmdq.pizzademo.dtos.requests.ProductoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.ProductoResponseDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import com.dellmdq.pizzademo.exceptions.NotFoundException;
import com.dellmdq.pizzademo.services.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductoRequestDTO productoRequestDTO){//todo caso en que ya existe el producto por nombre exceptcion DataAlreadyExistException
        try{
            ProductoResponseDTO productoDTO = productoService.create(productoRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoDTO);
        }
        catch (BadRequestException exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductoResponseDTO> productos = productoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try {
            Producto producto = productoService.findById(id);
            ProductoResponseDTO response = modelMapper.map(producto, ProductoResponseDTO.class);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (NotFoundException nfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nfe.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        productoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody ProductoRequestDTO requestDTO){
        try {
            productoService.update(id, requestDTO);
        }catch (NotFoundException nfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nfe.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
