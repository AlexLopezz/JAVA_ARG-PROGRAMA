package org.alexdev;

import org.alexdev.solution.models.CarritoCompra;
import org.alexdev.solution.models.ItemCarrito;
import org.alexdev.solution.models.Producto;
import org.alexdev.solution.models.descuento.DescuentoFijo;
import org.alexdev.solution.models.descuento.DescuentoPorcentaje;
import org.alexdev.solution.models.descuento.DescuentoPorcentajeConTope;
import org.alexdev.solution.models.persona.Cliente;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoTest {
    ItemCarrito[] itemCarritos;
    Cliente cliente;
    CarritoCompra carrito;
    String methodName;
    double resultado;
    ItemCarrito[] itemCarritoDescuento;

    @BeforeEach
    void initMethod(){
        cliente = new Cliente("Jorge", "Sanchez", "23131s");
        carrito = new CarritoCompra();
        itemCarritoDescuento = new ItemCarrito[3];
        itemCarritoDescuento[0] = new ItemCarrito(
                new Producto("Notebook Lenovo YOGA SLIM 7.", 2500),
                1
        );
        itemCarritoDescuento[1] = new ItemCarrito(
                new Producto("Mouse Logitech G203", 250),
                2
        );
        itemCarritoDescuento[2] = new ItemCarrito(
                new Producto("Cargador IPhone 3A", 700),
                1
        );
    }


    @Nested
    @DisplayName("Test Calculo de precio. Carrito de compras")
    class CalculoPrecioTest{
        @Test
        @DisplayName("Test: Calcular precio")
        void CalcularPrecioTest(){
            methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            itemCarritos = new ItemCarrito[4];
            itemCarritos[0] = new ItemCarrito(new Producto(
                    "Yogurt La Serenisima",
                    200
            ), 2);

            itemCarritos[1] = new ItemCarrito(new Producto(
                    "Leche La lechera",
                    300
            ), 1);
            itemCarritos[2] = new ItemCarrito(new Producto(
                    "Queso Cremoso Cremolatti",
                    500
            ), 2);
            itemCarritos[3] = new ItemCarrito(new Producto(
                    "Pan Frances",
                    350
            ), 2);

            carrito.setCliente(cliente);
            carrito.setItems(itemCarritos);


            resultado = carrito.getPrecioFinal(); //almacenamos en una variable el resultado arrojado por el calcular precio del carrito.

            assertEquals(2400, resultado); //Verificamos si nos da el precio correcto u esperado.
            finalizeTest(methodName);
        }
        @Test
        @DisplayName("Test: Calcular precio indicando cantidades negativas.")
        void cantidadItemPrecioTest(){
            methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

            itemCarritos = new ItemCarrito[4];
            //En este caso evaluaremos si cumple con el precio total, si los productos tienen una cantidad menor a 0, entonces no sumara al precio total del carrito:
            itemCarritos[0] = new ItemCarrito(new Producto(
                    "Yogurt La Serenisima",
                    200
            ), -10);

            itemCarritos[1] = new ItemCarrito(new Producto(
                    "Leche La lechera",
                    300
            ), -100);
            itemCarritos[2] = new ItemCarrito(new Producto(
                    "Queso Cremoso Cremolatti",
                    500
            ), -2);
            itemCarritos[3] = new ItemCarrito(new Producto(
                    "Pan Frances",
                    350
            ), 2);
            //En este caso solo me sumaria el valor del pan. Ya que es el unico item donde la cantidad es valida(mayor a 0)

            carrito.setCliente(cliente);
            carrito.setItems(itemCarritos);

            double resultadoEsperado = itemCarritos[3].getPrecioTotal(); //Tenemos en cuenta el valor del precio total del item 3. (Pan) como resultado esperado.

            resultado = carrito.getPrecioFinal(); //Almacenamos
            assertEquals(resultadoEsperado, resultado);
            finalizeTest(methodName);
        }
    }


    @Nested
    @DisplayName("Test descuento.")
    class DescuentoCarritoTest{
        @Test
        @DisplayName("Test: Descuento porcentaje")
        void DescuentoPorcentajeTest(){
            /*
            La idea en esta prueba es verificar que el descuento no sobrepase el precio base (%100 del precio).
            * Si lo sobrepasa, entonces no se aplicara el porcentaje de descuento(quedara en 0).
            * Si el porcentaje es menor a 0, entonces de igual manera el porcentaje de descuento quedara en 0.
             */
            methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            double descuentoPorcentaje = 110;

            DescuentoPorcentaje descPorcentaje = new DescuentoPorcentaje(descuentoPorcentaje);

            assertEquals(0, descPorcentaje.getPorcentaje()); // Tendria que dar 0 el porcentaje, ya que sobrepasa el precio base.
            descPorcentaje.setPorcentaje(-10d);

            assertEquals(0, descPorcentaje.getPorcentaje()); //Tambien tendria que quedar en 0, debido a que el porcentaje es menor a 0.

            resultado = descPorcentaje.descuento(2500); //Probando una simulacion, si el porcentaje de descuento es mayor a 0, entonces realizara el descuento de lo contario quedara el precio base.
            assertEquals(2500, resultado); //Tendria que quedar el precio base, debido a que como el porcentaje es 0, entonces no habria ningun descuento.

            finalizeTest(methodName);
        }


        @Test
        @DisplayName("Test: Descuento fijo")
        void PorcentajeFijoTest(){
            int monto = -15;
            DescuentoFijo descuentoFijo = new DescuentoFijo(monto);
            assertEquals(0, descuentoFijo.getMonto()); //Tendria que dar 0, debido a que el monto debe ser mayor a 0.

            descuentoFijo.setMonto(2000); //Cambiamos el monto fijo.
            int precioFinal = 1000; //Simulariamos el precio final del carrito.

            resultado = descuentoFijo.descuento(precioFinal); //Almacenamos el precio de descuento en una variable.
            assertEquals(0, resultado); //Tendria que dar 0, debido a que el monto fijo sobrepasa el precio base.
        }

        @Test
        @DisplayName("Test: Descuento porcentaje con TOPE")
        void PorcentajeTopeTest(){
            /*
            La idea en este TEST es que, una vez indicado el porcentaje en el constructor no poder cambiar/sobrepasar ese tope.
            Por lo tanto:
            * Si queremos cambiar el porcentaje, debemos verificar de cuanto es nuestro tope, ya que si lo sobrepasamos no surgira ningun efecto.
             */

            double topePorcentaje = 50;
            DescuentoPorcentajeConTope descTope = new DescuentoPorcentajeConTope(topePorcentaje);
            descTope.setPorcentaje(60d);
            resultado = descTope.getPorcentaje();

            assertEquals(topePorcentaje,resultado); //Tendria que dar el tope del porcentaje(50), debido a que el porcentaje que nosotros tenemos lo sobrepasa.

            descTope.setTope(20);
            descTope.setPorcentaje(15d);
            resultado = descTope.getPorcentaje();

            assertEquals(15d, resultado); //Tendria que coincidir esta vez, debido a que el porcentaje que especificamos es menor al tope.

        }
    }


    private void finalizeTest(String methodName){
        System.out.println("Prueba finalizada en el test -> "+methodName+"(): Success! ");
    }



}
