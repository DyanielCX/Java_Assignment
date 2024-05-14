package ProjManagerPackage;

import ProjManagerPackage.RptStatusElem.TableActionCellEditor_ViewIcon;
import ProjManagerPackage.RptStatusElem.TableActionCellRender_ViewIcon;
import ProjManagerPackage.RptStatusElem.TableHeader_StuIntake;
import ProjManagerPackage.StuAssessElem.IntakeBasedMethod;
import ProjManagerPackage.StuAssessElem.ModernScrollBarUI;
import ProjManagerPackage.StuAssessElem.TableActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class RptStatus_StuIntake extends javax.swing.JPanel {

    private MainFrame mainFrame;
    
    public RptStatus_StuIntake(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        
        //Customize Table Modification
        /* Set the scrollbar to customize scrollbar*/
        fixTable(jScrollPane1);
        
        /* Set the header to customize header */
        IntakeAssTable.getTableHeader().setReorderingAllowed(false);
        IntakeAssTable.getTableHeader().setResizingAllowed(false);
        IntakeAssTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_StuIntake header = new TableHeader_StuIntake(o + "");
                return header;
            }
        });

        
        //Insert data into table
        /*Show the intake have been alloted assesment*/
        ArrayList<String> intakeList = IntakeBasedMethod.getIntake();
        
        for (String intake : intakeList){
            String assessment = IntakeBasedMethod.getAssessment(intake);
            
            if (!assessment.equals("-")) {
                Object[] InsertRow = {intake, assessment};

                DefaultTableModel model = (DefaultTableModel) IntakeAssTable.getModel();
                model.addRow(InsertRow);
            }
        }
        
        /*Show the intake haven't been alloted assesment*/
        for (String intake : intakeList){
            String assessment = IntakeBasedMethod.getAssessment(intake);
            
            if (assessment.equals("-")) {
                Object[] InsertRow = {intake, assessment};

                DefaultTableModel model = (DefaultTableModel) IntakeAssTable.getModel();
                model.addRow(InsertRow);
            }
        }
        
        /*Set the edit button and its function*/
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                //Get the student id of selected student
                String selectedIntake = (String) IntakeAssTable.getValueAt(row, 0);
                mainFrame.changedTab(9);
//                mainFrame.createStuAccMgmtPane(mainFrame, selectedIntake);
//                int tabIndex = mainFrame.TabPanel.getTabCount();
//                mainFrame.changedTab(tabIndex-1);
            }
        };
        
        //Insert edit button into table
        IntakeAssTable.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender_ViewIcon());
        IntakeAssTable.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor_ViewIcon(event));
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
        IntakeAssTable = new javax.swing.JTable();
        TabTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IntakeAssTable.setBackground(new java.awt.Color(236, 236, 236));
        IntakeAssTable.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        IntakeAssTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Intake", "Assessment", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        IntakeAssTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        IntakeAssTable.setRowHeight(40);
        jScrollPane1.setViewportView(IntakeAssTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 70, 886, 460));

        TabTitle.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        TabTitle.setText("Student Intake");
        add(TabTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JTable IntakeAssTable;
    private javax.swing.JLabel TabTitle;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}