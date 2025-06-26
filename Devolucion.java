package proyectofinal;

public class Devolucion {
    private Venta v;
    private String idDevolucion;
    private int cantidadDevuelta;
    private String fechaDevolucion;

    public Devolucion(Venta v, String idDevolucion, int cantidadDevuelta, String fechaDevolucion) throws IllegalArgumentException{
        
        this.v = v;
        this.idDevolucion = idDevolucion;
        if (cantidadDevuelta <= v.getCantVenta())
            this.cantidadDevuelta = cantidadDevuelta;
        else throw new IllegalArgumentException("Cantidad inválida");
        v.getA().setIsDevuelto(true);
        this.fechaDevolucion = fechaDevolucion;
    }

    public Venta getV() {
        return v;
    }

    public void setV(Venta v) {
        this.v = v;
    }

    public String getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(String idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public int getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    public void setCantidadDevuelta(int cantidadDevuelta) {
        this.cantidadDevuelta = cantidadDevuelta;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    
}
