package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Contenedores {
    
    private static Modelo_Contenedores instancia;
    
    private Modelo_Contenedores(){
        
    }
    
    public static Modelo_Contenedores getInstancia() {
        if (instancia == null) {
            instancia = new Modelo_Contenedores();
        } else {
            System.out.println("No se puede crear el objeto " + instancia + " porque ya existe un objeto de la clase.");
        }
        return instancia;
    }
    
    Modelo_Conexion conexion = Modelo_Conexion.getInstancia();
    ResultSet rs;
    Statement st;
    public static int id;
    public static String codigo_Contenedor, obser_Ins_Cont, obser_Hig_Cont, obser_General;
    public boolean estado;
    
    public void guardarContenedorDatos() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT \"insertarDatosContenedor\"("+id+", '"+codigo_Contenedor+"', '"+obser_Ins_Cont+"', '"+obser_Hig_Cont+"', '"+obser_General+"');";
            st.execute(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println(id + " Datos almacenados Contenedor BD MODELO.");
        } catch (Exception e) {
            System.out.println("<<< ERROR CONTENEDOR >>> " + e);
        }
    }
    
    public ResultSet consultaID_contenedor() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 0) AS id_contenedor FROM contenedores;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("Consulta id contenedor... BD MODELO, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad contenedores en BD MODELO: " + e);
        } 
        return rs;
    }
    
    public void eliminadoEmergencia_Contenedor(){
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "DELETE FROM contenedores WHERE id = "+id+";";
            st.execute(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println(id + "<-ID Datos ELIMINADOS Contenedor BD MODELO \n ************EMERGENCIA************ \n ************EMERGENCIA************");
        } catch (Exception e) {
        }
    }
    
    public boolean errorID_Contenedor(){
        String validacion = "";
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT codigo FROM contenedores WHERE codigo ILIKE '"+codigo_Contenedor+"%';";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                validacion = rs.getString("codigo");
                if (validacion.equalsIgnoreCase(codigo_Contenedor)) {
                    return false;
                }
            }
            st.close();
            conexion.cerrarBD();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    
    public void pruebaGuardado(){
        System.out.println(id + " , " + codigo_Contenedor + " , " + obser_Ins_Cont + " , " + obser_Hig_Cont + " , " + obser_General);
    }
}
