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

            String sql = "";
            st.executeUpdate(sql);
            st.close();
            System.out.println(id + "<--idTabla \n" + id_contenedor + " <--idCon Conenedor Datos almacenados Paletizado BD MODELO.");
        } catch (Exception e) {
            System.out.println("MODELO PALETIZADO ERROR> " + e);
        }
    }
    //  Retorna 20 por defecto de 0.
     public ResultSet consultaID_entidadPallet() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 20) AS \"id_tablaPallet\" FROM control_pallet;";
            rs = st.executeQuery(sql);
            st.close();
            System.out.println("Consulta id entidad Pallet... BD MODELO, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad Pallet BD MODELO: " + e);
        }
        return rs;
    }
     
     public void pruebaGuardado() {
        System.out.println("PA: " + id + " , " + id_contenedor + " , " + codigo + " , " + id_cantidad_cajas);
    }
}
