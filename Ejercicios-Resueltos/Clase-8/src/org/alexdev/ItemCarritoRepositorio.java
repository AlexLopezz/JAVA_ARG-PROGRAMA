package org.alexdev;

import org.alexdev.interfaces.Convertible;
import org.alexdev.models.ItemCarrito;
import org.alexdev.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class ItemCarritoRepositorio implements Convertible<ItemCarrito> {
    List<ItemCarrito> carritoRepositorio;

    public ItemCarritoRepositorio() {
        this.carritoRepositorio = new ArrayList<>();
    }

    @Override
    public List<ItemCarrito> getItem(String[] itemsFiles) {
        if(this.carritoRepositorio != null) {
            int aux = 0;
            for(int i=0; i < itemsFiles.length - aux; i++ ){
                this.carritoRepositorio.add(
                        new ItemCarrito(
                                new Producto(
                                        itemsFiles[aux], Double.parseDouble(itemsFiles[aux+1])
                                ),
                                Integer.parseInt(itemsFiles[aux+2])
                        )
                );
                aux+= 3;
            }
            return this.carritoRepositorio;
        }else{
            return null;
        }
    }
}
