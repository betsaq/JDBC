package tienda.servicios;

import tienda.persistencia.fabricanteDAO;

public class fabricanteService {

    
  //  Ingresar un fabricante a la base de datos
    public void ingresarFabricante() throws Exception {
        fabricanteDAO f1 = new fabricanteDAO();

        f1.guardarFabricante();
    }

}
