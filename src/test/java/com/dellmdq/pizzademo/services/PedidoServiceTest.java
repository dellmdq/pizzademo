package com.dellmdq.pizzademo.services;

import com.dellmdq.pizzademo.data.PedidosCabeceraData;
import com.dellmdq.pizzademo.data.PedidosDetalleData;
import com.dellmdq.pizzademo.data.request.PedidosRequestDTOData;
import com.dellmdq.pizzademo.data.response.PedidosResponseDTOData;
import com.dellmdq.pizzademo.dtos.requests.PedidoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoResponseDTO;
import com.dellmdq.pizzademo.entities.PedidoCabecera;
import com.dellmdq.pizzademo.entities.PedidoDetalle;
import com.dellmdq.pizzademo.enums.Estado;
import com.dellmdq.pizzademo.repositories.PedidoRepository;
import com.dellmdq.pizzademo.services.impl.PedidoServiceImpl;
import com.dellmdq.pizzademo.utils.PedidoUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PedidoServiceTest {

    private PedidoRequestDTO pedidoRequestDTO1;
    private PedidoDetalle pedidoDetalle1;
    private PedidoCabecera pedidoCabecera1;
    private PedidoResponseDTO pedidoResponseDTO1;

    private PedidoDetalle pedidoDetalle2;
    private PedidoRequestDTO pedidoRequestDTO2;
    private PedidoCabecera pedidoCabecera2;
    private PedidoResponseDTO pedidoResponseDTO2;

    private List<PedidoCabecera> pedidoCabeceraList = new ArrayList<>();


    @InjectMocks
    private PedidoService pedidoService = new PedidoServiceImpl();

    @Mock
    private ProductoService productoService;

    @Mock
    private PedidoUtils pedidoUtils;

    @Mock
    private PedidoRepository pedidoRepository;


    @BeforeEach()
    public void setup(){
        pedidoRequestDTO1 = PedidosRequestDTOData.crearPedidoRequestDTO1();
        pedidoDetalle1 = PedidosDetalleData.pedidoDetalle1();
        pedidoCabecera1 = PedidosCabeceraData.pedidoCabecera1();
        pedidoResponseDTO1 = PedidosResponseDTOData.pedidoResponseDTO1();

        pedidoDetalle2 = PedidosDetalleData.pedidoDetalle2();
        pedidoRequestDTO2 = PedidosRequestDTOData.crearPedidoRequestDTO2();
        pedidoCabecera2 = PedidosCabeceraData.pedidoCabecera2();
        pedidoResponseDTO2 = PedidosResponseDTOData.pedidoResponseDTO2();

        pedidoCabeceraList.add(pedidoCabecera1);
        pedidoCabeceraList.add(pedidoCabecera2);
    }

    @Test
    @DisplayName("Test creación de pedido sin descuento")
    void crearPedidoSinDescuento() {
        List<PedidoDetalle> detallesList = new ArrayList<>();
        detallesList.add(pedidoDetalle1);

        PedidoCabecera cabecera = new PedidoCabecera();
        cabecera.setDetalles(detallesList);

        when(pedidoUtils.convertirAPedidoDetalle(pedidoRequestDTO1.getDetalle())).thenReturn(detallesList);
        when(pedidoUtils.descuentoTresArticulosAplicable(detallesList)).thenReturn(false);
        when(pedidoUtils.calcularMontoTotal(detallesList)).thenReturn(pedidoDetalle1.getPrecioUnitario());
        when(pedidoRepository.save(any(PedidoCabecera.class))).thenReturn(pedidoCabecera1);
        when(pedidoUtils.obtenerResponseDTO(pedidoCabecera1)).thenReturn(pedidoResponseDTO1);

        PedidoResponseDTO pedido = pedidoService.crearPedido(pedidoRequestDTO1);

        assertNotNull(pedido);
        assertEquals(LocalDate.of(2022,7,22).toString(), pedido.getFecha().toString());
        assertEquals(pedido.getDireccion(),pedidoRequestDTO1.getDireccion());
        assertEquals(pedido.getEmail(), pedidoRequestDTO1.getEmail());
        assertEquals(pedido.getTelefono(), pedidoRequestDTO1.getTelefono());
        assertEquals(LocalTime.of(20,30).toString(), pedido.getHorario().toString());
        assertNotNull(pedido.getDetalles());
        assertFalse(pedido.getDescuento());
        assertEquals(950.00D, pedido.getTotal());
        assertEquals(Estado.RECIBIDO,pedido.getEstado());

        verify(pedidoUtils, times(1)).convertirAPedidoDetalle(any());
        verify(pedidoUtils, times(1)).descuentoTresArticulosAplicable(any());
        verify(pedidoUtils, times(1)).calcularMontoTotal(any());
        verify(pedidoRepository, times(1)).save(any(PedidoCabecera.class));
        verify(pedidoUtils, times(1)).obtenerResponseDTO(any(PedidoCabecera.class));
    }

    @Test
    @DisplayName("Test creación de pedido con descuento")
    void crearPedidoConDescuento() {
        List<PedidoDetalle> detallesList = new ArrayList<>();
        detallesList.add(pedidoDetalle1);
        detallesList.add(pedidoDetalle2);

        PedidoCabecera cabecera = new PedidoCabecera();
        cabecera.setDetalles(detallesList);

        Double detalleTotal1 = pedidoDetalle1.getPrecioUnitario() * pedidoDetalle1.getCantidad();
        Double detalleTotal2 = pedidoDetalle2.getPrecioUnitario() * pedidoDetalle2.getCantidad();
        Double totalPedido = detalleTotal1 + detalleTotal2;

        when(pedidoUtils.convertirAPedidoDetalle(pedidoRequestDTO2.getDetalle())).thenReturn(detallesList);
        when(pedidoUtils.descuentoTresArticulosAplicable(detallesList)).thenReturn(false);
        when(pedidoUtils.calcularMontoTotal(detallesList)).thenReturn(totalPedido);
        when(pedidoRepository.save(any(PedidoCabecera.class))).thenReturn(pedidoCabecera2);
        when(pedidoUtils.obtenerResponseDTO(pedidoCabecera2)).thenReturn(pedidoResponseDTO2);

        PedidoResponseDTO pedido = pedidoService.crearPedido(pedidoRequestDTO1);

        assertNotNull(pedido);
        assertEquals(LocalDate.of(2022,7,22).toString(), pedido.getFecha().toString());
        assertEquals(pedido.getDireccion(),pedidoResponseDTO2.getDireccion());
        assertEquals(pedido.getEmail(), pedidoResponseDTO2.getEmail());
        assertEquals(pedido.getTelefono(), pedidoResponseDTO2.getTelefono());
        assertNotNull(pedido.getHorario());
        assertNotNull(pedido.getDetalles());
        assertTrue(pedido.getDescuento());
        assertEquals(3080.00D, pedido.getTotal());
        assertEquals(Estado.RECIBIDO,pedido.getEstado());

        verify(pedidoUtils, times(1)).convertirAPedidoDetalle(any());
        verify(pedidoUtils, times(1)).descuentoTresArticulosAplicable(any());
        verify(pedidoUtils, times(1)).calcularMontoTotal(any());
        verify(pedidoRepository, times(1)).save(any(PedidoCabecera.class));
        verify(pedidoUtils, times(1)).obtenerResponseDTO(any(PedidoCabecera.class));
    }

    @Test
    @DisplayName("Test listar pedidos por fecha")
    void listarPedidosPorFecha() {

        when(pedidoRepository.findByFechaAlta(LocalDate.of(2022,9,3))).thenReturn(pedidoCabeceraList);
        when(pedidoUtils.obtenerResponseDTO(pedidoCabecera1)).thenReturn(pedidoResponseDTO1);
        when(pedidoUtils.obtenerResponseDTO(pedidoCabecera2)).thenReturn(pedidoResponseDTO2);

        List<PedidoResponseDTO> pedidos = pedidoService.listarPedidosPorFecha(LocalDate.of(2022,9,3));

        assertNotNull(pedidos);
        assertEquals(2,pedidoCabeceraList.size());
        assertEquals(LocalDate.of(2022,9,3), pedidos.get(0).getFecha());
        assertEquals(LocalDate.of(2022,9,3), pedidos.get(1).getFecha());
        assertNotNull(pedidos.get(0).getDetalles());
        assertNotNull(pedidos.get(1).getDetalles());

        verify(pedidoRepository, times(1)).save(any(PedidoCabecera.class));
        verify(pedidoUtils, times(2)).obtenerResponseDTO(any(PedidoCabecera.class));

    }


}