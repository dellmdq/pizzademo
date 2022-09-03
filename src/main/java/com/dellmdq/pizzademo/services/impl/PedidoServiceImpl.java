package com.dellmdq.pizzademo.services.impl;

import com.dellmdq.pizzademo.dtos.requests.PedidoRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoResponseDTO;
import com.dellmdq.pizzademo.entities.PedidoCabecera;
import com.dellmdq.pizzademo.entities.PedidoDetalle;
import com.dellmdq.pizzademo.enums.Estado;
import com.dellmdq.pizzademo.exceptions.BadRequestException;
import com.dellmdq.pizzademo.repositories.PedidoRepository;
import com.dellmdq.pizzademo.services.PedidoService;
import com.dellmdq.pizzademo.utils.PedidoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j//todo logs
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoUtils pedidoUtils;

    @Override//fixme: trasladar logica DTO a controller
    public PedidoResponseDTO create(PedidoRequestDTO pedido) throws BadRequestException {
        //creacion cabecera
        PedidoCabecera cabecera = new PedidoCabecera(pedido.getDireccion(),
                pedido.getEmail(),
                pedido.getTelefono(),
                pedido.getHorario());
        //lista de detalles -> producto (para agregar al entity PedidoDetalle)
        List<PedidoDetalle> detallesCabecera = pedidoUtils.convertirAPedidoDetalle(pedido.getDetalle());
        cabecera.setDetalles(detallesCabecera);
        //logica de descuento más de 3 articulos
        cabecera.setAplicoDescuento(pedidoUtils.descuentoTresArticulosAplicable(detallesCabecera));
        //calculo monto total (validar si aplica el descuento)
        cabecera.setMontoTotal(pedidoUtils.calcularMontoTotal(detallesCabecera));
        //cambiar el estado cabecera
        cabecera.setEstado(Estado.RECIBIDO);
        //guardo detalles
        PedidoCabecera pedidoCreado = pedidoRepository.save(cabecera);
        //contruccion de respuesta
        PedidoResponseDTO response = pedidoUtils.obtenerResponseDTO(pedidoCreado);

        return response;

    }

    @Override
    public List<PedidoCabecera> listarPedidosPorFecha(LocalDate date) {
        return pedidoRepository.findByFechaAlta(date);
    }
}
