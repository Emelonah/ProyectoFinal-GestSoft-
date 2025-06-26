
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import proyectofinal.Articulo;
import proyectofinal.Devolucion;
import proyectofinal.Tienda;
import proyectofinal.Venta;


public class PruebasUnitariasParaBuscarArticulosPorNombre {
    private Tienda tienda;
   
    
    @Before
    public void setUp(){
         tienda = new Tienda("Tendencia" );
        tienda.getInventario().add(new Articulo("Camisa","Prendas Superiores","004",12.5)) ;
         
       
    
    }
    
     @Test
     public void buscarListaArticulosPorNombreExistente(){
      ArrayList resultado = tienda.nombre("Camisa");
             
     
     assertNotNull("El articulo deberia existir",resultado);
     assertEquals(1,resultado.size());
     
             
    }       
      
    
    @Test 
    public void buscarPorNombreInexistente(){
      ArrayList resultado = tienda.nombre("Zapatos");
      
     assertEquals(0,resultado.size());
    
    }
 
    public void buscarListaArticulosConMayusculasYMinusculas() {
        ArrayList resultado = tienda.nombre("blusa");
        
        assertNotNull("La busqueda debe ser insensible a mayusculas/minusculas",resultado);
       
        
    }  
    
            
            
}