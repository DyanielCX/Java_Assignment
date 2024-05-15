package ProjManagerPackage.RptStatusElem;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableActionCellRender_ViewIcon extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        ViewIcon action = new ViewIcon();
        action.setBackground(com.getBackground());

        return action;
    }
    
}
