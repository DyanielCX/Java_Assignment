/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package assignment_ood;

import ProjManagerPackage.StuAsseTabElement.ModernScrollBarUI;
import ProjManagerPackage.StuAsseTabElement.TableActionCellEditor;
import ProjManagerPackage.StuAsseTabElement.TableActionCellRender;
import ProjManagerPackage.StuAsseTabElement.TableActionEvent;
import ProjManagerPackage.StuAsseTabElement.TableHeader;
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
/**
 *
 * @author User
 */
public class lect_Panal extends javax.swing.JPanel {

    /**
     
     */
    private admin_mainframe2 mainframe;
    public lect_Panal(admin_mainframe2 mainframe) {
        this.mainframe = mainframe;
        initComponents();
         populateLecturerTable();
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
          lecturePanal.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        lecturePanal.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }
    private void updateLecturerInFile(String lecturerName, String lecturerId, boolean isProjectManager) {
    // Read all lines from the file into a list
    java.util.List<String> lines = new java.util.ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("lecturers.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    } catch (IOException e) {
        
        e.printStackTrace();
    }

    // Update the selected lecturer's details
    String updatedLine = lecturerName + "," + lecturerId + "," + isProjectManager;
    int selectedIndex = lecturePanal.getSelectedRow();
    if (selectedIndex != -1 && selectedIndex < lines.size()) {
        lines.set(selectedIndex, updatedLine);
    }

    
     
    
    }
    TableActionEvent event = new TableActionEvent() {
           @Override
            public void onEdit(int row) {
                //Get the student id of selected student
                
                 int selectedRow = lecturePanal.getSelectedRow();
        if (selectedRow != -1) {
            String lecturerName = (String) lecturePanal.getValueAt(selectedRow, 0);
            String lecturerId = (String) lecturePanal.getValueAt(selectedRow, 1);
            boolean isProjectManager = (boolean) lecturePanal.getValueAt(selectedRow, 2);

            // Display a dialog to edit the lecturer details
            JTextField txtLecturerName = new JTextField(lecturerName);
            JTextField txtLecturerId = new JTextField(lecturerId);
            JCheckBox chkIsProjectManager = new JCheckBox("Is Project Manager", isProjectManager);

            Object[] message = {
                "Lecturer Name:", txtLecturerName,
                "Lecturer ID:", txtLecturerId,
                chkIsProjectManager
            };

            int option = JOptionPane.showConfirmDialog(lect_Panal.this, message, "Edit Lecturer", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String newLecturerName = txtLecturerName.getText();
                String newLecturerId = txtLecturerId.getText();
                boolean newIsProjectManager = chkIsProjectManager.isSelected();

                // Update the JTable with the modified details
                lecturePanal.setValueAt(newLecturerName, selectedRow, 0);
                lecturePanal.setValueAt(newLecturerId, selectedRow, 1);
                lecturePanal.setValueAt(newIsProjectManager, selectedRow, 2);

                // Update the file with the modified details
                updateLecturerInFile(newLecturerName, newLecturerId, newIsProjectManager);
            }
        } else {
            JOptionPane.showMessageDialog(lect_Panal.this, "Please select a lecturer to edit.");
        }

                
               
                
            }
            };
    
private void populateLecturerTable() {
       DefaultTableModel model = (DefaultTableModel) lecturePanal.getModel();
    model.setRowCount(0); 

    try (BufferedReader reader = new BufferedReader(new FileReader("lecturers.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String lecturerName = parts[0];
                String lecturerId = parts[1];
                boolean isProjectManager = Boolean.parseBoolean(parts[2]);
                model.addRow(new Object[]{lecturerName, lecturerId, isProjectManager});
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); // Handle or log the exception as needed
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
        lecturePanal = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecturePanal.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lecturePanal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "ID", "project Manager", "Supervisseess", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lecturePanal.setMinimumSize(new java.awt.Dimension(60, 90));
        lecturePanal.setPreferredSize(new java.awt.Dimension(1000, 5000));
        lecturePanal.setRowHeight(50);
        jScrollPane1.setViewportView(lecturePanal);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 780, -1));
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lecturePanal;
    // End of variables declaration//GEN-END:variables
}
