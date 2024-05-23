package StuPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PanelSchedule extends javax.swing.JPanel {
    private String username; // Declare as an instance variable
    private String password;

    public PanelSchedule(String username, String password) {
        initComponents();
        this.username = username; // Assign the parameter value to the instance variable
        this.password = password; 
        
        readPresentationDetailsFromFile("PresentationData.txt");
        readConsultationDetailsFromFile("ConsultationData.txt");
    }
    
    private void readPresentationDetailsFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].trim().equals(username)) { 
                    PreDate.setText(parts[3].trim());
                    PreTime.setText(parts[4].trim());
                    PreLec.setText(parts[1].trim());
                    return; // Exit the loop once the user is found
                }
            }
            // If the loop completes without finding the user
            System.err.println("User not found in the file.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    
    private void readConsultationDetailsFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].trim().equals(username)) { 
                    ConDate.setText(parts[3].trim());
                    ConTime.setText(parts[4].trim());
                    ConLec.setText(parts[1].trim());
                    return; // Exit the loop once the user is found
                }
            }
            // If the loop completes without finding the user
            System.err.println("User not found in the file.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ConDate = new javax.swing.JLabel();
        ConTime = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ConLec = new javax.swing.JLabel();
        PresentationSchedule = new javax.swing.JPanel();
        PreDate = new javax.swing.JLabel();
        PreTime = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PreLec = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(935, 530));
        setMinimumSize(new java.awt.Dimension(935, 530));
        setPreferredSize(new java.awt.Dimension(935, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Upcoming Scedule");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 340, 50));

        jPanel2.setBackground(new java.awt.Color(226, 226, 226));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ConDate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ConDate.setForeground(new java.awt.Color(102, 102, 102));
        ConDate.setText("Date");
        jPanel2.add(ConDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        ConTime.setText("Current Assesment");
        jPanel2.add(ConTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Consultation Scheduule");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/time.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 30));

        ConLec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LecSup.png"))); // NOI18N
        ConLec.setText("Supervisor / Lecturer");
        jPanel2.add(ConLec, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 750, 160));

        PresentationSchedule.setBackground(new java.awt.Color(226, 226, 226));
        PresentationSchedule.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PresentationSchedule.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PreDate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PreDate.setForeground(new java.awt.Color(102, 102, 102));
        PreDate.setText("Date");
        PresentationSchedule.add(PreDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        PreTime.setText("Current Assesment");
        PresentationSchedule.add(PreTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Presentation Schedule");
        PresentationSchedule.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/time.png"))); // NOI18N
        PresentationSchedule.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 30));

        PreLec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LecSup.png"))); // NOI18N
        PreLec.setText("Supervisor / Lecturer");
        PresentationSchedule.add(PreLec, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jPanel1.add(PresentationSchedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 750, 160));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 870, 470));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConDate;
    private javax.swing.JLabel ConLec;
    private javax.swing.JLabel ConTime;
    private javax.swing.JLabel PreDate;
    private javax.swing.JLabel PreLec;
    private javax.swing.JLabel PreTime;
    private javax.swing.JPanel PresentationSchedule;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
