package proyectofinal;

import java.util.ArrayList;

public class Venta {
    private String idVanta;
    private int cantVenta;
    private double totalVenta;
    private Articulo a;
    private String fechaVenta; 
    public Venta(Articulo a, String idVanta, int cantVenta, String fechaVenta) {
        this.idVanta = idVanta;
        this.cantVenta = cantVenta;
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

    public String getIdVanta() {
        return idVanta;
    }

    public void setIdVanta(String idVanta) {
        this.idVanta = idVanta;
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
