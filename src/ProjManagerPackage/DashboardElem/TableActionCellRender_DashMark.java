package ProjManagerPackage.DashboardElem;

import ProjManagerPackage.RptStatusElem.*;
import ProjManagerPackage.AccMgmtElem.*;
import ProjManagerPackage.AssignSupvElem.*;
import ProjManagerPackage.StuAssessElem.EditButton;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author PC
 */
public class TableActionCellRender_DashMark extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        MarkIcon action = new MarkIcon();
        if (isSelected == false && row % 2 == 0) {
            action.setBackground(Color.WHITE);
        }
        
        else{
        action.setBackground(com.getBackground());
        }

        return action;
    }
    
}
