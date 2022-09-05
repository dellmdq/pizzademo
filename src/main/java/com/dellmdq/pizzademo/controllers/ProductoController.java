package com.dellmdq.pizzademo.controllers;

import com.dellmdq.pizzademo.dtos.requests.ProductoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.ProductoResponseDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import com.dellmdq.pizzademo.exceptions.NotFoundException;
import com.dellmdq.pizzademo.services.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Crear un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = ProductoResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Request inválido", content = @Content)
    })
    @PostMapping
    public ResponseEntity<?> crearProducto(@Valid @RequestBody ProductoRequestDTO productoRequestDTO){
        try{
            log.info("Request creación de producto: \n" + productoRequestDTO);
            ProductoResponseDTO productoDTO = productoService.create(productoRequestDTO);
            log.info("Producto creado");
            return ResponseEntity.status(HttpStatus.CREATED).body(productoDTO);
        }
        catch (BadRequestException exc){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

    @Operation(summary = "Listar todos los productos")
    @GetMapping
    public ResponseEntity<?> listarProductos() {
        log.info("Lista de todos los productos");
        List<ProductoResponseDTO> productos = productoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    @Operation(summary = "Obtener producto por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable UUID id) {
        try {
            log.info(String.format("Busqueda de producto id: %s", id));
            ProductoResponseDTO response = productoService.findById(id);
            log.info(String.format("Producto encontrado: %s\n", response));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (NotFoundException nfe){
            log.error(String.format("No ha sido encontrado producto con id: %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nfe.getMessage());
        }
    }

    @Operation(summary = "Borrar producto por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPorId(@PathVariable UUID id){
        try {
            productoService.deleteById(id);
            log.info(String.format("Producto con id %s ha sido borrado", id));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (EmptyResultDataAccessException notFound){
            log.error(String.format("No ha sido encontrado producto con id: %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Modificar producto por id")
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPorId(@PathVariable UUID id, @RequestBody ProductoRequestDTO requestDTO){
        try {
            productoService.update(id, requestDTO);
            log.info(String.format("Producto con id %s ha sido modificado", id));
        }catch (NotFoundException nfe){
            log.error(String.format("No ha sido encontrado producto con id: %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nfe.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
