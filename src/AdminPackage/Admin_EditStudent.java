package AdminPackage;

import StuPackage.StuData_IO;
import StuPackage.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;


public class Admin_EditStudent extends javax.swing.JFrame {

    private final String filePath = "StuData.txt";

    public Admin_EditStudent(String studentID, String name, int age, String intake, String assessment, String supervisor, String secondMarker, String RMCP_lecture) {
         initComponents();
        setVisible(true);
        StudentID_textfield.setText(studentID);
        StudentName_textfield.setText(name);
        StudentAge_textfield.setText(String.valueOf(age));
        StudentIntake_textfield.setText(intake);
        StudentAssessment_textfield.setText(assessment);
        StudentSupervisor_textfield.setText(supervisor);
        StudentSecMarker_textfield.setText(secondMarker);
        RMCPlecture_textfield.setText(RMCP_lecture);
        StudentID_textfield.setEditable(false);
    }

     // Method to fill student details based on the provided student ID
    private void fillStudentDetails(String studentID) {
         // Path to the text file
        String filePath = "StuData.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line in the file
            while ((line = br.readLine()) != null) {
                // Split the line by commas to get student details
                String[] parts = line.split(",");
                // Check if the first part (Student ID) matches the provided ID
                if (parts[2].equals(studentID)) {
                    // Fill the text fields with student details
                    StudentName_textfield.setText(parts[0]); // Student name
                    StudentAge_textfield.setText(parts[1]); // Student age
                    StudentIntake_textfield.setText(parts[3]); // Student intake
                    StudentAssessment_textfield.setText(parts[4]); // Student assessment
                    StudentSupervisor_textfield.setText(parts[5]); // Student supervisor
                    StudentSecMarker_textfield.setText(parts[6]); // Student second marker
                    RMCPlecture_textfield.setText(parts[7]);
                    break; // Once found, exit the loop
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     private void updateStudentDetails() {
         // Check if any field is empty
        if (StudentName_textfield.getText().isEmpty() || 
            StudentAge_textfield.getText().isEmpty() ||
            StudentIntake_textfield.getText().isEmpty() ||
            StudentAssessment_textfield.getText().isEmpty() ||
            StudentSupervisor_textfield.getText().isEmpty() ||
            StudentSecMarker_textfield.getText().isEmpty() ||
            RMCPlecture_textfield.getText().isEmpty()) {

            // Display an error message if any field is empty
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method
        }

        String editedID = StudentID_textfield.getText(); // Get the ID from the text field
        boolean updated = false;
        for (int Index = 0; Index < StuData_IO.StuData.size(); Index++) {
            if (StuData_IO.StuData.get(Index).id.equals(editedID)) {
                // Get the edited details
                String Name = StudentName_textfield.getText();
                int Age = Integer.parseInt(StudentAge_textfield.getText());
                String Intake = StudentIntake_textfield.getText();
                String Assessment = StudentAssessment_textfield.getText();
                String Supervisor = StudentSupervisor_textfield.getText();
                String SecondMaker = StudentSecMarker_textfield.getText();
                String RMCP_Lecture = RMCPlecture_textfield.getText();
                String Password = StuData_IO.StuData.get(Index).password; // Keep the old password

                // Update the edited data into ArrayList
                Student Edited_Student = new Student(Name, Age, editedID, Intake, Assessment, Supervisor, SecondMaker, RMCP_Lecture, Password);
                StuData_IO.edit(Index, Edited_Student);

                updated = true; // Set the flag to true to indicate successful update
                break; // Exit the loop after editing
            }
        }

        // Check if the update was successful
        if (updated) {
            JOptionPane.showMessageDialog(this, "Student details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            Admin_Student adminStudentFrame = new Admin_Student();
            adminStudentFrame.setVisible(true);
            dispose();
        } else {
            // If the student with the provided ID was not found
            JOptionPane.showMessageDialog(this, "Student ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Back_lbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        StudentName_textfield = new javax.swing.JTextField();
        StudentAge_textfield = new javax.swing.JTextField();
        EditBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        StudentID_textfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        StudentIntake_textfield = new javax.swing.JTextField();
        StudentAssessment_textfield = new javax.swing.JTextField();
        StudentSupervisor_textfield = new javax.swing.JTextField();
        StudentSecMarker_textfield = new javax.swing.JTextField();
        RMCPlecture_textfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel9.setText("Edit Student");

        Back_lbl.setText("Back");
        Back_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Back_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Back_lblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Back_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(jLabel9)
                .addContainerGap(251, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Back_lbl)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel3.setText("Student Name");

        jLabel4.setText("Student Age");

        jLabel5.setText("Student Intake");

        jLabel6.setText("Student Assessment");

        jLabel7.setText("Student Supervisor");

        jLabel8.setText("Student Second Marker");

        StudentName_textfield.setText("jTextField1");

        StudentAge_textfield.setText("jTextField2");
        StudentAge_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentAge_textfieldActionPerformed(evt);
            }
        });

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        jLabel10.setText("Student ID");

        jLabel1.setText("RMCP Lecturer");

        StudentIntake_textfield.setText("jTextField2");

        StudentAssessment_textfield.setText("jTextField2");

        StudentSupervisor_textfield.setText("jTextField2");

        StudentSecMarker_textfield.setText("jTextField2");

        RMCPlecture_textfield.setText("jTextField2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StudentID_textfield)
                                    .addComponent(StudentName_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(StudentAssessment_textfield)
                                    .addComponent(StudentIntake_textfield))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(StudentAge_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StudentSupervisor_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(StudentSecMarker_textfield)
                    .addComponent(RMCPlecture_textfield))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(StudentID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(StudentName_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(StudentAge_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(StudentIntake_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(StudentAssessment_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(StudentSupervisor_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(StudentSecMarker_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(RMCPlecture_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(EditBtn)
                .addGap(36, 36, 36))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
     updateStudentDetails();

    }//GEN-LAST:event_EditBtnActionPerformed

    private void Back_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_lblMouseClicked
        Admin_Student adminStudentFrame = new Admin_Student();
        adminStudentFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Back_lblMouseClicked

    private void StudentAge_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentAge_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentAge_textfieldActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back_lbl;
    private javax.swing.JButton EditBtn;
    private javax.swing.JTextField RMCPlecture_textfield;
    private javax.swing.JTextField StudentAge_textfield;
    private javax.swing.JTextField StudentAssessment_textfield;
    private javax.swing.JTextField StudentID_textfield;
    private javax.swing.JTextField StudentIntake_textfield;
    private javax.swing.JTextField StudentName_textfield;
    private javax.swing.JTextField StudentSecMarker_textfield;
    private javax.swing.JTextField StudentSupervisor_textfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
