package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.fabricante;
import tienda.entidades.producto;

public class productoDAO extends DAO {

    Scanner leer = new Scanner(System.in);

//a) Lista el nombre de todos los productos que hay en la tabla producto.
    public Collection<producto> listarProductos() throws Exception {

        try {
            String sql = "SELECT codigo, nombre, precio, codigo_fabricante FROM producto ";
            consultarBase(sql);

            Collection<producto> productos = new ArrayList();

            while (resultado.next()) {
                producto p = new producto();

                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));

                productos.add(p);

            }
            return productos;

        } catch (Exception e) {

            desconectarBase();
            throw new Exception("ERROR AL LISTAR PRODUCTOS");
        }
    }

//b) Lista los nombres y los precios de todos los productos de la tabla producto.
    public Collection<producto> listaNombrePrecio() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM producto ";
            consultarBase(sql);

            Collection<producto> productos = new ArrayList();

            while (resultado.next()) {
                producto p = new producto();

                p.setNombre(resultado.getString(1));
                p.setPrecio(resultado.getInt(2));
                productos.add(p);

            }
            desconectarBase();
            return productos;
        } catch (Exception e) {

            desconectarBase();
            throw e;

        }

    }
    //c) Listar aquellos productos que su precio esté entre 120 y 202.

    public Collection<producto> precioIntermedio() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM producto "
                    + "WHERE precio>=120 AND precio<=202;";

            consultarBase(sql);

            Collection<producto> productos = new ArrayList();

            while (resultado.next()) {

                producto p = new producto();
                p.setNombre(resultado.getString(1));
                p.setPrecio(resultado.getInt(2));
                productos.add(p);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }

//            String sql = "INSERT INTO producto (codigo, nombre, precio, codigoFabricante;)"
//                    + "VALUES ( '" + producto.getCodigo() + "' , '" 
//                    + producto.getNombre() + "' , '" 
//                    + producto.getPrecio() + "' , '" 
//                    + producto.getCodigoFabricante() + "' );";
    //CODIGO AUTOINCRMENTA
//    String sql = "INSERT INTO producto ( nombre, precio, codigoFabricante;)"
//            + "VALUES ( '" + producto.getNombre() + "' , '"
//            + producto.getPrecio() + "' , '"
//            + producto.getCodigoFabricante() + "' );";
//    d) Buscar y listar todos los Portátiles de la tabla producto.
    public Collection<producto> portatiles() throws Exception {

        try {
            String sql = "SELECT * FROM producto where nombre like '%portatil%' ";
            consultarBase(sql);

            Collection<producto> productos = new ArrayList();

            while (resultado.next()) {
                producto p = new producto();

                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));

                productos.add(p);

            }
            return productos;

        } catch (Exception e) {

            desconectarBase();
            throw new Exception("ERROR AL MOSTRAR LOS PORTATILES");

        }

    }

    //e) Listar el nombre y el precio del producto más barato.
    public Collection<producto> productoBarato() throws Exception {

        try {
            String sql = "SELECT  nombre, MIN(precio) FROM producto ";

            consultarBase(sql);

            Collection<producto> p = new ArrayList();

            while (resultado.next()) {
                producto p1 = new producto();

                p1.setNombre(resultado.getString(1));
                p1.setPrecio(resultado.getInt(2));

                p.add(p1);

            }
            desconectarBase();
            return p;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    //f) Ingresar un producto a la base de datos.

    public void ingresarProducto() throws Exception {
        Collection<producto> p = listarProductos();

        try {

            System.out.println("INGRESE NOMBRE DEL PRODUCTO");
            String nombre = leer.next();
            System.out.println("INGRESE PRECIO DEL PRODUCTO");
            int precio = leer.nextInt();
            System.out.println("INGRESE CODIGO DEL FABRICANTE");
            int cod_fab = leer.nextInt();

            String sql = "INSERT INTO Producto VALUES ( " + (p.size() + 1) + ", '" + nombre + "' , " + precio + " , " + cod_fab + " );";

            System.out.println(sql);
            insertarModificarEliminar(sql);

            producto prod = new producto();
//            prod.setCodigo(resultado.getInt(1));
            prod.setNombre(resultado.getString(2));
            prod.setPrecio(resultado.getDouble(3));
            prod.setCodigoFabricante(resultado.getInt(4));

            System.out.println("PRODUCTO CARGADO CON EXITO");
        } catch (Exception e) {
            throw new Exception("ERROR AL CARGAR PRODUCTO");
        } finally {
            desconectarBase();
        }
    }

    // g) Editar un producto con datos a elección
    public void editarProducto(producto p) throws Exception {
        Collection<producto> P = listarProductos();
        try {
            if (p == null) {
                System.out.println("Ingrese el codigo del producto que desea modificar");
                int codigoMod = leer.nextInt();
                codigoMod = p.getCodigo();
                
                 
                 
                 do {      System.out.println("Que desea modificar del producto??\n"
                 + 1- Ingrese el nuevo nombre del producto\n"
                 + ");              
                    switch(){}
                     
                     
                     
                } while (true);
                 
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
            String sql = "UPDATE Producto SET "
                    + " nombre = '" + p.getNombre() + "' , precio = " + p.getPrecio() + " , codigo_fabricante = " + p.getCodigoFabricante()
                    + " WHERE codigo = '" + p.getCodigo() + "'";

            System.out.println(sql);
            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw new Exception("ERROR AL EDITAR PRODUCTO");
        }

    }

}
