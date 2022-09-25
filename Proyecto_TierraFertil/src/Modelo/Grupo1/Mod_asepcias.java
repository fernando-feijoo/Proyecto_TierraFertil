package Modelo.Grupo1;

import Modelo.Modelo_Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mod_asepcias {
    
    Modelo_Conexion con = Modelo_Conexion.getInstancia();
    public String men1,men2,men3,men4,men5,men6,men7,men8,men9,men10,men11;
    public String men12,men13,men14,men15,men16,men17,men18,men19,men20,men21,men22;
    public String men23,men24,men25,men26,men27,men28,men29,men30,men31,men32,men33;
    
    public String men34,men35,men36,men37,men38,men39,men40,men41,men42,men43,men44;
    public String men45,men46,men47,men48,men49,men50,men51,men52,men53,men54,men55;
    public String men56,men57,men58,men59,men60,men61,men62,men63,men64,men65,men66;
    
    public int id_evaluacion;    
    public boolean datos_generales (){
        try {
            Statement st = con.conectarBD().createStatement();
            String sql="INSERT INTO public.asepcia_planta_empacadora(ape_bueno, ape_regular, ape_malo, id_evaluacion, id_pcontrol_ape) VALUES "
                    + "('"+men1+"', '"+men2+"', '"+men3+"', "+id_evaluacion+", "+1+"),"
                    + "('"+men4+"', '"+men5+"', '"+men6+"', "+id_evaluacion+", "+2+"),"         
                    + "('"+men7+"', '"+men8+"', '"+men9+"', "+id_evaluacion+", "+3+"),"
                    + "('"+men10+"', '"+men11+"', '"+men12+"', "+id_evaluacion+", "+4+"),"
                    + "('"+men13+"', '"+men14+"', '"+men15+"', "+id_evaluacion+", "+5+"),"
                    + "('"+men16+"', '"+men17+"', '"+men18+"', "+id_evaluacion+", "+6+"),"
                    + "('"+men19+"', '"+men20+"', '"+men21+"', "+id_evaluacion+", "+7+"),"
                    + "('"+men22+"', '"+men23+"', '"+men24+"', "+id_evaluacion+", "+8+"),"
                    + "('"+men25+"', '"+men26+"', '"+men27+"', "+id_evaluacion+", "+9+"),"
                    + "('"+men28+"', '"+men29+"', '"+men30+"', "+id_evaluacion+", "+10+"),"
                    + "('"+men31+"', '"+men32+"', '"+men33+"', "+id_evaluacion+", "+11+"),"    
                    + "('"+men34+"', '"+men35+"', '"+men36+"', "+id_evaluacion+", "+12+"),"
                    + "('"+men37+"', '"+men38+"', '"+men39+"', "+id_evaluacion+", "+13+"),"
                    + "('"+men40+"', '"+men41+"', '"+men42+"', "+id_evaluacion+", "+14+"),"
                    + "('"+men43+"', '"+men44+"', '"+men45+"', "+id_evaluacion+", "+15+"),"
                    + "('"+men46+"', '"+men47+"', '"+men48+"', "+id_evaluacion+", "+16+"),"
                    + "('"+men49+"', '"+men50+"', '"+men51+"', "+id_evaluacion+", "+17+"),"
                    + "('"+men52+"', '"+men53+"', '"+men54+"', "+id_evaluacion+", "+18+"),"
                    + "('"+men55+"', '"+men56+"', '"+men57+"', "+id_evaluacion+", "+19+"),"
                    + "('"+men58+"', '"+men59+"', '"+men60+"', "+id_evaluacion+", "+20+"),"
                    + "('"+men61+"', '"+men62+"', '"+men63+"', "+id_evaluacion+", "+21+"),"
                    + "('"+men64+"', '"+men65+"', '"+men66+"', "+id_evaluacion+", "+22+");";
            
            st.executeUpdate(sql);
            con.cerrarBD();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Mod_asepcias.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
