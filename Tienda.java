                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  package proyectofinal;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Tienda implements IOperaciones {
    private String nombre;
    private ArrayList<Articulo> inventario;
    private ArrayList<Venta> ventas;
    private ArrayList<Devolucion> devoluciones;

    
    MiExcepcion m = new MiExcepcion();
    public Tienda(String nombre) {
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.devoluciones = new ArrayList<>();
    }
    
   

    public String getNombre(String nombre){
        return nombre;
    }
    
    
    
    public void setInventario (ArrayList<Articulo> inventario){
        this.inventario = new ArrayList<>();
    }
    
    public ArrayList<Articulo> getInventario(){
        return inventario;
    }
    
    
    
    public void setVentas (ArrayList<Venta> ventas){
        this.ventas = new ArrayList<>();
    }
    
    public ArrayList<Venta> getVentas(){
        return ventas;
    }
   
    
    
    public void setDevoluciones (ArrayList<Devolucion> devoluciones){
        this.devoluciones = new ArrayList<>();
    }
    
    public ArrayList<Devolucion> getDevoluciones(){
        return devoluciones;
    }
    
    
    
    public void añadirArticulo(Articulo articulo) {
        inventario.add(articulo);
        
    }

    
    
    @Override
    public void añadirVenta(Venta venta) {
        ventas.add(venta);
    }

    
    
    @Override
    public void añadirDevolucion(Devolucion devolucion) {
        devoluciones.add(devolucion);
    }

    
    
    @Override
    public Articulo buscarArticulosPorNombre(String nombre)throws MiExcepcion {
        for (Articulo a: inventario)
            if (a.getNombre().equalsIgnoreCase(nombre))
                return a;
           
        
    return null;    
//        for(Articulo a: inventario)
//            
//            if(a.getNombre()!=(nombre))throw m;
//                System.err.println(m.getMessage());
//                
//        return a;
    }    
    

    
    
    @Override
    public Articulo buscarArticulosPorCategoria(String categoria) {
        
            for (Articulo a: inventario)
            
                if(a.getCategoria().equalsIgnoreCase(categoria))
                
                    return a;
        
        
        return null;
    }
    
    
    

    @Override
    public ArrayList filtrarListaArticulosPorNombre(String nombre) {
        ArrayList<Articulo> filtroNombre = new ArrayList<>();
        for(Articulo a: inventario)
            if(a.getNombre().equalsIgnoreCase(nombre))
                filtroNombre.add(a);
        return filtroNombre;
                
    }
    
    

    @Override
    public ArrayList filtrarListaArticulosPorCategoria(String categoria) {
        ArrayList<Articulo> filtroCategoria = new ArrayList<>();
        for(Articulo a: inventario)
            if(a.getCategoria().equalsIgnoreCase(categoria))
                filtroCategoria.add(a);
        return filtroCategoria;

    }
    
    
    
   @Override
   public void eliminarArticulo(Articulo articulo){
       
           
       Articulo aux = null;
       try{
           for(Articulo a : inventario){
               if(a==articulo)
                   aux = a;
           break;
           
           }
       }catch(ConcurrentModificationException cme ){
           cme = new ConcurrentModificationException("El Artículo "+articulo+" no se encuentra en la lista" );
           System.err.println(cme.getMessage());
       }
      if(aux!=null)inventario.remove(aux);
   }


    
}
