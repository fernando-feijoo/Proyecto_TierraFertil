package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Higiene_Contenedor {

    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    public int id, id_contenedor, id_limpieza_contenedor;
    public String opcion;

    public void guardarActualizar_DatosLlegada() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "SELECT \"insertarDatosHigiene\"(" + id + ", " + id_contenedor + ", " + id_limpieza_contenedor + ", '" + opcion + "');";
            st.executeUpdate(sql);
            st.close();
            System.out.println(id + "<--idTabla \n" + id_contenedor + " <--idCon Conenedor Datos almacenados HiegieneContenedor BD MODELO.");
        } catch (Exception e) {
            //  No coloco el mostra exepcion porque da un mensaje siempre.
        }
    }

    //  NO HARIAMOS/// AL FINAL SI NECESITAMOS###  CONSULTA DE ID EN ESTA ENTIDAD PORQUE ES TIPO LISTA, SERIA CON WHERE ID = IDCONTENEDOR (QUE ES UNICO)
    //  ## Lo necesitamos para sacar el ultimo id y hacer el registro nuevo.
    public ResultSet consultaID_entidadHigCont() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 8) AS \"id_tablaHigCont\" FROM higiene_contenedor;";
            rs = st.executeQuery(sql);
            st.close();
            System.out.println("Consulta id entidad HigCont... BD MODELO, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad HigieneContenedor BD MODELO: " + e);
        }
        return rs;
    }

    public void pruebaGuardado() {
        System.out.println("HC: " + id + " , " + id_contenedor + " , " + id_limpieza_contenedor + " , " + opcion);
    }
}
