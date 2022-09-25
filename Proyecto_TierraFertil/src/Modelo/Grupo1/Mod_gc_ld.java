package Modelo.Grupo1;
import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mod_gc_ld {
    
    public int cant36,cant37,cant38,cant39,cant40,cant41,cant42,cant43,cant44,cant45,cant46,cant47,cant48,cant49,cant50,cant51,cant52,cantTotal;
    public int num36,num37,num38,num39,num40,num41,num42,num43,num44,num45,num46,num47,num48,num49,num50,num51,num52;
    public double promedio_l, total_l;
    public int id_max, id_evaluacion;
    
    Modelo_Conexion con = Modelo_Conexion.getInstancia();
    Statement st; ResultSet rs;
    
    public boolean gc_cantidad () throws SQLException{
        st=con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.grado_calibre("
       + "id, cant_menos36, cant_g37, cant_g38, cant_g39, cant_g40, cant_g41, cant_g42, cant_g43, cant_g44, cant_g45, cant_g46, cant_g47, cant_g48, cant_g49, cant_g50, cant_g51, cant_mas52, total_cant_gc, id_evaluacion)\n" +
        " VALUES ("+id_max+","+this.cant36+", "+this.cant37+", "+this.cant38+", "+this.cant39+", "+this.cant40+", "+this.cant41+","
        + " "+this.cant42+", "+this.cant43+", "+this.cant44+", "+this.cant45+", "+this.cant46+", "+this.cant47+","
        + " "+this.cant48+", "+this.cant49+", "+this.cant50+", "+this.cant51+", "+this.cant52+", "+this.cantTotal+", "+this.id_evaluacion+");");
        con.cerrarBD();
        return true;
    }
    
    public boolean gc_numeros () throws SQLException {
        st=con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.datos_gc(\n" +
"	menos36, g37, g38, g39, g40, g41, g42, g43, g44, g45, g46,\n" +
"	g47, g48, g49, g50, g51, mas52, total_res_gc, promedio_gc, \n" +
"	id_grado_calibre)\n" +
"	VALUES ("+this.num36+", "+this.num37+", "+this.num38+", "+this.num39+", "+this.num40+", "+this.num41+", "+this.num42+", "+this.num43+",\n" +
"	"+this.num44+", "+this.num45+", "+this.num46+", "+this.num47+", "+this.num48+", "+this.num49+", "+this.num50+", "+this.num51+", "+this.num52+",\n" +
"	"+this.total_l+", "+this.promedio_l+", "+this.id_max+");");
        con.cerrarBD();
        return true;
    }
    
    public int id_gc () throws SQLException{
        int id=1;
        st=con.conectarBD().createStatement();
        rs=st.executeQuery("select max (id) from public.grado_calibre;");
        while (rs.next()) {            
            id=rs.getInt(1);
        }
        con.cerrarBD();
        return id;
    }
}