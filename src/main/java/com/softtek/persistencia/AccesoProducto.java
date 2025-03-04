package com.softtek.persistencia;

import com.softtek.modelo.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoProducto extends Conexion {
    private Conexion conexion = new Conexion();

    public List<Producto> obtenerTodos() throws ClassNotFoundException, SQLException {

        Statement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, units_in_stock from products;";
        List<Producto> productos = new ArrayList<>();
        conexion.abriConexion();
        sentencia = conexion.miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while(resultado.next()){
            productos.add(new Producto(
                    resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock")
            ));
        }
        return productos;
    }
}
