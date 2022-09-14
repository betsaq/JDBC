//a) Lista el nombre de todos los productos que hay en la tabla producto.
//b) Lista los nombres y los precios de todos los productos de la tabla producto.
//c) Listar aquellos productos que su precio esté entre 120 y 202.
//d) Buscar y listar todos los Portátiles de la tabla producto.
//e) Listar el nombre y el precio del producto más barato.
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.fabricante;

public class fabricanteDAO extends DAO {

    Scanner leer = new Scanner(System.in);

    public fabricanteDAO() {
    }

    public void guardarFabricante() throws Exception {
        Collection<fabricante> fabricante = listarFabricantes();

        try {
            System.out.println("INGRESE FABRICANTE");
            String fab = leer.next();

            String sql = "INSERT INTO Fabricante VALUES ( '" + (fabricante.size() + 1) + "' , '" + fab + "' );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
            System.out.println("FABRICANTE CARGADO CON EXITO");
        } catch (Exception e) {
            throw new Exception("ERROR AL CARGAR FABRICANTE");
        } finally {
            desconectarBase();
        }
    }

    public Collection<fabricante> listarFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante ";
            consultarBase(sql);
            fabricante fab = null;
            Collection<fabricante> fabricante = new ArrayList();
            while (resultado.next()) {
                fab = new fabricante();

                fab.setCodigo(resultado.getInt(1));
                fab.setNombre(resultado.getString(2));
                fabricante.add(fab);
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {

            desconectarBase();
            throw e;
        }
    }

}
