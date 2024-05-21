package ProjManagerPackage.DashboardElem;

import ProjManagerPackage.RptStatusElem.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableActionCellRender_DashRptStatusIcon extends DefaultTableCellRenderer{

    // Constants to represent different states
    public static final int STATUS_PENDING = 0;
    public static final int STATUS_MARKED = 1;
    public static final int STATUS_NOSUBMITTED = 2;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        
        // Check if the column is 5
        if (column == 4) {
            // Set the icon based on the value of the cell
            if (value instanceof Integer) {
                int status = (int) value;
                switch (status) {
                    case STATUS_MARKED:
                        com = new MarkIcon();
                        break;
                    case STATUS_NOSUBMITTED:
                        com = new NoSubmittedIcon();
                        break;
                    case STATUS_PENDING:
                    default:
                        com = new PendingIcon();
                        break;
                }
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
