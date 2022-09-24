package Controlador.Grupo2;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (value instanceof JLabel) {
            JLabel btn_listado = (JLabel)value;
            

            
            return btn_listado;
            
        } 
        
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    
    }
//    super.

}
