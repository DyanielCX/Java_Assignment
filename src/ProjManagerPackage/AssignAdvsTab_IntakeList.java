package ProjManagerPackage;

import AdminPackage.IntakeRecord;
import ProjManagerPackage.AssignSupvElem.TableActionCellRender_TickCrossIcon;
import ProjManagerPackage.StuAssesElem.IntakeBasedMethod;
import ProjManagerPackage.StuAssesElem.ModernScrollBarUI;
import ProjManagerPackage.StuAssesElem.TableActionCellEditor_EditButton;
import ProjManagerPackage.StuAssesElem.TableActionCellRender_EditButton;
import ProjManagerPackage.StuAssesElem.TableHeader;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ProjManagerPackage.StuAssesElem.TableActionEvent_EditButton;


public class AssignAdvsTab_IntakeList extends javax.swing.JPanel {

    private ProjManager_MainFrame mainFrame;
    
    public AssignAdvsTab_IntakeList(ProjManager_MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        
        //Customize Table Modification
        /* Set the scrollbar to customize scrollbar*/
        fixTable(jScrollPane1);
        
        /* Set the header to customize header */
        IntakeListTable.getTableHeader().setReorderingAllowed(false);
        IntakeListTable.getTableHeader().setResizingAllowed(false);
        IntakeListTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(o + "");
                return header;
            }
        });


        // Set the tick and cross icon for advisors columns
        IntakeListTable.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender_TickCrossIcon());
        IntakeListTable.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender_TickCrossIcon());
        IntakeListTable.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender_TickCrossIcon());
        
        // Insert data into table
        for (IntakeRecord advisorsRecord :IntakeRecord.IntakeRecordData){
            String Intake = advisorsRecord.Intake;
            String Assessment = IntakeBasedMethod.getAssessment(Intake);
            Boolean isSupervisor = true;
            Boolean isSecondMarker = true;
            Boolean isRMCPLecturer = true;

            if (advisorsRecord.Spv1.equals("-") && advisorsRecord.Spv2.equals("-") && advisorsRecord.Spv3.equals("-")) {
                isSupervisor = false;
            }
            if (advisorsRecord.SecondMkr1.equals("-") && advisorsRecord.SecondMkr2.equals("-") && advisorsRecord.SecondMkr3.equals("-")) {
                isSecondMarker = false;
            }
            if (advisorsRecord.RMCP_Lecturer.equals("-")) {
                isRMCPLecturer = false;
            }

            Object[] InsertRow = {Intake, Assessment};
            
            DefaultTableModel model = (DefaultTableModel) IntakeListTable.getModel();
            model.addRow(InsertRow);
            
            // Set the appropriate icon based on the value of isSupervisor, SecondMarker and isRMCPLecturer
            if (isSupervisor==true) {
                model.setValueAt(true, model.getRowCount() - 1, 2);
            } else {
                model.setValueAt(false, model.getRowCount() - 1, 2);
            }

            if (isSecondMarker==true) {
                model.setValueAt(true, model.getRowCount() - 1, 3);
            } else {
                model.setValueAt(false, model.getRowCount() - 1, 3);
            }

            if (isRMCPLecturer==true) {
                model.setValueAt(true, model.getRowCount() - 1, 4);
            } else {
                model.setValueAt(false, model.getRowCount() - 1, 4);
            }
        }
        
        /*Set the edit button and its function*/
        TableActionEvent_EditButton event = new TableActionEvent_EditButton() {
            @Override
            public void onEdit(int row) {
                //Get the intake of selected intake
                String selectedIntake = (String) IntakeListTable.getValueAt(row, 0);
                
                // Switch to allot intake advisors tab
                mainFrame.createIntakeAdvsAllotPane(mainFrame, selectedIntake);
                int tabIndex = mainFrame.TabPanel.getTabCount()-1;
                mainFrame.changedTab(tabIndex);
            }
        };
        
        //Insert edit button into table
        IntakeListTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender_EditButton());
        IntakeListTable.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor_EditButton(event));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        IntakeListTable = new javax.swing.JTable();
        btbBack = new javax.swing.JLabel();
        TabTitle = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IntakeListTable.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        IntakeListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Intake", "Assessment", "Supervisor", "Second Marker", "RMCP Lecturer", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        IntakeListTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        IntakeListTable.setRowHeight(40);
        jScrollPane1.setViewportView(IntakeListTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 886, 440));

        btbBack.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        btbBack.setForeground(new java.awt.Color(0, 0, 0));
        btbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/leftArrow(Black).png"))); // NOI18N
        btbBack.setText("Back...");
        btbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbBackMouseClicked(evt);
            }
        });
        add(btbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        TabTitle.setFont(new java.awt.Font("Dubai Medium", 0, 28)); // NOI18N
        TabTitle.setText("Intake List");
        add(TabTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbBackMouseClicked
        mainFrame.changedTab(3);
    }//GEN-LAST:event_btbBackMouseClicked

    /* Customize the scrollbar for table */
    public void fixTable (JScrollPane scroll){
        scroll.getViewport().setBackground(Color.WHITE);
        
        JScrollBar verticalScrollBar = scroll.getVerticalScrollBar();
        verticalScrollBar.setUI(new ModernScrollBarUI());

        // Set other properties of the vertical scroll bar
        verticalScrollBar.setPreferredSize(new Dimension(3, 5));
        verticalScrollBar.setForeground(new Color(71, 105, 231, 178));
        verticalScrollBar.setUnitIncrement(20);
        verticalScrollBar.setOpaque(false);
        
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable IntakeListTable;
    private javax.swing.JLabel TabTitle;
    private javax.swing.JLabel btbBack;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
