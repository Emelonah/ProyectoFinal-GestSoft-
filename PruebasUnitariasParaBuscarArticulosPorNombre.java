
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
     public void buscarListaArticulosPorNombreExistente(){
      ArrayList resultado = tienda.buscarListaArticulosPorNombre("Camisa");
             
     
     assertNotNull("El articulo deberia existir",resultado);
     
             
    }       
      
    
    @Test 
    public void buscarPorNombreInexistente(){
      ArrayList resultado = tienda.buscarListaArticulosPorNombre("Zapatos");
      
      assertNotNull("No deberia encontrar el articulo",resultado);
    
    }
 
    public void buscarListaArticulosConMayusculasYMinusculas() {
        ArrayList resultado = tienda.buscarListaArticulosPorNombre("blusa");
        
        assertNotNull("La busqueda debe ser insensible a mayusculas/minusculas",resultado);
       
        
    }  
    
     @Test
    public void buscarArticulosConNull(){
       ArrayList resultado = tienda.buscarListaArticulosPorNombre(null);
        
       assertNull("Buscar con null debe retornar null",resultado);
    
    }
            
            
}