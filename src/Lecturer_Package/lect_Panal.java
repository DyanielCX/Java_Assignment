/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Lecturer_Package;

import AdminPackage.addLect;
import ProjManagerPackage.StuAssesElem.ModernScrollBarUI;
import ProjManagerPackage.StuAssesElem.TableActionCellEditor_EditButton;
import ProjManagerPackage.StuAssesElem.TableActionCellRender_EditButton;
import ProjManagerPackage.StuAssesElem.TableHeader;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Lecturer_Package.Admin;
import ProjManagerPackage.StuAssesElem.TableActionEvent_EditButton;
import AdminPackage.Admin_MainFrame;
/**
 *
 * @author User
 */
public class lect_Panal extends javax.swing.JPanel {

    /**
     
     */
    private Admin_MainFrame mainframe;
    public lect_Panal(Admin_MainFrame mainframe) {
        this.mainframe = mainframe;
        initComponents();
        Admin admin = new Admin(lecturePanal);
         
         Admin.loadLecturerpanalFromFile(lecturePanal);
        
         fixTable(jScrollPane1);
          
         
         lecturePanal.getTableHeader().setReorderingAllowed(false);
        lecturePanal.getTableHeader().setResizingAllowed(false);
        lecturePanal.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(o + "");
                return header;
            }
        });
          lecturePanal.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender_EditButton());
        lecturePanal.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor_EditButton(event));
    }
    
    TableActionEvent_EditButton event = new TableActionEvent_EditButton() {
           @Override
            public void onEdit(int row) {
                //Get the student id of selected student
                
                 int selectedRow = lecturePanal.getSelectedRow();
        if (selectedRow != -1) {
            String lecturerName = (String) lecturePanal.getValueAt(selectedRow, 0);
            String lecturerId = (String) lecturePanal.getValueAt(selectedRow, 1);
            boolean isProjectManager = (boolean) lecturePanal.getValueAt(selectedRow, 2);
            String password = (String) lecturePanal.getValueAt(selectedRow, 3);
            // Display a dialog to edit the lecturer details
            JTextField txtLecturerName = new JTextField(lecturerName);
            JTextField txtLecturerId = new JTextField(lecturerId);
            JTextField txtPassword = new JTextField(password);
            JCheckBox chkIsProjectManager = new JCheckBox("Is Project Manager", isProjectManager);

            Object[] message = {
                "Lecturer Name:", txtLecturerName,
                "Lecturer ID:", txtLecturerId,
                "Password",txtPassword,
                chkIsProjectManager
            };

            int option = JOptionPane.showConfirmDialog(lect_Panal.this, message, "Edit Lecturer", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String newLecturerName = txtLecturerName.getText();
                String newLecturerId = txtLecturerId.getText();
                boolean newIsProjectManager = chkIsProjectManager.isSelected();
                boolean isSecondMarker = false;
                boolean isSupervisor =false;
                String newPassword = txtPassword.getText();
                // Update the JTable with the modified details
                lecturePanal.setValueAt(newLecturerName, selectedRow, 0);
                lecturePanal.setValueAt(newLecturerId, selectedRow, 1);
                lecturePanal.setValueAt(newIsProjectManager, selectedRow, 2);
                lecturePanal.setValueAt(newPassword, selectedRow, 3);
                // Update the file with the modified details
               Admin.updateLecturerInFile(lecturePanal, newLecturerName, newLecturerId, newIsProjectManager, isSecondMarker, isSupervisor, newPassword, selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(lect_Panal.this, "Please select a lecturer to edit.");
        }

                
               
                
            }
            };
    

 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btbNewLect = new javax.swing.JPanel();
        lblNewLect = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lecturePanal = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btbNewLect.setBackground(new java.awt.Color(255, 255, 255));
        btbNewLect.setForeground(new java.awt.Color(255, 255, 255));
        btbNewLect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbNewLectMouseClicked(evt);
            }
        });

        lblNewLect.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        lblNewLect.setForeground(new java.awt.Color(0, 0, 0));
        lblNewLect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AdminAddBtb.png"))); // NOI18N
        lblNewLect.setText("New");
        lblNewLect.setIconTextGap(12);

        javax.swing.GroupLayout btbNewLectLayout = new javax.swing.GroupLayout(btbNewLect);
        btbNewLect.setLayout(btbNewLectLayout);
        btbNewLectLayout.setHorizontalGroup(
            btbNewLectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btbNewLectLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(lblNewLect, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        btbNewLectLayout.setVerticalGroup(
            btbNewLectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btbNewLectLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblNewLect))
        );

        add(btbNewLect, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 150, 30));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Lecturers");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel1)
                .addContainerGap(508, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 50));

        lecturePanal.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lecturePanal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "project Manager", "password", "Supervisseess", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lecturePanal.setMinimumSize(new java.awt.Dimension(60, 90));
        lecturePanal.setPreferredSize(new java.awt.Dimension(1000, 5000));
        lecturePanal.setRowHeight(50);
        jScrollPane1.setViewportView(lecturePanal);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 950, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void btbNewLectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbNewLectMouseClicked
        
       addLect addlect= new addLect();
        addlect.setVisible(true);
        mainframe.dispose();
    }//GEN-LAST:event_btbNewLectMouseClicked

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
    private javax.swing.JPanel btbNewLect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNewLect;
    private javax.swing.JTable lecturePanal;
    // End of variables declaration//GEN-END:variables
}
