
import java.util.ArrayList;
import proyectofinal.Tienda;
import proyectofinal.Articulo;
import proyectofinal.Devolucion;
import proyectofinal.Venta;
import org.junit.*;
import static org.junit.Assert.*;

        
public class PruebasUnitariasParaDevoluciones {
    private String nombre;
    private Tienda tienda;
    
    @Before
    public void setUp(){
        tienda = new Tienda("Tendencia" );
    }

    
    
 @Test   
   public void regitrarDevolucion(){
    // Debe registrar la devolucion correctamente a traves del constructor
     Articulo articulo = new Articulo("Blusa","Prendas Superiores","004",12.5);//Se crea un nuevo objeto de tipo Articulo
     Venta venta = new Venta(articulo,"001",2,"28/3/25");//Se crea un nuevo objeto de tipo Venta
     //Se le pasan los parametros de la devolucion
     String idDevolucion = "346";
     int cantidadDevuelta = 2 ;
     String fechaDevolucion = "1/4/25";
     //Se crea un nuevo objeto de tipo Devolucion
     Devolucion devolucion = new Devolucion(venta,idDevolucion,cantidadDevuelta,fechaDevolucion);
    
     assertEquals(idDevolucion,devolucion.getIdDevolucion()); //Se genera correctamente el id de la devolucion
     assertEquals("001", devolucion.getV().getIdVenta()); //Se obtiene el id de la venta
     assertEquals("004", devolucion.getV().getA().getIdArticulo()); //Se obtiene el id del articulo
     assertEquals(cantidadDevuelta,devolucion.getCantidadDevuelta()); //Se almacena la cantidad devuelta
     assertEquals(fechaDevolucion, devolucion.getFechaDevolucion()); //Se almacena la fecha de la devolucion
     assertEquals(true,devolucion.getV().getA().getIsDevuelto());//Se modifica el estado del articulo
   }
   
   
   
   
    @Test 
    public void añadirDevolucion(){
    //Debe añadir devoluciones correctamente
     Articulo articulo = new Articulo("Camisa","Prendas Superiores","008",10.99);//Se crea un nuevo objeto de tipo Articulo
     Venta venta = new Venta(articulo,"009",5,"20/2/25");//Se crea un nuevo objeto de tipo Venta
     //Se le pasan los parametros de la devolucion
     String idDevolucion = "308" ;
     int cantidadDevuelta = 1;
     String fechaDevolucion = "27/2/25" ;
       
        
     //Se crea y agrega un nuevo objeto de tipo Devolucion
     Devolucion devolucion = new Devolucion(venta,idDevolucion,cantidadDevuelta,fechaDevolucion);  
     tienda.addD(devolucion);
     
      
     assertEquals(1,tienda.getDevoluciones().size()); //La lista de devoluciones debe tener una devolucion
     assertFalse(tienda.getDevoluciones().isEmpty()); //La lista de devoluciones no esta vacia
     assertTrue(tienda.getDevoluciones().contains(devolucion));//La lista de devoluciones contiene el objeto creado
     
    }
     
    
    
    @Test
    public void registrarMultiplesDevoluciones(){
    //Debe guardar todas las devoluciones
     
     Articulo articulo = new Articulo("Gorra","Prendas Extra","007",4.5);//Se crea un nuevo objeto de tipo Articulo
     //Se crean dos nuevos objetos de tipo Venta
     Venta venta = new Venta(articulo,"078",3,"8/2/25");
     Venta venta1 = new Venta(articulo,"098",9,"6/2/25");
     
     //Se crean y agregan dos nuevos objetos de tipo Devolucion
     tienda.addD(new Devolucion(venta,"678",3,"10/2/25"));
     tienda.addD(new Devolucion(venta1,"378",2,"10/2/25"));
     
     assertEquals(2,tienda.getDevoluciones().size());//La lista de devoluciones tiene dos devoluciones
     
    }
    
}
 
