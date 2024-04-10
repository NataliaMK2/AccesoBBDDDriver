package com.softtek.modelo;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precioUnitario;
    private int unidadesStock;

    public Producto(int idProducto, String nombreProducto, double precioUnitario, int unidadesStock) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.unidadesStock = unidadesStock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getUnidadesStock() {
        return unidadesStock;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", unidadesStock=" + unidadesStock +
                '}';
    }
}
