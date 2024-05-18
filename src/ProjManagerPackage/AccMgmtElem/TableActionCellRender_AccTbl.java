package ProjManagerPackage.AccMgmtElem;


import ProjManagerPackage.StuAssesElem.EditButton;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableActionCellRender_AccTbl extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        EditButton action = new EditButton();
        action.setBackground(com.getBackground());

        return action;
    }
    
}
