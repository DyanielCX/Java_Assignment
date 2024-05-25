package StuPackage;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class PanelReport extends javax.swing.JPanel {
    private String username; // Declare as an instance variable
    private String password;
    
    public PanelReport(String username, String password) {
        initComponents();
        this.username = username; // Assign the parameter value to the instance variable
        this.password = password; 
        
        readReportDetailsFromFile("ReportData.txt");
    }

    private void readReportDetailsFromFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].trim().equals(username)) { 
                Assessment.setText(parts[1].trim());
                SubStatus.setText(parts[2].trim());
                GradeStatus.setText(parts[3].trim());
                SubDeadLine.setText(parts[4].trim());
                SubDate.setText(parts[5].trim());
                SubLink.setText(parts[6].trim());
                SubFeedback.setText(parts[7].trim());
                return; // Exit the loop once the user is found
            }
        }
        // If the loop completes without finding the user
        System.err.println("User not found in the file.");
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}
    private void saveSubmissionLink(String input) {
        String fileName = "ReportData.txt";
        List<String> fileContents = new ArrayList<>();
        boolean userFound = false;
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);


        // Read the file contents into a list
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].trim().equals(username)) {
                    parts[2] = "Submit for grading";
                    parts[3] = "Not Graded";
                    parts[5] = formattedDate;
                    parts[6] = input; // Replace the SubLink (part 6) with the input
                    line = String.join(",", parts);
                    userFound = true;
                }
                fileContents.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        if (userFound) {
            // Write the updated contents back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (String line : fileContents) {
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("Data written to ReportData.txt successfully.");
            } catch (IOException ex) {
                System.err.println("Error writing to file: " + ex.getMessage());
            }
        } else {
            System.err.println("User not found in the file.");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EditBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        SubLink = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        SubFeedback = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        Assessment = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        SubStatus = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        GradeStatus = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        SubDeadLine = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        SubDate = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(935, 530));
        setMinimumSize(new java.awt.Dimension(935, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EditBtn.setBackground(new java.awt.Color(255, 255, 255));
        EditBtn.setForeground(new java.awt.Color(0, 0, 0));
        EditBtn.setText("Edit Submission");
        EditBtn.setBorder(null);
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        add(EditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 120, 40));

        jPanel1.setMaximumSize(new java.awt.Dimension(170, 98));
        jPanel1.setMinimumSize(new java.awt.Dimension(170, 98));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 98));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel2.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Submission Link");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 190, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel3.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel6.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 360, 70));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Submission Feedback");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 190, 60));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel4.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubLink.setText("SubLink");
        jPanel4.add(SubLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 710, 60));

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));
        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel5.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubFeedback.setText("SubFeedback");
        jPanel5.add(SubFeedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 710, 60));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel7.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel8.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 360, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Grading Status");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 190, 60));

        jPanel9.setBackground(new java.awt.Color(245, 245, 245));
        jPanel9.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel9.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Submission Due Date");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 60));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel10.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel11.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 360, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Submission Date");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 190, 60));

        jPanel12.setBackground(new java.awt.Color(245, 245, 245));
        jPanel12.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel12.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Submission Status");
        jPanel12.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 60));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel13.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Assessment");
        jPanel13.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        jPanel14.setBackground(new java.awt.Color(245, 245, 245));
        jPanel14.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel14.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Assessment.setText("Assessment");
        jPanel14.add(Assessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 710, 60));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel15.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubStatus.setText("SubStatus");
        jPanel15.add(SubStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 710, 60));

        jPanel16.setBackground(new java.awt.Color(245, 245, 245));
        jPanel16.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel16.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GradeStatus.setText("GradeStatus");
        jPanel16.add(GradeStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 710, 60));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel17.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubDeadLine.setText("SubDeadLine");
        jPanel17.add(SubDeadLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 710, 60));

        jPanel18.setBackground(new java.awt.Color(245, 245, 245));
        jPanel18.setMaximumSize(new java.awt.Dimension(32767, 14));
        jPanel18.setMinimumSize(new java.awt.Dimension(10, 14));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubDate.setText("SubDate");
        jPanel18.add(SubDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 710, 60));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 880, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // Create a dialog to get user input
        String input = JOptionPane.showInputDialog(this, "Enter your submission link");

        // Check if the user input is not null (i.e., the user didn't cancel)
        if (input != null && !input.isEmpty()) {
            // Proceed to save the input to ReportData.txt
            saveSubmissionLink(input);
            readReportDetailsFromFile("ReportData.txt");
            
            JOptionPane.showMessageDialog(null, "Your submission link has been submitted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_EditBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Assessment;
    private javax.swing.JButton EditBtn;
    private javax.swing.JLabel GradeStatus;
    private javax.swing.JLabel SubDate;
    private javax.swing.JLabel SubDeadLine;
    private javax.swing.JLabel SubFeedback;
    private javax.swing.JLabel SubLink;
    private javax.swing.JLabel SubStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
