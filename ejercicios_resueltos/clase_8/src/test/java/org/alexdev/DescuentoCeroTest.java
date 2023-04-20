package org.alexdev;

import org.alexdev.exceptions.DescuentoCero;
import org.alexdev.exceptions.SinPrecioDescuento;
import org.alexdev.models.CarritoCompra;
import org.alexdev.models.ItemCarrito;
import org.alexdev.models.Producto;
import org.alexdev.models.descuento.DescuentoFijo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DescuentoCeroTest {
    CarritoCompra carrito;

    @BeforeEach
    void init(){
        carrito = new CarritoCompra();
    }
    @Test
    @DisplayName("Validando que el descuento no se pueda aplicar cuando el precio del carrito es 0.")
    void DescuentoPrecioTest() {
        carrito.addItems(
                new ItemCarrito(
                        new Producto("Mouse Logitech g203", 0),
                        1
                )
        );
        carrito.addItems(
                new ItemCarrito(
                        new Producto("Teclado Kumara redragon", 0),
                        1
                )
        );

        assertThrows( SinPrecioDescuento.class,
                () -> carrito.getPrecioFinal(new DescuentoFijo(200)));
    }

    @Test
    @DisplayName("Validando que el descuento no supere al precio total del carrito.")
    void DescuentoPrecioNegativoTest() {
        carrito.addItems(
                new ItemCarrito(
                        new Producto("Mouse Logitech g203", 250),
                        1
                )
        );
        carrito.addItems(
                new ItemCarrito(
                        new Producto("Teclado Kumara redragon", 400),
                        1
                )
        );
        assertThrows( DescuentoCero.class,
                () -> carrito.getPrecioFinal(new DescuentoFijo(900)));
    }

}
