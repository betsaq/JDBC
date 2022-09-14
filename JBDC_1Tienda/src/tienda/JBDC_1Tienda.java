package tienda;

import java.util.Scanner;
import tienda.servicios.fabricanteService;
import tienda.servicios.productoService;

/**
 *
 * @author Betsa
 */
public class JBDC_1Tienda {

 public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);

        productoService PS = new productoService();
        fabricanteService FS = new fabricanteService();

         PS.listaProductos(); 
        
//        PS.editaProducto();
        
//        
//        do {
//            System.out.println("QUE ACCIÓN DESEA REALIZAR?");
//            System.out.println("1) Lista el nombre de todos los productos que hay en la tabla producto.\n"
//                    + "2) Lista los nombres y los precios de todos los productos de la tabla producto.\n"
//                    + "3) Listar aquellos productos que su precio esté entre 120 y 202.\n"
//                    + "4) Buscar y listar todos los Portátiles de la tabla producto.\n"
//                    + "5) Listar el nombre y el precio del producto más barato.\n"
//                    + "6) Ingresar un producto a la base de datos.\n"
//                    + "7) Ingresar un fabricante a la base de datos\n"
//                    + "8) Editar un producto con datos a elección\n."
//                    + "9) Salir.");
//            String aux = leer.next();
//
//            switch (aux) {
//                case "1":
//                    PS.listaProductos();
//                    break;
//                case "2":
//                    PS.listaNombrePrecioProducto();
//                    break;
//                case "3":
//                    PS.precioIntermedio();
//                    break;
//                case "4":
//                    PS.portatiles();
//                    break;
//                case "5":
//                    PS.precioBarato();
//                    break;
//                case "6":
//                    PS.ingresa_Producto();
//                    break;
//                case "7":
//                    FS.ingresarFabricante();
//                    break;
//                case "8":
//                    
//                case "9":
//                    System.out.println("EL PROGRAMA HA FINALIZADO");
//            
//            }while (!"9".equals(aux));
//            {
//        }
        
        }
}
