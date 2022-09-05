package com.dellmdq.pizzademo.data;

import com.dellmdq.pizzademo.entities.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductosData {

    public static Producto crearProducto1(){
        Producto prod1 = new Producto();
        prod1.setId(UUID.fromString("32f5a99a-76cc-42d6-84bb-1d40cd1b9f6b"));
        prod1.setNombre("Muzzarella");
        prod1.setDescripcionCorta("Pizza con muzzarella y aceitunas");
        prod1.setDescripcionLarga("");
        prod1.setPrecioUnitario(950.00D);
        return prod1;
    }
    
    public static Producto crearProducto2(){
        Producto prod2 = new Producto();
        prod2.setId(UUID.fromString("94e38a1d-bf6e-4f00-9a7f-ba21495631bb"));
        prod2.setNombre("Jamón y morrones");
        prod2.setDescripcionCorta("Pizza de jamón y morrones");
        prod2.setDescripcionLarga("");
        prod2.setPrecioUnitario(1150.00D);
        return prod2;
    }

    public static Producto crearProducto3(){
        Producto prod3 = new Producto();
        prod3.setId(UUID.fromString("d89c4e27-b7d2-430c-81d1-9b380e46a4f3"));
        prod3.setNombre("Calabresa");
        prod3.setDescripcionCorta("Pizza con Muzzarella y loganiza");
        prod3.setDescripcionLarga("");
        prod3.setPrecioUnitario(1400.00D);
        return prod3;
    }

    public static List<Producto> crearListaProductos1(){
        List<Producto> productos = new ArrayList<>();
        productos.add(crearProducto1());
        productos.add(crearProducto2());
        productos.add(crearProducto3());
        return productos;
    }
}
