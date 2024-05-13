package StuPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ReportData.txt", true))) {
            // Write the input to the file
            writer.write(input);
            writer.newLine();
            System.out.println("Data written to ReportData.txt successfully.");
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EditBtn = new javax.swing.JButton();
        SubStatus = new javax.swing.JLabel();
        GradeStatus = new javax.swing.JLabel();
        SubDeadLine = new javax.swing.JLabel();
        SubDate = new javax.swing.JLabel();
        SubLink = new javax.swing.JLabel();
        SubFeedback = new javax.swing.JLabel();
        Assessment = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(935, 530));
        setMinimumSize(new java.awt.Dimension(935, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Submission Status");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel2.setText("Grading Status");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jLabel4.setText("Submission Date");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabel5.setText("Submission Due Date");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        jLabel6.setText("Submission Feedback");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, -1, -1));

        jLabel7.setText("Submission Link");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));

        EditBtn.setText("Edit Submission");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        add(EditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, -1, -1));

        SubStatus.setText("SubStatus");
        add(SubStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        GradeStatus.setText("GradeStatus");
        add(GradeStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        SubDeadLine.setText("SubDeadLine");
        add(SubDeadLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        SubDate.setText("SubDate");
        add(SubDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, -1));

        SubLink.setText("SubLink");
        add(SubLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        SubFeedback.setText("SubFeedback");
        add(SubFeedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        Assessment.setText("Assessment");
        add(Assessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        jLabel3.setText("Assessment");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // Create a dialog to get user input
        String input = JOptionPane.showInputDialog(this, "Enter your report data:");

        // Check if the user input is not null (i.e., the user didn't cancel)
        if (input != null && !input.isEmpty()) {
            // Proceed to save the input to ReportData.txt
            saveSubmissionLink(input);
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
    // End of variables declaration//GEN-END:variables
}
