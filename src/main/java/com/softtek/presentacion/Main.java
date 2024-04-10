package com.softtek.presentacion;

import com.softtek.modelo.Producto;
import com.softtek.persistencia.CRUDProducto;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String [] args){
        CRUDProducto crudProducto = new CRUDProducto();
        try{
            Producto pro = new Producto(1, "producto nuevo", 100.0, 50);
            crudProducto.agregarProducto(pro);
            System.out.println("Producto añadido correctamente");

           List<Producto> productos = crudProducto.obtenerTodos();
            for (Producto producto : productos) {
                System.out.println(producto);
            }

            pro.setNombreProducto("Actualizando...");
            crudProducto.actualizarProducto(pro);
            System.out.println("Producto actualizado");

            crudProducto.eliminarProducto(pro.getIdProducto());
            System.out.println("Producto eliminado");

        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
