package ProjManagerPackage.StuAssesElem;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class TableActionCellEditor_EditButton extends DefaultCellEditor {

    private TableActionEvent_EditButton event;
    
    public TableActionCellEditor_EditButton(TableActionEvent_EditButton event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object value, boolean isSelected, int row, int column) {
        EditButton action = new EditButton();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }

}
