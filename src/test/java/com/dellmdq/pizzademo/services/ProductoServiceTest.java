package com.dellmdq.pizzademo.services;

import com.dellmdq.pizzademo.data.request.ProductosRequestDTOData;
import com.dellmdq.pizzademo.data.ProductosData;
import com.dellmdq.pizzademo.dtos.responses.ProductoResponseDTO;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.exceptions.NotFoundException;
import com.dellmdq.pizzademo.repositories.ProductoRepository;
import com.dellmdq.pizzademo.services.impl.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Test
    void create(){
        when(productoRepository.save(any())).thenReturn(ProductosData.crearProducto1());

        ProductoResponseDTO productoResponseDTO = productoService.create(ProductosRequestDTOData.crearProductoRequestDTO1());

        assertNotNull(productoResponseDTO);
        assertNotNull(productoResponseDTO.getId());
        assertTrue(0 < productoResponseDTO.getPrecioUnitario());
        assertNotNull(productoResponseDTO.getNombre());
        assertNotNull(productoResponseDTO.getDescripcionCorta());
        assertNotNull(productoResponseDTO.getDescripcionLarga());

        verify(productoRepository, times(1)).save(any());
    }

    @Test
    void findAll(){
        when(productoRepository.findAll()).thenReturn(ProductosData.crearListaProductos1());

        assertNotNull(productoService.findAll());
        assertTrue(productoService.findAll().size() > 0);

        verify(productoRepository,times(2)).findAll();
    }

    @Test
    void findById(){
        when(productoRepository.findById(any())).thenReturn(Optional.of(ProductosData.crearProducto1()));

        assertNotNull(productoService.findById(any()));
        assertNotNull(productoService.findById(any()).getId());
        assertTrue(productoService.findById(any()).getPrecioUnitario() > 0);
        assertNotNull(productoService.findById(any()).getNombre());
        assertNotNull(productoService.findById(any()).getDescripcionCorta());
        assertNotNull(productoService.findById(any()).getDescripcionLarga());

        verify(productoRepository, times(6)).findById(any());
    }

    @Test
    void findByIdNotFound(){
        UUID id = UUID.fromString("7f000101-8300-1317-8183-0014a6a60001");
        when(productoRepository.findById(id)).thenThrow(new NotFoundException(String.format("Producto con UUID: %s no fue encontrado.", id)));

        assertThrows(NotFoundException.class, () -> productoRepository.findById(id));

        verify(productoRepository, times(1)).findById(any());
    }

    @Test
    void deleteById(){
        UUID id = UUID.fromString("7f000101-8300-1317-8183-0014a6a60001");
        doNothing().when(productoRepository).deleteById(id);

        productoService.deleteById(id);

        verify(productoRepository, times(1)).deleteById(id);
    }

    @Test
    void update(){
        Producto prod = ProductosData.crearProducto1();
        when(productoRepository.findById(prod.getId())).thenReturn(Optional.of(prod));
        when(productoRepository.save(prod)).thenReturn(prod);

        productoService.update(prod.getId(), ProductosRequestDTOData.crearProductoRequestPutDTO1());

        verify(productoRepository, times(1)).findById(prod.getId());
        verify(productoRepository, times(1)).save(prod);

    }

    @Test
    void getProductoPrecioUnitario(){
        when(productoRepository.findById(ProductosData.crearProducto1().getId())).thenReturn(Optional.of(ProductosData.crearProducto1()));

        assertNotNull(productoService.getProductoPrecioUnitario(ProductosData.crearProducto1().getId()));

        verify(productoRepository, times(1)).findById(ProductosData.crearProducto1().getId());
    }
}
