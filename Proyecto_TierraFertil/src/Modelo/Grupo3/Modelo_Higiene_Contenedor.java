package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Higiene_Contenedor {
    
    private static Modelo_Higiene_Contenedor instancia;
    
    private Modelo_Higiene_Contenedor(){
        
    }
    
    public static Modelo_Higiene_Contenedor getInstancia() {
        if (instancia == null) {
            instancia = new Modelo_Higiene_Contenedor();
        } else {
            System.out.println("No se puede crear el objeto " + instancia + " porque ya existe un objeto de la clase.");
        }
        return instancia;
    }
    
    Modelo_Conexion conexion = Modelo_Conexion.getInstancia();
    ResultSet rs;
    Statement st;
    public int id, id_contenedor, id_limpieza_contenedor;
    public String opcion;

    public void guardarActualizar_DatosLlegada() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "SELECT \"insertarDatosHigiene\"(" + id + ", " + id_contenedor + ", " + id_limpieza_contenedor + ", '" + opcion + "');";
            st.execute(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println(id + "<--idTabla \n" + id_contenedor + " <--idCon Conenedor Datos almacenados HiegieneContenedor BD MODELO.");
        } catch (Exception e) {
        } 
    }

    public ResultSet consultaID_entidadHigCont() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 8) AS \"id_tablaHigCont\" FROM higiene_contenedor;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("Consulta id entidad HigCont... BD MODELO, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad HigieneContenedor BD MODELO: " + e);
        } 
        return rs;
    }

    public ResultSet consultaDatos_entidadHigCont() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT id_limpieza_contenedor, opcion FROM higiene_contenedor WHERE id_contenedor = "+id_contenedor+" ORDER BY id_limpieza_contenedor;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("ConsultaDatos id entidad HigCont... BD MODELO, " + id_contenedor);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad HigieneContenedor BD MODELO: " + e);
        } 
        return rs;
    }

    public ResultSet consultaObsHigCon() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT obser_hig_cont FROM contenedores WHERE id =  "+id_contenedor+";";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("ConsultaDatos id entidad HigCont... BD MODELO, " + id_contenedor);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad HigieneContenedor BD MODELO: " + e);
        } 
        return rs;
    }

    public void pruebaGuardado() {
        System.out.println("HC: " + id + " , " + id_contenedor + " , " + id_limpieza_contenedor + " , " + opcion);
    }
}
