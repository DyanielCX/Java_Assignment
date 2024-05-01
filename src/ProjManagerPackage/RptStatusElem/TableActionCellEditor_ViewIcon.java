package ProjManagerPackage.RptStatusElem;

import ProjManagerPackage.StuAssessElem.*;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author PC
 */
public class TableActionCellEditor_ViewIcon extends DefaultCellEditor {

    private TableActionEvent event;
    
    public TableActionCellEditor_ViewIcon(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object value, boolean isSelected, int row, int column) {
        ViewIcon action = new ViewIcon();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }

}
