package ProjManagerPackage.AssignSupvElem;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableActionCellRender_TickCrossIcon extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        
        // Check if the column is 2 or 3 (Supervisor or Second Marker)
        if (column == 1 || column == 2 || column == 3 || column == 4) {
            // Set the icon based on the value of the cell
            if ((boolean) value) {
                // Display tick icon for true
                com = new TickIcon();
                
            } else {
                // Display cross icon for false
                com = new CrossIcon();
            }
        }
        
        if (isSelected == false && row % 2 == 0) {
            com.setBackground(Color.WHITE);
        }
        
        else{
            com.setBackground(com.getBackground());
        }
        
        if (isSelected == true) {
            com.setBackground(new java.awt.Color(57, 105, 138));
        }

        return com;
    }
}
