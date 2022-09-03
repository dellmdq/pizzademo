package com.dellmdq.pizzademo.utils;

import com.dellmdq.pizzademo.dtos.requests.DetalleRequestDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoDetalleResponseDTO;
import com.dellmdq.pizzademo.dtos.responses.PedidoResponseDTO;
import com.dellmdq.pizzademo.entities.PedidoCabecera;
import com.dellmdq.pizzademo.entities.PedidoDetalle;
import com.dellmdq.pizzademo.entities.Producto;
import com.dellmdq.pizzademo.services.ProductoService;
import com.dellmdq.pizzademo.services.impl.ProductoServiceImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoUtils {

    private static final Integer CANT_DESC_TRES_ARTICULOS = 3;
    private static final Double MULTIPLIER_DESC_TRES_ARTICULOS = 0.7;


    private final static ProductoService productoService = new ProductoServiceImpl();

    //boolean descuento
    public static Boolean descuentoTresArticulosAplicable(List<PedidoDetalle> detalles){
        int cantidadArticulos = detalles.stream().mapToInt(PedidoDetalle::getCantidad).sum();
        return cantidadArticulos > CANT_DESC_TRES_ARTICULOS;
    }

    //metodo de calculo de monto total
    public static Double calcularMontoTotal(List<PedidoDetalle> detalles){
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
    public static List<PedidoDetalle> convertirAPedidoDetalle(
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

    public static List<PedidoDetalleResponseDTO> convertirADetalleResponseDTO(
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

    //fixme: mejorar este mapeo
    public static PedidoResponseDTO obtenerResponseDTO(PedidoCabecera cabecera){

        PedidoResponseDTO response = new PedidoResponseDTO();
        response.setFecha(cabecera.getFechaAlta());
        response.setDireccion(cabecera.getDireccion());
        response.setEmail(cabecera.getEmail());
        response.setTelefono(cabecera.getTelefono());
        response.setHorario(cabecera.getHorario());
        response.setDetalles(convertirADetalleResponseDTO(cabecera.getDetalles()));
        response.setTotal(cabecera.getMontoTotal());
        response.setDescuento(cabecera.getAplicoDescuento());
        response.setEstado(cabecera.getEstado());

        return response;
    }
}
