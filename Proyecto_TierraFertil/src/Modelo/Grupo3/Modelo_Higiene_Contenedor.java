package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Higiene_Contenedor {

    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    /*
        No trabajaremos con el id de la entidad aqui, ya que se actualiaria donde el ID conendor sea igual
        al consultado. Ademas que eso debe heredar de la consulta contenedor o el dato a actualizar.
    */
    public int id_contenedor, id_limpieza_contenedor;
    public String opcion;

    public void guardarActualizar_DatosLlegada() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "SELECT \"insertarDatosHigiene\"(id_contenedor, id_limpieza_contenedor, opcion);";
            st.executeUpdate(sql);
            st.close();
            System.out.println(id_contenedor + " <--ID Conenedor Datos almacenados HiegieneContenedor BD con exito.");
        } catch (Exception e) {
            System.out.println("Error al tratar de guardar datos entidad HigieneContenedor: " + e);
        }
    }

    //  NO HARIAMOS CONSULTA DE ID EN ESTA ENTIDAD PORQUE ES TIPO LISTA, SERIA CON WHERE ID = IDCONTENEDOR (QUE ES UNICO)
    public ResultSet consultaID_entidadDatosLlegada() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 0) AS \"id_tablaDatosLlegada\" FROM datos_llegada;";
            rs = st.executeQuery(sql);
            st.close();
//            System.out.println("Consulta id entidad Llegada... BD Modelo, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad HigieneContenedor: " + e);
        }
        return rs;
    }
    
    public void pruebaGuardado(){
        System.out.println("HC: " + id_contenedor + " , " + id_limpieza_contenedor + " , " + opcion);
    }
}
