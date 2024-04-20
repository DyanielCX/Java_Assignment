package StuPackage;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Admin_SearchStudent extends javax.swing.JFrame {

    public Admin_SearchStudent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AddStudentButton = new javax.swing.JButton();
        EditStudentButton = new javax.swing.JButton();
        RemoveStudentButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        SearchBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        StudentID_textfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        AddStudentButton.setText("Add Student");
        AddStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudentButtonActionPerformed(evt);
            }
        });

        EditStudentButton.setText("Edit Student");

        RemoveStudentButton.setText("Remove Student");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EditStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(AddStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EditStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RemoveStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel9.setText("Edit Student");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(246, 246, 246))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        SearchBtn.setText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        jLabel10.setText("Student ID");

        StudentID_textfield.setForeground(new java.awt.Color(204, 204, 204));
        StudentID_textfield.setText("Please enter the Student ID");
        StudentID_textfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                StudentID_textfieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                StudentID_textfieldFocusLost(evt);
            }
        });
        StudentID_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentID_textfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(StudentID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(40, 40, 40)
                .addComponent(SearchBtn)
                .addGap(163, 163, 163))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStudentButtonActionPerformed
        // Create an instance of Admin_EditStudent
        Admin_AddStudent addStudentFrame = new Admin_AddStudent();

        // Hide the current frame (Admin_AddStudent)
        this.setVisible(false);

        // Show the Admin_EditStudent frame
        addStudentFrame.setVisible(true);
    }//GEN-LAST:event_AddStudentButtonActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
         // Retrieve the entered Student ID
        String studentID = StudentID_textfield.getText().trim();

        // Check if the student exists
        boolean studentExists = checkStudentExists(studentID);

        if (studentExists) {
            // Student exists, navigate to Admin_EditStudent frame
            Admin_EditStudent editStudentFrame = new Admin_EditStudent();

            // Pass the Student ID to Admin_EditStudent frame
            editStudentFrame.setStudentID(studentID);

            // Hide the current frame (Admin_SearchStudent)
            this.setVisible(false);

            // Show the Admin_EditStudent frame
            editStudentFrame.setVisible(true);
        } else {
            // Student does not exist, display an error message
            JOptionPane.showMessageDialog(this, "Student with ID " + studentID + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    // Method to check if the student exists in the StuData.txt file
    private boolean checkStudentExists(String studentID) {
        // Path to the text file
        String filePath = "StuData.txt";

        // Flag to track if the student is found
        boolean studentFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line in the file
            while ((line = br.readLine()) != null) {
                // Split the line by commas to get student details
                String[] parts = line.split(",");
                // Check if the first part (Student ID) matches the entered ID
                if (parts[2].equals(studentID)) {
                    studentFound = true; // Student found
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentFound;
    }
    
    private void StudentID_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentID_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentID_textfieldActionPerformed

    private void StudentID_textfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StudentID_textfieldFocusGained
       if (StudentID_textfield.getText().equals("Please enter the Student ID")) {
                    StudentID_textfield.setText("");
                    StudentID_textfield.setForeground(Color.BLACK);
                }
    }//GEN-LAST:event_StudentID_textfieldFocusGained

    private void StudentID_textfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StudentID_textfieldFocusLost
        if (StudentID_textfield.getText().isEmpty()) {
                    StudentID_textfield.setForeground(Color.GRAY);
                    StudentID_textfield.setText("Please enter the Student ID");
                }
    }//GEN-LAST:event_StudentID_textfieldFocusLost

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Admin_SearchStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_SearchStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_SearchStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_SearchStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_SearchStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddStudentButton;
    private javax.swing.JButton EditStudentButton;
    private javax.swing.JButton RemoveStudentButton;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField StudentID_textfield;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
