
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
    // Debe registrar la venta correctamente a traves del constructor 
     Articulo articulo = new Articulo("blusa","Prendas Superiores","004",12.5);//Se crea un nuevo objeto de tipo Articulo
     //Se le pasan los parametros de la venta
     String idVenta = "001";
     int cantidadVenta = 2;
     String fechaVenta = "28/3/25";   
     Venta venta = new Venta(articulo,idVenta,cantidadVenta,fechaVenta);//Se crea un nuevo objeto de tipo Venta
     
     
     assertEquals(idVenta,venta.getIdVenta()); //Se genera correctamente el id de la venta
     assertEquals("004", venta.getA().getIdArticulo()); //Se obtiene el id del articulo
     assertEquals(cantidadVenta,venta.getCantVenta()); //Se almacena la cantidad vendida
     assertEquals(fechaVenta, venta.getFechaVenta()); //Se almacena la fecha de la venta
     assertEquals(12.5 *2, venta.getTotalVenta(),0.0);// Se calcula el total de manera precisa
    
    }
    
  @Test 
    public void añadirVenta(){
    //Debe añadir correctamente una venta    
     Articulo articulo = new Articulo("Camisa","Prendas Superiores","008",10.99);//Se crea un nuevo objeto de tipo Articulo
     //Se le pasan los parametros de la venta
     String idVenta = "009";
     int cantidadVenta = 5;
     String fechaVenta = "20/2/25";  
        
     //Se crea y agrega un nuevo objeto de tipo Venta
     Venta venta = new Venta(articulo,idVenta,cantidadVenta,fechaVenta);//Se crea un nuevo objeto de tipo Venta
     
     tienda.addV(venta);
        
     assertEquals(1,tienda.getVentas().size());//La lista de ventas tiene una venta
     assertEquals("008",tienda.getVentas().get(0).getA().getIdArticulo());//Se obtiene el id del articulo
     assertFalse(tienda.getVentas().isEmpty());//La lista de ventas no esta vacia
     assertTrue(tienda.getVentas().contains(venta));//La lista de ventas contiene el objeto creado
    } 
    
    
    
    @Test
    public void calcularTotalVenta(){ 
    //Debe multiplicar la catidad vendida por el precio del articulo
     Articulo articulo = new Articulo("Pantalon","Prendas Inferiores","007",35.69);//Se crea un nuevo objeto de tipo Articulo
     //Se le pasan los parametros de la venta
     String idVenta = "003";
     int cantidadVenta = 4;
     String fechaVenta = "15/1/25"; 
     //Se crea un nuevo objeto de tipo Venta y el valor total esperado
     Venta venta = new Venta (articulo,idVenta,cantidadVenta,fechaVenta);
     double totalEsperado = 142.76;
     
     assertEquals(totalEsperado,venta.getTotalVenta(),0.00);//Se valida que el total de la venta coincida con el valor total esperado
    }
    
    
    
   @Test
    public void registrarMultiplesVentas(){
    //Debe guardar todas las ventas
     Articulo articulo = new Articulo("Gorra","Prendas Extra","007",4.5);//Se crea un nuevo objeto de tipo Articulo
     
    //Se crean y agregan dos nuevos objetos de tipo Venta
     tienda.addV(new Venta(articulo,"078",3,"6/8/24"));
     tienda.addV(new Venta(articulo,"078",9,"6/2/25"));
     
     assertEquals(2,tienda.getVentas().size());//La lista de ventas tiene dos ventas
     
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void registrarVentaConCantidadCero(){
    //Debe lanzar la excepcion IllegalArgumentException   
     Articulo articulo = new Articulo("Falda","Prendas Inferiores","012",16.5);
     tienda.addV(new Venta (articulo,"056",0,"24/5/25"));//Falla al construir la venta
        
    }
    
     @Test(expected = IllegalArgumentException.class)
    public void registrarVentaConCantidadNegativa(){
    //Debe lanzar la excepcion IllegalArgumentException   
     Articulo articulo = new Articulo("Licra","Prendas Inferiores","034",8.94);
     tienda.addV(new Venta (articulo,"089",-3,"24/5/25"));//Falla al construir la venta porque la cantidad es negativa
        
    }
   
    
    
    
    
    
    
}


    
    



    


