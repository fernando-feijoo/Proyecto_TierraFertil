package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Inspeccion_Contenedor {

    public static Modelo_Inspeccion_Contenedor instancia;

    private Modelo_Inspeccion_Contenedor() {

    }

    public static Modelo_Inspeccion_Contenedor getInstancia() {
        if (instancia == null) {
            instancia = new Modelo_Inspeccion_Contenedor();
        } else {
            System.out.println("No se puede crear el objeto " + instancia + " porque ya existe un objeto de la clase.");
        }
        return instancia;
    }

    Modelo_Conexion conexion = Modelo_Conexion.getInstancia();
    ResultSet rs;
    Statement st;
    public int id, id_contenedor, id_verificar_lugar;
    public boolean verificacion;

    public void guardar_Inspeccion_Contenedor() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "SELECT \"insertarDatosInspeccion\" (" + id + "," + id_contenedor + " , " + id_verificar_lugar + " , '" + verificacion + "')";
            st.execute(sql);
            st.close();
            conexion.cerrarBD();
        } catch (Exception e) {
        }
    }

    public ResultSet consultaID_entidadInspeccionContenedor() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 11) AS \"id_tablaInspeccionContenedor\" FROM inspeccion_contenedor;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("Consulta id entidad InspConte... BD MODELO, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener  id entidad InspeccionContenedor BD MODELO: " + e);
        } 
        return rs;
    }

    public ResultSet consultaDatos_entidadInspCont() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT id_verificar_lugar, verificacion FROM inspeccion_contenedor WHERE id_contenedor = " + id_contenedor + " ORDER BY id_verificar_lugar;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("ConsultaDatos id entidad InspConte... BD MODELO, " + id_contenedor);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad HigieneContenedor BD MODELO: " + e);
        } 
        return rs;
    }

    public ResultSet consultaInspCon() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT obser_ins_cont FROM contenedores WHERE id = " + id_contenedor + ";";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("ConsultaDatos id entidad InspConte... BD MODELO, " + id_contenedor);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad InspeccionContenedor BD MODELO: " + e);
        } 
        return rs;
    }

    public void pruebaGuardado() {
        System.out.println("IC: " + id + " , " + id_contenedor + " , " + id_verificar_lugar + " , " + verificacion);
    }

}
