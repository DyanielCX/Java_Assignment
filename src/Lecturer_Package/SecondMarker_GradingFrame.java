package Lecturer_Package;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

public class SecondMarker_GradingFrame extends javax.swing.JFrame {

    private Lecture_mainframe lectmainframe;
    private String studentId;
    
    public SecondMarker_GradingFrame(Lecture_mainframe lectmainframe, String studentId) {
        this.lectmainframe = lectmainframe;
        this.studentId = studentId;

        initComponents();
        loadStudentData();
    }
    
    private void loadStudentData() {
        // Load student data from StuData.txt
        try (BufferedReader stuReader = new BufferedReader(new FileReader("StuData.txt"))) {
            String stuLine;
            while ((stuLine = stuReader.readLine()) != null) {
                String[] stuParts = stuLine.split(",");
                if (stuParts[0].trim().equals(studentId)) {
                    StudentID_txt.setText(stuParts[0].trim());
                    Name_txt.setText(stuParts[2].trim());
                    Intake_txt.setText(stuParts[4].trim());
                    Assessment_txt.setText(stuParts[5].trim());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading Student data file.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Load report data from ReportData.txt
        try (BufferedReader reportReader = new BufferedReader(new FileReader("ReportData.txt"))) {
            String reportLine;
            while ((reportLine = reportReader.readLine()) != null) {
                String[] reportParts = reportLine.split(",");
                if (reportParts[0].trim().equals(studentId)) {
                    SubmissionLink_txt.setText(reportParts[7].trim());
                    DueDate_txt.setText(reportParts[4].trim());
                    SubmissionDate_txt.setText(reportParts[6].trim());
                    Feedback_txt.setText(reportParts[8].trim());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading Report data file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Feedback_txt = new javax.swing.JTextArea();
        StudentID_txt = new javax.swing.JTextField();
        Name_txt = new javax.swing.JTextField();
        Intake_txt = new javax.swing.JTextField();
        Assessment_txt = new javax.swing.JTextField();
        SubmissionLink_txt = new javax.swing.JTextField();
        btnDone = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        DueDate_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        SubmissionDate_txt = new javax.swing.JTextField();
        Back_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(106, 212, 221));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Grading Page");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 11, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Student ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 61, 60, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 61, 50, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Intake");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 89, 40, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Assessment");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 89, 70, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Submission Link:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 165, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Feedback");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 199, -1, -1));

        Feedback_txt.setEditable(false);
        Feedback_txt.setColumns(20);
        Feedback_txt.setForeground(new java.awt.Color(153, 153, 153));
        Feedback_txt.setRows(5);
        Feedback_txt.setText("This field only available for supervisor.");
        jScrollPane1.setViewportView(Feedback_txt);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 219, 330, -1));

        StudentID_txt.setEditable(false);
        StudentID_txt.setText("jTextField1");
        StudentID_txt.setBorder(null);
        StudentID_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentID_txtActionPerformed(evt);
            }
        });
        jPanel2.add(StudentID_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 63, -1, -1));

        Name_txt.setEditable(false);
        Name_txt.setText("jTextField2");
        Name_txt.setBorder(null);
        Name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Name_txtActionPerformed(evt);
            }
        });
        jPanel2.add(Name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 61, -1, -1));

        Intake_txt.setEditable(false);
        Intake_txt.setText("jTextField3");
        Intake_txt.setBorder(null);
        Intake_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Intake_txtActionPerformed(evt);
            }
        });
        jPanel2.add(Intake_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 91, -1, -1));

        Assessment_txt.setEditable(false);
        Assessment_txt.setText("jTextField4");
        Assessment_txt.setBorder(null);
        jPanel2.add(Assessment_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 89, -1, -1));

        SubmissionLink_txt.setEditable(false);
        SubmissionLink_txt.setText("jTextField5");
        SubmissionLink_txt.setBorder(null);
        jPanel2.add(SubmissionLink_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 165, 240, -1));

        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });
        jPanel2.add(btnDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setText("Due Date");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 117, 60, 20));

        DueDate_txt.setEditable(false);
        DueDate_txt.setText("jTextField1");
        DueDate_txt.setBorder(null);
        jPanel2.add(DueDate_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 119, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Submission ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 117, 70, 20));

        SubmissionDate_txt.setEditable(false);
        SubmissionDate_txt.setText("jTextField1");
        SubmissionDate_txt.setBorder(null);
        jPanel2.add(SubmissionDate_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Back_lbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Back_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void StudentID_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentID_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentID_txtActionPerformed

    private void Name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Name_txtActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
      // Show confirmation dialog
        int response = JOptionPane.showConfirmDialog(this, "Are you done marking?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            // Read and update the report data
            try (BufferedReader reportReader = new BufferedReader(new FileReader("ReportData.txt"))) {
                StringBuilder reportContent = new StringBuilder();
                String reportLine;

                while ((reportLine = reportReader.readLine()) != null) {
                    String[] reportParts = reportLine.split(",");
                    if (reportParts[0].trim().equals(studentId)) {
                        String currentStatus = reportParts[3].trim();
                        if (currentStatus.equals("Not Graded")) {
                            reportParts[3] = "Half Graded"; // Update status to Half Graded
                        } else if (currentStatus.equals("Half Graded")) {
                            reportParts[3] = "Graded"; // Update status to Graded
                        }
                        // If the status is "Graded", it remains unchanged
                        reportContent.append(String.join(",", reportParts)).append("\n");
                    } else {
                        reportContent.append(reportLine).append("\n");
                    }
                }

                // Write the updated report content back to the file
                Files.write(Paths.get("ReportData.txt"), reportContent.toString().getBytes());

                JOptionPane.showMessageDialog(this, "Grading status updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Navigate back to the main frame
                this.dispose(); // Close the current frame
                backMainFrame();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating grading status.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnDoneActionPerformed

    private void Intake_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Intake_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Intake_txtActionPerformed

    private void Back_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_lblMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        backMainFrame();
    }//GEN-LAST:event_Back_lblMouseClicked

    public void backMainFrame(){
         Lecture_mainframe fr = new Lecture_mainframe();
        fr.setVisible(true);

        // Switch to the appropriate tab
        fr.SecondMarker_ViewReport(fr);
        int tabIndex = fr.TabPanel.getTabCount() - 1;
        fr.changeTab(tabIndex);
        
        fr.DashboardPane.setBackground(new Color(122, 162, 227));
        fr.ViewReportPane.setBackground(new Color(106, 212, 221));
        fr.PanelTitle.setText("View Second Marker Report");
       }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecondMarker_GradingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecondMarker_GradingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecondMarker_GradingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecondMarker_GradingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Assessment_txt;
    private javax.swing.JLabel Back_lbl;
    private javax.swing.JTextField DueDate_txt;
    private javax.swing.JTextArea Feedback_txt;
    private javax.swing.JTextField Intake_txt;
    private javax.swing.JTextField Name_txt;
    private javax.swing.JTextField StudentID_txt;
    private javax.swing.JTextField SubmissionDate_txt;
    private javax.swing.JTextField SubmissionLink_txt;
    private javax.swing.JButton btnDone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
