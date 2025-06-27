
import java.util.ArrayList;
import proyectofinal.Tienda;
import proyectofinal.Articulo;
import proyectofinal.Devolucion;
import proyectofinal.Venta;
import org.junit.*;
import static org.junit.Assert.*;

        
public class PruebasUnitariasParaDevoluciones {
    private Tienda tienda;
    
    @Before
    public void setUp(){
        tienda = new Tienda("Tendencia" );
    }

    
    
 @Test   
   public void regitrarDevolucion(){
    
     Articulo articulo = new Articulo("Blusa","Prendas Superiores","004",12.5);
     Venta venta = new Venta(articulo,"001",2,"28/3/25");
     String idDevolucion = "346";
     int cantidadDevuelta = 2 ;
     String fechaDevolucion = "1/4/25";
   
     Devolucion devolucion = new Devolucion(venta,idDevolucion,cantidadDevuelta,fechaDevolucion);
    
     assertEquals(idDevolucion,devolucion.getIdDevolucion()); 
     assertEquals("001", devolucion.getV().getIdVenta()); 
     assertEquals("004", devolucion.getV().getA().getIdArticulo()); 
     assertEquals(cantidadDevuelta,devolucion.getCantidadDevuelta()); 
     assertEquals(fechaDevolucion, devolucion.getFechaDevolucion()); 
     assertEquals(true,devolucion.getV().getA().getIsDevuelto());
   }
   
   
   
   
    @Test 
    public void añadirDevolucion(){
    
     Articulo articulo = new Articulo("Camisa","Prendas Superiores","008",10.99);
     Venta venta = new Venta(articulo,"009",5,"20/2/25");

     String idDevolucion = "308" ;
     int cantidadDevuelta = 1;
     String fechaDevolucion = "27/2/25" ;
       
        
     Devolucion devolucion = new Devolucion(venta,idDevolucion,cantidadDevuelta,fechaDevolucion);  
     tienda.addD(devolucion);
     
      
     assertEquals(1,tienda.getDevoluciones().size()); 
     assertFalse(tienda.getDevoluciones().isEmpty()); 
     assertTrue(tienda.getDevoluciones().contains(devolucion));
     
    }
     
    
    
    @Test
    public void registrarMultiplesDevoluciones(){
     
     Articulo articulo = new Articulo("Gorra","Prendas Extra","007",4.5);
     
     Venta venta = new Venta(articulo,"078",3,"8/2/25");
     Venta venta1 = new Venta(articulo,"098",9,"6/2/25");
     
     
     tienda.addD(new Devolucion(venta,"678",3,"10/2/25"));
     tienda.addD(new Devolucion(venta1,"378",2,"10/2/25"));
     
     assertEquals(2,tienda.getDevoluciones().size());
     
    }
    
}
 
