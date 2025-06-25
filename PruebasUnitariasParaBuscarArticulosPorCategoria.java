
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
    private ArrayList<Venta> ventas;
    private ArrayList<Devolucion> devoluciones;
    private ArrayList<Articulo> inventario;
    
    @Before
    public void setUp(){
         inventario = new ArrayList<>(Arrays.asList(
                new Articulo("Blusa","Prendas Superiores","004",12.5),
                new Articulo("Camisa","Prendas Superiores","008",10.99),
                new Articulo("Pantalon","Prendas Inferiores","045",35.78)));
         
        tienda = new Tienda("Tendencia", inventario, ventas, devoluciones);
    
    }
    
     @Test
     public void buscarListaArticulosPorCategoriaExistente(){
      ArrayList resultado = tienda.buscarListaArticulosPorCategoria("Prendas Superiores");
             
     
      assertNotNull("El articulo deberia existir",resultado);
      assertEquals(2,resultado.size());
             
    }       
      
    
    @Test 
    public void buscarPorCategoriaInexistente(){
      ArrayList resultado = tienda.buscarListaArticulosPorCategoria("Prendas Extra");
      
      assertNotNull("No deberia encontrar el articulo",resultado);
    
    }
 
    public void buscarListaArticulosConMayusculasYMinusculas() {
        ArrayList resultado = tienda.buscarListaArticulosPorCategoria("prendas inferiores");
        
        assertNotNull("La busqueda debe ser insensible a mayusculas/minusculas",resultado);
        assertEquals(2,resultado.size());
        
    }  
    
     @Test
    public void buscarArticulosConNull(){
       ArrayList resultado = tienda.buscarListaArticulosPorCategoria(null);
        
       assertNull("Buscar con null debe retornar null",resultado);
    
    }
      
    
}
            
            


