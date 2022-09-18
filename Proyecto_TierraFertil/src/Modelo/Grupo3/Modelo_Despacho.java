package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Despacho {

    Modelo_Conexion conexion = new Modelo_Conexion();
    Modelo_Contenedores modeloContenedor = new Modelo_Contenedores();
    ResultSet rs;
    Statement st;
    public int id, id_contenedor;
    public String filtro, termografo, termografo_numero, sello_adhesivo, sello_verificador, sello_candado, fecha_salidad, hora_salida, sello_cable, compañia_transportista, sello_naviero,
            vapor, destino, nombre_paletizadores, total_viajar, cajas, cantidad_pallets;

    public boolean guardar_Despacho() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "SELECT \"insertarDespacho\"(" + id + ", " + id_contenedor + ",'" + filtro + "','" + termografo + "','" + termografo_numero + "','" + sello_adhesivo + "','" + sello_verificador + "','" + sello_candado + ",'" + (fecha_salidad + "" + hora_salida) + "','" + sello_cable + "', "
                    + "'" + compañia_transportista + "','" + sello_naviero + "','" + vapor + "','" + destino + "','" + nombre_paletizadores + "','" + total_viajar + "','" + cajas + "','" + cantidad_pallets + "')";

            st.executeUpdate(sql);
            st.close();
            System.out.println(id + " Datos almacenados Despacho BD con exito.");
        } catch (Exception e) {
            System.out.println("Error al tratar guardar los datos de llegada del contenedor " + e);
        }
        return true;
    }

    public ResultSet consultaID_entidadDespacho() {
        try {

            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 1) AS \"id_tablaDatosDespacho\" FROM datos_despacho;";
            rs = st.executeQuery(sql);
            st.close();
            System.out.println("Consulta id entidad Despacho... BD Modelo, " + this.id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad datos_despacho: " + e);
        }
        return rs;
    }

    public void pruebaGuardado() {
        // para validar si esta enviando bien la informacion.
         System.out.println( id + "," + id_contenedor + "," + termografo + "," + filtro );
    }
}
