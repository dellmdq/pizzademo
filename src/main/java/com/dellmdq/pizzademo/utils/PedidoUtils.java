package com.dellmdq.pizzademo.utils;

import com.dellmdq.pizzademo.dtos.requests.DetalleRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoDetalleResponseDTO;
import com.dellmdq.pizzademo.entities.PedidoDetalle;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoUtils {

    private final Integer CANT_DESC_TRES_ARTICULOS = 3;
    private final Double MULTIPLIER_DESC_TRES_ARTICULOS = 0.7;

    @Autowired
    private ProductoService productoService;

    //boolean descuento
    public Boolean descuentoTresArticulosAplicable(List<PedidoDetalle> detalles){
        int cantidadArticulos = detalles.stream().mapToInt(PedidoDetalle::getCantidad).sum();
        return cantidadArticulos > CANT_DESC_TRES_ARTICULOS;
    }

    //metodo de calculo de monto total
    public Double calcularMontoTotal(List<PedidoDetalle> detalles){
        double montoTotal = 0D;

        for (PedidoDetalle pd : detalles) {
            montoTotal += productoService.getProductoPrecioUnitario(pd.getProducto().getId()) * pd.getCantidad();
        }

        montoTotal = descuentoTresArticulosAplicable(detalles) ?
                montoTotal * MULTIPLIER_DESC_TRES_ARTICULOS :
                montoTotal;

        return montoTotal;
    }

    /**
     * Convierte la lista de detalles pasados por request a una lista del
     * entity PedidoDetalle.
     * @param detalleDTOList lista con los detalles pasados por request
     * @return Lista de detalle de pedido.
     */
    public List<PedidoDetalle> detalleRequestDTOtoPedidoDetalle(
            List<DetalleRequestDTO> detalleDTOList){
        List<PedidoDetalle> detallesCabecera = new ArrayList<>();
        for (DetalleRequestDTO pd : detalleDTOList) {
            Producto tempProd = productoService.findById(pd.getProducto());
            //agrego detalle a la lista de detalles
            detallesCabecera.add(new PedidoDetalle(
                    tempProd,
                    pd.getCantidad(),
                    tempProd.getPrecioUnitario()
            ));
        }
        return detallesCabecera;
    }

    public List<PedidoDetalleResponseDTO> pedidoDetalleToDetalleResponseDTO(
            List<PedidoDetalle> pedidoDetalles){
        List<PedidoDetalleResponseDTO> detalleDTOList = new ArrayList<>();

        for(PedidoDetalle pd : pedidoDetalles){
            PedidoDetalleResponseDTO responseDTO = new PedidoDetalleResponseDTO();
            responseDTO.setProducto(pd.getProducto().getId());
            responseDTO.setNombre(pd.getProducto().getNombre());
            responseDTO.setCantidad(pd.getCantidad());
            responseDTO.setImporte(pd.getPrecioUnitario());
            detalleDTOList.add(responseDTO);
        }
        return detalleDTOList;
    }
}
