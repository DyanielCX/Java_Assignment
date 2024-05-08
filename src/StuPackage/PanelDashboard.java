package StuPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PanelDashboard extends javax.swing.JPanel {
    private String username; // Declare as an instance variable
    private String password;
    
    public PanelDashboard(String username, String password) {
        initComponents();
        this.username = username; // Assign the parameter value to the instance variable
        this.password = password; 
        
        readStudentDetailsFromFile("StuData.txt");
    }

private void readStudentDetailsFromFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].trim().equals(username)) { 
                StuID.setText(parts[0].trim());
                StuName.setText(parts[2].trim());
                StuAge.setText(parts[3].trim());
                StuIntake.setText(parts[4].trim());
                StuAssessment.setText(parts[5].trim());
                LecSupName.setText(parts[6].trim());
                return; // Exit the loop once the user is found
            }
        }
        // If the loop completes without finding the user
        System.err.println("User not found in the file.");
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        StuName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        StuAssessment = new javax.swing.JTextField();
        LecSupName = new javax.swing.JTextField();
        StuID = new javax.swing.JTextField();
        StuAge = new javax.swing.JTextField();
        StuIntake = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(935, 530));

        jPanel1.setPreferredSize(new java.awt.Dimension(935, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Student Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 155, -1, -1));

        jLabel1.setText("Student ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 195, -1, -1));

        StuName.setText("jTextField1");
        jPanel1.add(StuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 152, -1, -1));

        jLabel3.setText("Age");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 232, -1, -1));

        jLabel7.setText("Intake");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));

        jLabel8.setText("Supervisor Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 239, -1, -1));

        jLabel9.setText("Assessment");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 155, -1, -1));

        StuAssessment.setText("jTextField2");
        jPanel1.add(StuAssessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 192, -1, -1));

        LecSupName.setText("jTextField3");
        jPanel1.add(LecSupName, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 280, -1, -1));

        StuID.setText("jTextField4");
        jPanel1.add(StuID, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 192, -1, -1));

        StuAge.setText("jTextField5");
        jPanel1.add(StuAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 236, -1, -1));

        StuIntake.setText("jTextField6");
        jPanel1.add(StuIntake, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 295, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LecSupName;
    private javax.swing.JTextField StuAge;
    private javax.swing.JTextField StuAssessment;
    private javax.swing.JTextField StuID;
    private javax.swing.JTextField StuIntake;
    private javax.swing.JTextField StuName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
