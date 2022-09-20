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
            vapor, destino, nombre_paletizadores, total_viajar, cajas, cantidad_pallets, observacion;

    public void guardar_Despacho() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT \"insertarDatosDespacho\"(" + id + ", " + id_contenedor + ",'" + filtro + "','" + termografo + "','" + termografo_numero + "','" + sello_adhesivo + "','" + sello_verificador + "','" + sello_candado + "','" + (fecha_salidad + " " + hora_salida) + "','" + sello_cable + "', "
                    + "'" + compañia_transportista + "','" + sello_naviero + "','" + vapor + "','" + destino + "','" + nombre_paletizadores + "','" + total_viajar + "','" + cajas + "','" + cantidad_pallets + "','" + observacion + "')";

            st.executeUpdate(sql);
            st.close();
            conexion.conectarBD().close();
            System.out.println(id + " Datos almacenados Despacho BD con exito.");
        } catch (Exception e) {
        }
        
    }

    public ResultSet consultaID_entidadDespacho() {
        try {

            st = conexion.conectarBD().createStatement();
            String sql ="SELECT COALESCE(MAX(id), 0) AS \"id_tablaDatosDespacho\" FROM datos_despacho;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.conectarBD().close();
            System.out.println("Consulta id entidad Despacho... BD Modelo, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad datos_despacho: " + e);
        }
        return rs;
    }

    public ResultSet consultaDatos_entidadDatosDespacho() {
        try {
            //  Luego se debe cambiar el id, por el de los datos a actualizar.
            st = conexion.conectarBD().createStatement();
            String sql = "Select id,id_contenedor,filtro,termografo,termografo_numero,sello_adhesivo,sello_verificador,sello_exp_candado,\n"
                    + "fecha_hora_salida,sello_exp_cable,compania_transportista,sello_naviero,vapor,destino,nombre_paletizadores,total_viajar,\n"
                    + "cajas,cant_palet,observacion from datos_despacho where id = "+ id_contenedor +";";
            rs = st.executeQuery(sql);
            st.close();
            conexion.conectarBD().close();
            System.out.println("Consulta id entidad despacho... BD Modelo, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener datos entidad datos_despacho: " + e);
        }
        return rs;
    }

    public void pruebaGuardado() {
        // para validar si esta enviando bien la informacion.
        System.out.println(id + " , " +  id_contenedor + " , " + filtro + " , " + termografo + " , " + termografo_numero + " , " + sello_adhesivo + " , " + sello_verificador + " , \n" + 
                sello_candado + " , " + fecha_salidad + " , " + hora_salida + " , " + sello_cable + " , " + compañia_transportista + " , " + sello_naviero + " , \n" + 
                vapor + " , " +  destino + " , " +  nombre_paletizadores + " , " + total_viajar + " , " +  cajas + " , " +  cantidad_pallets + " , " +  observacion);
    }
}
