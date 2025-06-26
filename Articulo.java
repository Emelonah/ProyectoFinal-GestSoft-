package proyectofinal;

public class Articulo {
    private String nombre;
    private String categoria;
    private String idArticulo;
    private double precio;
    private boolean isDevuelto;

    public Articulo(String nombre, String categoria, String idArticulo, double precio) throws IllegalArgumentException{

        this.nombre = nombre;
        this.categoria = categoria;
        this.idArticulo = idArticulo;
        if (precio > 0 )
            this.precio = precio;
        else throw new IllegalArgumentException("Precio inválido");
        this.isDevuelto = false;
    }

    public boolean getIsDevuelto() {
        return isDevuelto;
    }

    public void setIsDevuelto(boolean isDevuelto) {
        this.isDevuelto = isDevuelto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
