
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import proyectofinal.Articulo;
import proyectofinal.Devolucion;
import proyectofinal.Tienda;
import proyectofinal.Venta;


public class PruebasUnitariasParaVentas {
    private Tienda tienda;
    
    
     @Before
  public void setUp(){
      tienda = new Tienda("Estrellita");
  }
    
    @Test
    public void regitrarVenta(){
     Articulo articulo = new Articulo("blusa","Prendas Superiores","004",12.5);
     
     String idVenta = "001";
     int cantidadVenta = 2;
     String fechaVenta = "28/3/25";   
     Venta venta = new Venta(articulo,idVenta,cantidadVenta,fechaVenta);
     
     
     assertEquals(idVenta,venta.getIdVenta()); 
     assertEquals("004", venta.getA().getIdArticulo()); 
     assertEquals(cantidadVenta,venta.getCantVenta()); 
     assertEquals(fechaVenta, venta.getFechaVenta()); 
     assertEquals(12.5 *2, venta.getTotalVenta(),0.0);
    
    }
    
  @Test 
    public void añadirVenta(){ 
     Articulo articulo = new Articulo("Camisa","Prendas Superiores","008",10.99);
     
     String idVenta = "009";
     int cantidadVenta = 5;
     String fechaVenta = "20/2/25";  
        
    
     Venta venta = new Venta(articulo,idVenta,cantidadVenta,fechaVenta);
     
     tienda.addV(venta);
        
     assertEquals(1,tienda.getVentas().size());
     assertEquals("008",tienda.getVentas().get(0).getA().getIdArticulo());
     assertFalse(tienda.getVentas().isEmpty());
     assertTrue(tienda.getVentas().contains(venta));
    } 
    
    
    
    @Test
    public void calcularTotalVenta(){ 
    
     Articulo articulo = new Articulo("Pantalon","Prendas Inferiores","007",35.69);
    
     String idVenta = "003";
     int cantidadVenta = 4;
     String fechaVenta = "15/1/25"; 
     
     Venta venta = new Venta (articulo,idVenta,cantidadVenta,fechaVenta);
     double totalEsperado = 142.76;
     
     assertEquals(totalEsperado,venta.getTotalVenta(),0.00);
    }
    
    
    
   @Test
    public void registrarMultiplesVentas(){
    
     Articulo articulo = new Articulo("Gorra","Prendas Extra","007",4.5);
     
    
     tienda.addV(new Venta(articulo,"078",3,"6/8/24"));
     tienda.addV(new Venta(articulo,"078",9,"6/2/25"));
     
     assertEquals(2,tienda.getVentas().size());
     
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void registrarVentaConCantidadCero(){
      
     Articulo articulo = new Articulo("Falda","Prendas Inferiores","012",16.5);
     tienda.addV(new Venta (articulo,"056",0,"24/5/25"));
        
    }
    
     @Test(expected = IllegalArgumentException.class)
    public void registrarVentaConCantidadNegativa(){
    //Debe lanzar la excepcion IllegalArgumentException   
     Articulo articulo = new Articulo("Licra","Prendas Inferiores","034",8.94);
     tienda.addV(new Venta (articulo,"089",-3,"24/5/25"));
        
    }
   
    
    
    
    
    
    
}


    
    



    


