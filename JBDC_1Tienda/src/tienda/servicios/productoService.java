package tienda.servicios;


import java.util.Scanner;
import tienda.entidades.producto;
import tienda.persistencia.productoDAO;

public class productoService {

    Scanner leer = new Scanner(System.in);
    private productoDAO DAO;

    public productoService(productoDAO DAO) {
        this.DAO = DAO;
    }

    public productoService() {

    }
//    Lista los nombres y los precios de todos los productos de la tabla producto

    public void listaNombrePrecioProducto() throws Exception {
        productoDAO PD = new productoDAO();

        for (producto prod : PD.listaNombrePrecio()) {

            System.out.println("NOMBRE DEL PRODUCTO: " + prod.getNombre()
                    + ", PRECIO: " + prod.getPrecio());

        }
    }

// Lista el nombre de todos los productos que hay en la tabla producto
    public void listaProductos() throws Exception {
        productoDAO PD = new productoDAO();

        for (producto prod : PD.listarProductos()) {

            System.out.println(" CODIGO PRODUCTO: " + prod.getCodigo()
                    + ", NOMBRE: " + prod.getNombre()
                    + ", PRECIO: " + prod.getPrecio()
                    + ", COD. FABRICANTE: " + prod.getCodigoFabricante());

        }

    }

    //c) Listar aquellos productos que su precio esté entre 120 y 202.
    public void precioIntermedio() throws Exception {
        productoDAO PD = new productoDAO();

        for (producto prod : PD.precioIntermedio()) {

            System.out.println(" NOMBRE: " + prod.getNombre()
                    + ", PRECIO: " + prod.getPrecio());

        }

    }

//  Buscar y listar todos los Portátiles de la tabla producto
    public void portatiles() throws Exception {
        productoDAO PD = new productoDAO();

        for (producto prod : PD.portatiles()) {

            System.out.println(" CODIGO PRODUCTO: " + prod.getCodigo()
                    + ", NOMBRE: " + prod.getNombre()
                    + ", PRECIO: " + prod.getPrecio()
                    + ", COD. FABRICANTE: " + prod.getCodigoFabricante());

        }
    }
    //  Listar el nombre y el precio del producto más barato.\n"

    public void precioBarato() throws Exception {
        productoDAO PD = new productoDAO();

        for (producto prod : PD.productoBarato()) {

            System.out.println(" NOMBRE: " + prod.getNombre()
                    + ", PRECIO: " + prod.getPrecio());

        }

    }

//    Ingresar un producto a la base de datos
    public void ingresa_Producto() throws Exception {

        productoDAO p1 = new productoDAO();

        p1.ingresarProducto();

    }

//    public void ingresaProducto(producto producto, String nombre, int codigo, int codigoFabricante, double precio) {
//        try {
//            
//            if (producto == null) {
//                throw new Exception("Debe indicar el nombre del producto, su codigo, precio y codigo del fabricante");
//
//            }
//            producto p = new producto();
//
//            System.out.println("Ingrese el nombre del producto");
//            producto.setNombre(nombre);
//            System.out.println("Ingrese el codigo del producto");
//            producto.setCodigo(codigo);
//            System.out.println("Ingrese el precio");
//            producto.setPrecio(precio);
//            System.out.println("Ingrese el codigo del fabricante");
//            producto.setCodigoFabricante(codigoFabricante);
//            DAO.ingresarProducto(producto);
//        } catch (Exception e) {
//        } finally {
//
//        }
//    Editar un producto con datos a elección
    public void editaProducto() throws Exception {
        producto p = new producto();
        productoDAO PD = new productoDAO();
        listaProductos();
        PD.listarProductos();

//        System.out.println("Ingrese el codigo del producto que desea modificar");
//        int codCambio = leer.nextInt();
       
            System.out.println("que desea modificar del producto?");
            String opcion = leer.next();
            if (opcion.equals("nombre")) {
                System.out.println("Ingrese el nuevo nombre del producto");
                p.setNombre(leer.next());

            }
            if (opcion.equals("precio")) {
                System.out.println("Ingrese el nuevo precio del producto");
                p.setPrecio(leer.nextDouble());
            }
            if (opcion.equals("fabricante")) {
                System.out.println("Ingrese el fabricante del producto");
                p.setCodigoFabricante(leer.nextInt());
            }

        }

        DAO.editarProducto(p);

    }

}
