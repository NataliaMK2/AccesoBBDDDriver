package com.softtek.persistencia;

import com.softtek.modelo.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CRUDProducto {
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

    public void agregarProducto(Producto producto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO products (product_id, product_name, unit_price, units_in_stock, discontinued) VALUES (?, ?, ?, ?, ?);";
        conexion.abriConexion();
        PreparedStatement preparedStatement = conexion.miConexion.prepareStatement(sql);
        preparedStatement.setInt(1, producto.getIdProducto());
        preparedStatement.setString(2, producto.getNombreProducto());
        preparedStatement.setDouble(3, producto.getPrecioUnitario());
        preparedStatement.setInt(4, producto.getUnidadesStock());
        preparedStatement.executeUpdate();
    }


    public void actualizarProducto(Producto producto) throws SQLException {
        String sql = "UPDATE products SET product_name = ?, unit_price = ?, units_in_stock = ? WHERE product_id = ?;";
        PreparedStatement preparedStatement = conexion.miConexion.prepareStatement(sql);
        preparedStatement.setString(1, producto.getNombreProducto());
        preparedStatement.setDouble(2, producto.getPrecioUnitario());
        preparedStatement.setInt(3, producto.getUnidadesStock());
        preparedStatement.setInt(4, producto.getIdProducto());
        preparedStatement.executeUpdate();
    }

    public void eliminarProducto(int idProducto) throws SQLException {
        String sql = "DELETE FROM products WHERE product_id = ?;";
        PreparedStatement preparedStatement = conexion.miConexion.prepareStatement(sql);
        preparedStatement.setInt(1, idProducto);
        preparedStatement.executeUpdate();
    }
}