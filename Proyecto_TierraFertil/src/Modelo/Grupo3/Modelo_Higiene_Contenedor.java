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

    //  ##Se debe actualizar id para consulta.
    public ResultSet consultaDatos_entidadHigCont() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT id_limpieza_contenedor, opcion FROM higiene_contenedor WHERE id_contenedor = 1 ORDER BY id_limpieza_contenedor;";
            rs = st.executeQuery(sql);
            st.close();
            System.out.println("ConsultaDatos id entidad HigCont... BD MODELO, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad HigieneContenedor BD MODELO: " + e);
        }
        return rs;
    }
    // ##Actualizar ID para consulta.
    public ResultSet consultaObsHigCon() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT obser_hig_cont FROM contenedores WHERE id = 1;";
            rs = st.executeQuery(sql);
            st.close();
            System.out.println("ConsultaDatos id entidad HigCont... BD MODELO, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad HigieneContenedor BD MODELO: " + e);
        }
        return rs;
    }

    public void pruebaGuardado() {
        System.out.println("HC: " + id + " , " + id_contenedor + " , " + id_limpieza_contenedor + " , " + opcion);
    }
}
