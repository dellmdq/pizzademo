package com.dellmdq.pizzademo.controllers;

import com.dellmdq.pizzademo.dtos.requests.ProductoDTO;
import com.dellmdq.pizzademo.dtos.requests.ProductoPostRequestDTO;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import com.dellmdq.pizzademo.services.impl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoServiceImpl;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductoPostRequestDTO productoPostRequestDTO){
        try{
            ProductoDTO productoDTO = productoServiceImpl.create(productoPostRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoDTO);
        }
        catch (BadRequestException exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }




}
