
import java.util.ArrayList;
import java.util.Arrays;
import proyectofinal.Articulo;
import proyectofinal.Devolucion;
import proyectofinal.Tienda;
import proyectofinal.Venta;
import org.junit.*;
import static org.junit.Assert.*;


public class PruebasUnitariasParaBuscarArticulosPorCategoria {
    private Tienda tienda;
    
    @Before
    public void setUp(){
        tienda = new Tienda("Tendencia" );
        tienda.getInventario().add(new Articulo("Blusa","Prendas Superiores","004",12.5)) ;
    }

    
    
    
    
     @Test
     public void buscarListaArticulosPorCategoriaExistente(){
      ArrayList resultado = tienda.categoria("Prendas Superiores");
             
     
      assertNotNull("El articulo deberia existir",resultado);
      assertEquals(1,resultado.size());
             
    }       
      
    
    @Test 
    public void buscarPorCategoriaInexistente(){
      ArrayList resultado = tienda.categoria("Prendas Extra");
      
      assertEquals(0,resultado.size());
    
    }
 
    public void buscarListaArticulosConMayusculasYMinusculas() {
        ArrayList resultado = tienda.categoria("prendas inferiores");
        
        assertNotNull("La busqueda debe ser insensible a mayusculas/minusculas",resultado);
        assertEquals(2,resultado.size());
        
    }  
    
   
    
}
            
            


