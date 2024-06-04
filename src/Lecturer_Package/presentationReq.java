/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Lecturer_Package;

import Java_Assignment.Session;
import ProjManagerPackage.AccMgmtElem.TableHeader_AccTbl;
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
import StuPackage.Student;
import StuPackage.*;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author User
 */
public class presentationReq extends javax.swing.JPanel {
private Lecture_mainframe lectmainframe;
private List<Lecturer> lecturers;
private List<Student> studentList;
    /**
     * Creates new form presentationReq
     */
    public presentationReq(Lecture_mainframe lectmainframe) {
        this.lectmainframe = lectmainframe;
        initComponents();
        StuData_IO.readFrTxt();
            studentList = StuData_IO.StuData;
            if (studentList == null || studentList.isEmpty()) {
                System.out.println("No student data found.");
            } else {
                System.out.println("Student data loaded successfully.");
            }
        populatePresentationTable(presentationTable,Session.getUserID());
        
         presentationTable.getTableHeader().setReorderingAllowed(false);
        presentationTable.getTableHeader().setResizingAllowed(false);
        presentationTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_AccTbl header = new TableHeader_AccTbl(o + "");
                return header;
            }
        });
     
        presentationTable.getColumnModel().getColumn(10).setCellRenderer(new TableActionCellRender_EditButton());
        presentationTable.getColumnModel().getColumn(10).setCellEditor(new TableActionCellEditor_EditButton(event));
        


    }
    
private TableActionEvent_EditButton event = new TableActionEvent_EditButton() {
    @Override
    public void onEdit(int row) {
        int selectedRow = presentationTable.convertRowIndexToModel(row);
        if (selectedRow != -1) {
            String userName = Session.getUserID(); // Get the logged-in user
            String studentID = (String) presentationTable.getValueAt(selectedRow, 0); // Get the student ID
            String role = null;
            String currentStatus = null;
            int statusColumnIndex = -1;

            // Determine the role and current status
            for (Student student : studentList) {
                if (student.getId().equals(studentID)) {
                    if (student.getSupervisor().equals(userName)) {
                        role = "supervisor";
                        currentStatus = (String) presentationTable.getValueAt(selectedRow, 8); // Supervisor Status
                        statusColumnIndex = 8;
                    } else if (student.getSecondMarker().equals(userName)) {
                        String supervisorStatus = (String) presentationTable.getValueAt(selectedRow, 8); // Supervisor Status
                        if (!supervisorStatus.equalsIgnoreCase("Accepted")) {
                            JOptionPane.showMessageDialog(presentationTable, "Supervisor must accept the presentation first.");
                            return;
                        }
                        role = "second_marker";
                        currentStatus = (String) presentationTable.getValueAt(selectedRow, 9); // Second Marker Status
                        statusColumnIndex = 9;
                    }
                    break;
                }
            }

            if (role == null) {
                JOptionPane.showMessageDialog(presentationTable, "You are not authorized to edit this entry.");
                return;
            }

            // Combo box for selecting the status
            String[] options = {"Pending", "Accepted", "Rejected"};
            JComboBox<String> statusComboBox = new JComboBox<>(options);
            statusComboBox.setSelectedItem(currentStatus);

            int option = JOptionPane.showOptionDialog(presentationTable, statusComboBox, "Select Status", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (option == JOptionPane.OK_OPTION) {
                String newStatus = (String) statusComboBox.getSelectedItem();
                String reason = "-";
                if (newStatus.equalsIgnoreCase("Rejected")) {
                    reason = JOptionPane.showInputDialog(presentationTable, "Enter reason for rejection:", "");
                    if (reason == null || reason.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(presentationTable, "Reason for rejection is required.");
                        return;
                    }
                }
                presentationTable.setValueAt(newStatus.trim(), selectedRow, statusColumnIndex);
                presentationTable.setValueAt(reason, selectedRow, 6); 
                Admin.updateStatusInFile(studentID, newStatus.trim(), reason, role); 
                populatePresentationTable(presentationTable, Session.getUserID()); 

            } else {
                JOptionPane.showMessageDialog(presentationTable, "No status selected.");
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        presentationTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Back_lbl = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/leftArrow(Black).png"))); // NOI18N
        jLabel1.setText("Back");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        presentationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student", "Supervisor", "Course", "Date", "Time", "Student Status", "Reason", "Second marker", "Supervisor Status", "2nd marker Status", "Action"
            }
        ));
        presentationTable.setRowHeight(50);
        jScrollPane1.setViewportView(presentationTable);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Prensentation Table");

        Back_lbl.setForeground(new java.awt.Color(0, 0, 0));
        Back_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        Back_lbl.setText("Back");
        Back_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Back_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Back_lblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(Back_lbl)
                .addGap(272, 272, 272)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Back_lbl)
                    .addComponent(jLabel2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Back_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_lblMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        lectmainframe.changeTab(5);
    }//GEN-LAST:event_Back_lblMouseClicked
public void populatePresentationTable(JTable presentationTable, String loggedInUser) {
    DefaultTableModel model = (DefaultTableModel) presentationTable.getModel();

    // Clear existing rows in the table model
    model.setRowCount(0);

    // Read data from PresentationData.txt file
    try (BufferedReader reader = new BufferedReader(new FileReader("PresentationData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");

            if (parts.length >= 10) {
                boolean isSupervisor = parts[1].trim().equalsIgnoreCase(loggedInUser);
                boolean isSecondMarker = parts[7].trim().equalsIgnoreCase(loggedInUser);
                boolean supervisorAccepted = parts[8].trim().equalsIgnoreCase("Accepted");

                if (isSupervisor || (isSecondMarker && supervisorAccepted)) {
                    model.addRow(new Object[]{parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9]});
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error reading presentation data file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}







    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable presentationTable;
    // End of variables declaration//GEN-END:variables
}
