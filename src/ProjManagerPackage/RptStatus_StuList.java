/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProjManagerPackage;

import ProjManagerPackage.RptStatusElem.TableActionCellRender_MarkIcon;
import ProjManagerPackage.RptStatusElem.TableActionCellRender_PendingIcon;
import ProjManagerPackage.RptStatusElem.TableHeader_StuList;
import ProjManagerPackage.StuAssessElem.ModernScrollBarUI;
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


public class RptStatus_StuList extends javax.swing.JPanel {

    private MainFrame mainFrame;
    
    public RptStatus_StuList(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        
        //Customize Table Modification
        /* Set the scrollbar to customize scrollbar*/
        fixTable(jScrollPane1);
        
        /* Set the header to customize header */
        StuRptStatusTable.getTableHeader().setReorderingAllowed(false);
        StuRptStatusTable.getTableHeader().setResizingAllowed(false);
        StuRptStatusTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_StuList header = new TableHeader_StuList(o + "");
                return header;
            }
        });

        
        //Insert data into table
        /*Show the student haven't been alloted assesment*/
//        for (Student stu :StuData_IO.StuData){
//            String StuName = stu.name;
//            String StuID = stu.id;
//            String Intake = stu.intake;
//            String Assessment = stu.assessment;
//            
//            if (Assessment.equals("-")) {
//            Object[] InsertRow = {StuName, StuID, Intake, Assessment};
//
//            DefaultTableModel model = (DefaultTableModel) LectRoleTable.getModel();
//            model.addRow(InsertRow);
//            }
//        }
        
        /*Show the student have been alloted assesment*/
        for (int count = 0; count < 3; count++){
            String StuName = "John";
            String StuID = "TP111222";
            String Supervisor = "Shahab";
            String SecondMkr = "Qistina";
            String RMCP_Lect = "-";
            String RptStatus = "Mark";


            Object[] InsertRow = {StuName, StuID,Supervisor, SecondMkr, RMCP_Lect};

            DefaultTableModel model = (DefaultTableModel) StuRptStatusTable.getModel();
            model.addRow(InsertRow);
            
            if (RptStatus.equals("Mark")) {
                StuRptStatusTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender_MarkIcon());
            }
            else if(RptStatus.equals("Pending")){
                StuRptStatusTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender_PendingIcon());
            }
        }

            
            
        
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
        StuRptStatusTable = new javax.swing.JTable();
        TabTitle = new javax.swing.JLabel();
        lblAssessment = new javax.swing.JLabel();
        selectedAssessment = new javax.swing.JLabel();
        btbBack = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StuRptStatusTable.setBackground(new java.awt.Color(236, 236, 236));
        StuRptStatusTable.setFont(new java.awt.Font("Dubai Medium", 0, 17)); // NOI18N
        StuRptStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Student ID", "Supervisor", "Second Marker", "RMCP Lecturer", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StuRptStatusTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StuRptStatusTable.setRowHeight(40);
        jScrollPane1.setViewportView(StuRptStatusTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 886, 440));

        TabTitle.setFont(new java.awt.Font("Dubai Medium", 0, 28)); // NOI18N
        TabTitle.setForeground(new java.awt.Color(0, 0, 0));
        TabTitle.setText("APU2F2109");
        add(TabTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lblAssessment.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblAssessment.setForeground(new java.awt.Color(0, 0, 0));
        lblAssessment.setText("Assessment:");
        add(lblAssessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, -1));

        selectedAssessment.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        selectedAssessment.setForeground(new java.awt.Color(0, 0, 0));
        selectedAssessment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        selectedAssessment.setText("Investigation Report");
        add(selectedAssessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, -1));

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
    }// </editor-fold>//GEN-END:initComponents

    private void btbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbBackMouseClicked
        mainFrame.changedTab(8);
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
    private javax.swing.JTable StuRptStatusTable;
    private javax.swing.JLabel TabTitle;
    private javax.swing.JLabel btbBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAssessment;
    private javax.swing.JLabel selectedAssessment;
    // End of variables declaration//GEN-END:variables
}