package Modelo.Grupo1;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mod_detalles_gen {

    Statement st;
    ResultSet rs;
    Modelo_Conexion con = Modelo_Conexion.getInstancia();

    public String cod_prod, cod_eva, cod_insp, nom_pod, ape_prod, vapor, hora_eva;
    public String finca_prod, nom_insp, ape_insp, placa, fecha_eva, tipo_caja;
    public int id_eva, semana;

    public int id_evaluacion() throws SQLException {
        int id = 1;
        st = con.conectarBD().createStatement();
        rs = st.executeQuery("select max (id) from public.evaluaciones;");
        while (rs.next()) {
            id = rs.getInt(1);
        }
        con.cerrarBD();
        return id;
    }

    public boolean guardar_inspector() throws SQLException {
        st = con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.inspectotes (codigo, nombre, apellido) VALUES ('" + this.cod_insp + "', '" + this.nom_insp + "', '" + this.ape_insp + "');");
        con.cerrarBD();
        return true;
    }

    public boolean guardar_productores() throws SQLException {
        st = con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.productores(codigo, nombre, apellido, finca) VALUES ('" + this.cod_prod + "', '" + this.nom_pod + "', '" + this.ape_prod + "', '" + this.finca_prod + "');");
        con.cerrarBD();
        return true;
    }

    public boolean guardar_evaluaciones() throws SQLException {
        st = con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.evaluaciones(\n"
                + "	id, cod_evaluacion, fecha_eva, hora_eva, vapor, tipo_caja, placa_vehivulo, "
                + "     id_semana, codigo_inspector, codigo_productor, estado)\n"
                + "	VALUES ("+id_eva+",'"+cod_eva+"', '"+fecha_eva+"', '"+hora_eva+"', '"+vapor+"','"+tipo_caja+"', '"+placa+"', "+semana+", '"+this.cod_insp+"', '"+this.cod_prod+"', 'Activo');");
        con.cerrarBD();
        return true;
    }
}
