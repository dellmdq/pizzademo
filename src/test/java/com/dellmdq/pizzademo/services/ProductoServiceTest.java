package com.dellmdq.pizzademo.services;

import com.dellmdq.pizzademo.data.ProductoRequestDTOData;
import com.dellmdq.pizzademo.data.ProductosData;
import com.dellmdq.pizzademo.repositories.ProductoRepository;
import com.dellmdq.pizzademo.services.impl.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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

        assertNotNull(productoService.create(ProductoRequestDTOData.crearProductoRequestDTO1()));
        assertNotNull(productoService.create(ProductoRequestDTOData.crearProductoRequestDTO1()).getId());
        assertTrue(0 < productoService.create(ProductoRequestDTOData.crearProductoRequestDTO1()).getPrecioUnitario());
        assertNotNull(productoService.create(ProductoRequestDTOData.crearProductoRequestDTO1()).getDescripcionCorta());
        assertNotNull(productoService.create(ProductoRequestDTOData.crearProductoRequestDTO1()).getDescripcionLarga());
    }

    @Test
    void findAll(){
        when(productoRepository.findAll()).thenReturn(ProductosData.crearListaProductos1());

        assertNotNull(productoService.findAll());
        assertTrue(productoService.findAll().size() > 0);
    }


}
