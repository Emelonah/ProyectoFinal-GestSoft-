
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import proyectofinal.Articulo;
import proyectofinal.Devolucion;
import proyectofinal.Tienda;
import proyectofinal.Venta;


public class PruebasUnitariasParaVentas {
    private Tienda tienda;
    private ArrayList<Venta> ventas;
    private ArrayList<Devolucion> devoluciones;
    private ArrayList<Articulo> inventario;
    
     @Before
  public void setUp(){
      tienda = new Tienda("Estrellita",inventario, ventas, devoluciones);
  }
    
    @Test
    public void regitrarVenta(){
    // Debe registrar la venta correctamente a traves del constructor 
     Articulo articulo = new Articulo("blusa","Prendas Superiores","004",12.5);//Se crea un nuevo objeto de tipo Articulo
     //Se le pasan los parametros de la venta
     String idVenta = "001";
     int cantidadVendida = 2;
     double totalVenta = 25;
     String fechaVenta = "28/3/25";   
     Venta venta = new Venta(articulo,idVenta,cantidadVendida,totalVenta,fechaVenta);//Se crea un nuevo objeto de tipo Venta
     
     
     assertEquals(idVenta,venta.getIdVenta()); //Se genera correctamente el id de la venta
     assertEquals("004", venta.getArticulo().getIdArticulo()); //Se obtiene el id del articulo
     assertEquals(cantidadVendida,venta.getCantidadVendida()); //Se almacena la cantidad vendida
     assertEquals(fechaVenta, venta.getFechaVenta()); //Se almacena la fecha de la venta
     assertEquals(12.5 *2, venta.getTotalVenta(),0.0);// Se calcula el total de manera precisa
    
    }
    
  @Test 
    public void añadirVenta(){
    //Debe añadir correctamente una venta    
     Articulo articulo = new Articulo("Camisa","Prendas Superiores","008",10.99);//Se crea un nuevo objeto de tipo Articulo
     //Se le pasan los parametros de la venta
     String idVenta = "009";
     int cantidadVendida = 5;
     double totalVenta = 54.95;
     String fechaVenta = "20/2/25";  
        
     //Se crea y agrega un nuevo objeto de tipo Venta
     Venta venta = new Venta(articulo,idVenta,cantidadVendida,totalVenta,fechaVenta);//Se crea un nuevo objeto de tipo Venta
     
     tienda.añadirVenta(venta);
        
     assertEquals(1,tienda.getVentas().size());//La lista de ventas tiene una venta
     assertEquals("008",tienda.getVentas().get(0).getArticulo().getIdArticulo());//Se obtiene el id del articulo
     assertFalse(tienda.getVentas().isEmpty());//La lista de ventas no esta vacia
     assertTrue(tienda.getVentas().contains(venta));//La lista de ventas contiene el objeto creado
    } 
    
    
    
    @Test
    public void calcularTotalVenta(){ 
    //Debe multiplicar la catidad vendida por el precio del articulo
     Articulo articulo = new Articulo("Pantalon","Prendas Inferiores","007",35.69);//Se crea un nuevo objeto de tipo Articulo
     //Se le pasan los parametros de la venta
     String idVenta = "003";
     int cantidadVendida = 4;
     double totalVenta = 0;
     String fechaVenta = "15/1/25"; 
     //Se crea un nuevo objeto de tipo Venta y el valor total esperado
     Venta venta = new Venta (articulo,idVenta,cantidadVendida,totalVenta,fechaVenta);
     double totalEsperado = 142.76;
     
     assertEquals(totalEsperado,venta.getTotalVenta(),0.00);//Se valida que el total de la venta coincida con el valor total esperado
    }
    
    
    
   @Test
    public void registrarMultiplesVentas(){
    //Debe guardar todas las ventas
     Articulo articulo = new Articulo("Gorra","Prendas Extra","007",4.5);//Se crea un nuevo objeto de tipo Articulo
     
    //Se crean y agregan dos nuevos objetos de tipo Venta
     tienda.añadirVenta(new Venta(articulo,"078",3,13.5,"6/8/24"));
     tienda.añadirVenta(new Venta(articulo,"078",9,18,"6/2/25"));
     
     assertEquals(2,tienda.getVentas().size());//La lista de ventas tiene dos ventas
     
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void registrarVentaConCantidadCero(){
    //Debe lanzar la excepcion IllegalArgumentException   
     Articulo articulo = new Articulo("Falda","Prendas Inferiores","012",16.5);
     tienda.añadirVenta(new Venta (articulo,"056",0,0,"24/5/25"));//Falla al construir la venta
        
    }
    
     @Test(expected = IllegalArgumentException.class)
    public void registrarVentaConCantidadNegativa(){
    //Debe lanzar la excepcion IllegalArgumentException   
     Articulo articulo = new Articulo("Licra","Prendas Inferiores","034",8.94);
     tienda.añadirVenta(new Venta (articulo,"089",-3,26.82,"24/5/25"));//Falla al construir la venta porque la cantidad es negativa
        
    }
    
    
    
    @Test(expected = IllegalArgumentException.class)
    public void registrarVentaConTotalVentaNegativo(){
    //Debe lanzar la excepcion IllegalArgumentException   
     
     Articulo articulo = new Articulo("Licra","Prendas Inferiores","034",-8.94);//Se construye el objeto Articulo con precio negativo
     tienda.añadirVenta(new Venta (articulo,"089",3,-26.82,"24/5/25"));//Falla al construir la venta porque el total de la venta es negativo
        
    }
    
    
    
    
    
    
}


    
    



    


