package proyectofinal;

import java.util.ArrayList;

public class Venta {
    private String idVenta;
    private int cantVenta;
    private double totalVenta;
    private Articulo a;
    private String fechaVenta; 
    
    
    public Venta(Articulo a, String idVenta, int cantVenta, String fechaVenta) throws IllegalArgumentException{
       if(cantVenta<=0)
           throw new IllegalArgumentException("Cantidad de venta invalida");
       else this.cantVenta = cantVenta;
        this.idVenta = idVenta;
        this.a = a;
        this.fechaVenta = fechaVenta;
        this.totalVenta = a.getPrecio()* this.cantVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Articulo getA() {
        return a;
    }

    public void setA(Articulo a) {
        this.a = a;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantVenta() {
        return cantVenta;
    }

    public void setCantVenta(int cantVenta) {
        this.cantVenta = cantVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
        
        
}
