/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Lecturer_Package;

import Java_Assignment.Session;
import ProjManagerPackage.StuAssesElem.TableActionCellEditor_EditButton;
import ProjManagerPackage.StuAssesElem.TableActionCellRender_EditButton;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import ProjManagerPackage.StuAssesElem.TableActionEvent_EditButton;

/**
 *
 * @author User
 */
public class presentationReq extends javax.swing.JPanel {
private Lecture_mainframe lectmainframe;
    /**
     * Creates new form presentationReq
     */
    public presentationReq(Lecture_mainframe lectmainframe) {
        this.lectmainframe = lectmainframe;
        initComponents();
        populatePresentationTable(presentationTable,Session.getUserID());
        
        
     
        presentationTable.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender_EditButton());
        presentationTable.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor_EditButton(event));
        


    }
    
 TableActionEvent_EditButton event = new TableActionEvent_EditButton() {
    @Override
    public void onEdit(int row) {
        int selectedRow = presentationTable.convertRowIndexToModel(presentationTable.getSelectedRow());
        if (selectedRow != -1) {
            String currentStatus = (String) presentationTable.getValueAt(selectedRow, 5);

            // If the current status is "Rejected"
            if (currentStatus.equals("Rejected")) {
                // Display an input dialog for the reason
                String reason = JOptionPane.showInputDialog(presentationTable, "Enter the reason for rejection:");
                if (reason != null && !reason.isEmpty()) {
                    // Update the status and reason in the table
                    presentationTable.setValueAt(currentStatus + ": " + reason, selectedRow, 5);
                    presentationTable.setValueAt(reason, selectedRow, 6);

                    // Update the status and reason in the file
                    String[] parts = presentationTable.getValueAt(selectedRow, 5).toString().split(": ");
                    String newStatus = parts[0];
                    Admin.updateStatusInFile(selectedRow, newStatus, reason);
                } else {
                    // If the reason is empty or null, show a message
                    JOptionPane.showMessageDialog(presentationTable, "Reason for rejection is required.");
                }
            } else {
                // If the status is not "Rejected", proceed with the regular status editing
                String[] statusOptions = {"Pending", "Rejected", "Accepted"};
                JComboBox<String> cbStatus = new JComboBox<>(statusOptions);
                cbStatus.setSelectedItem(currentStatus);

                int option = JOptionPane.showConfirmDialog(presentationTable, cbStatus, "Edit Status", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String newStatus = (String) cbStatus.getSelectedItem();
                    presentationTable.setValueAt(newStatus, selectedRow, 5);
                    presentationTable.setValueAt("-", selectedRow, 6); // Set reason to "-"
                    Admin.updateStatusInFile(selectedRow, newStatus, "-"); // Set reason to "-"
                }
            }
        } else {
            JOptionPane.showMessageDialog(presentationTable, "Please select a row to edit.");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        presentationTable = new javax.swing.JTable();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/leftArrow(Black).png"))); // NOI18N
        jLabel1.setText("Back");

        presentationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student", "Lecturer", "Course", "Date", "Time", "Status", "Reason", "Action"
            }
        ));
        presentationTable.setRowHeight(50);
        jScrollPane1.setViewportView(presentationTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
public void populatePresentationTable(JTable presentationTable,String supervisor) {
    DefaultTableModel model = (DefaultTableModel) presentationTable.getModel();

    model.setRowCount(0); 
    // Clear existing rows in the table model
    model.setRowCount(0);

    // Read data from presentation_data.txt file
   try (BufferedReader reader = new BufferedReader(new FileReader("PresentationData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            
            String[] parts = line.split(",");

            
           if (parts.length >= 7 && parts[1].trim().equalsIgnoreCase(supervisor)) {

    model.addRow(new Object[]{parts[0], parts[1], parts[2], parts[3],parts[4],parts[5],parts[6]});
}
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error reading presentation data file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}







    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable presentationTable;
    // End of variables declaration//GEN-END:variables
}