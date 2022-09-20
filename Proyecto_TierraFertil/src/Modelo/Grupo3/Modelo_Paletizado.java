package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Paletizado {

    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    public int id, id_contenedor, codigo, id_cantidad_cajas;

    public void guardarActualizar_DatosLlegada() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "SELECT \"insertarDatosPalet\"("+id+", "+id_contenedor+", "+codigo+", "+id_cantidad_cajas+");";
            st.executeUpdate(sql);
            st.close();
            conexion.conectarBD().close();
            System.out.println(id + "<--idTabla \n" + id_contenedor + " <--idCon Conenedor Datos almacenados Paletizado BD MODELO.");
        } catch (Exception e) {
        }
    }

    //  Retorna 20 por defecto de 0.
    public ResultSet consultaID_entidadPallet() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 20) AS \"id_tablaPallet\" FROM control_pallet;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.conectarBD().close();
            System.out.println("Consulta id entidad Pallet... BD MODELO, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad Pallet BD MODELO: " + e);
        }
        return rs;
    }
    //  #ACTUALIZAR id para consulta, esta 1 por defecto.
    public ResultSet consultaDatos_entidadPaletizado() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT id, codigo, id_cantidad_cajas FROM control_pallet WHERE id_contenedor = "+id_contenedor+" ORDER BY id;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.conectarBD().close();
            System.out.println("ConsultaDatos id entidad Pallet... BD MODELO, " + id_contenedor);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad Pallet BD MODELO: " + e);
        }
        return rs;
    }
    //  #ACTUALIZAR id para consulta, esta 1 por defecto.
    public ResultSet consultaObsGeneral() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT obser_general FROM contenedores WHERE id = "+id_contenedor+";";
            rs = st.executeQuery(sql);
            st.close();
            conexion.conectarBD().close();
            System.out.println("ConsultaDatos id entidad Pallet... BD MODELO, " + id_contenedor);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad Pallet BD MODELO: " + e);
        }
        return rs;
    }

    public void pruebaGuardado() {
        System.out.println("PA: " + id + " , " + id_contenedor + " , " + codigo + " , " + id_cantidad_cajas);
    }
}
