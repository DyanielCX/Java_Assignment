
package assignment_ood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Supervisor_ViewSupervisee extends javax.swing.JPanel {

    private Lecture_mainframe lectmainframe;

    public Supervisor_ViewSupervisee(Lecture_mainframe lectmainframe) {
        this.lectmainframe = lectmainframe;
        initComponents();
    }
    
    public void populatePresentationTable(JTable Supervisor_Supervisee_Table, String supervisor) {
        DefaultTableModel model = (DefaultTableModel) Supervisor_Supervisee_Table.getModel();

        model.setRowCount(0); // Clear existing rows in the table model

        // Read data from StuData.txt file
        try (BufferedReader reader = new BufferedReader(new FileReader("StuData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading Line:" + line);
                String[] parts = line.split(",");

                // Check if Supervisor is "Shahab"
                if (parts.length >= 9 && parts[6].trim().equalsIgnoreCase(supervisor)) {
                    System.out.println("Supervisor: " + parts[6]);
                    // Add only required data to the table model
                    model.addRow(new Object[]{parts[0], parts[2], parts[3], parts[4], parts[5]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading Student data file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Supervisor_Supervisee_Table = new javax.swing.JTable();

        Supervisor_Supervisee_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Age", "Intake", "Assessment"
            }
        ));
        jScrollPane1.setViewportView(Supervisor_Supervisee_Table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Supervisor_Supervisee_Table;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

