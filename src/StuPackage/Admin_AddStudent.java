package StuPackage;



import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Admin_AddStudent extends javax.swing.JFrame {

    // ArrayList to store student details
    private ArrayList<String> studentList = new ArrayList<>();
    
    
    public Admin_AddStudent() {
        initComponents();
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
        StudentIntake_cmb = new javax.swing.JComboBox<>();
        StudentAssessment_cmb = new javax.swing.JComboBox<>();
        StudentSupervisor_cmb = new javax.swing.JComboBox<>();
        StudentSecMarker = new javax.swing.JComboBox<>();
        AddBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel9.setText("Add New Student");

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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Back_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(jLabel9)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Back_lbl)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel3.setText("Student Name");

        jLabel4.setText("Student Age");

        jLabel5.setText("Student Intake");

        jLabel6.setText("Student Assessment");

        jLabel7.setText("Student Supervisor");

        jLabel8.setText("Student Second Marker");

        StudentName_textfield.setForeground(java.awt.Color.gray);
        StudentName_textfield.setText("Please enter the student name");
        StudentName_textfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                StudentName_textfieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                StudentName_textfieldFocusLost(evt);
            }
        });
        StudentName_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentName_textfieldActionPerformed(evt);
            }
        });

        StudentAge_textfield.setForeground(java.awt.Color.gray);
        StudentAge_textfield.setText("Please enter the student age");
        StudentAge_textfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                StudentAge_textfieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                StudentAge_textfieldFocusLost(evt);
            }
        });
        StudentAge_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentAge_textfieldActionPerformed(evt);
            }
        });

        StudentIntake_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        StudentAssessment_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        StudentSupervisor_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        StudentSecMarker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        AddBtn.setText("Add Student");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(StudentName_textfield)
                            .addComponent(StudentAge_textfield)
                            .addComponent(StudentIntake_cmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StudentAssessment_cmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StudentSupervisor_cmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StudentSecMarker, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(AddBtn))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(StudentName_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(StudentAge_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(StudentIntake_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(StudentAssessment_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(StudentSupervisor_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(StudentSecMarker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(AddBtn)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
       // Retrieve student details from input fields
        String name = StudentName_textfield.getText();
        String ageText = StudentAge_textfield.getText(); // Retrieve age text directly
        int age;
        // Check if age is the placeholder text or empty
        if (ageText.equals("Please enter the student age") || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if age is the placeholder text or empty
        }
        try {
            age = Integer.parseInt(ageText); // Parse age only if it's not the placeholder text
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if age is not a valid integer
        }
        String intake = (String) StudentIntake_cmb.getSelectedItem();
        String assessment = (String) StudentAssessment_cmb.getSelectedItem();
        String supervisor = (String) StudentSupervisor_cmb.getSelectedItem();
        String secondMarker = (String) StudentSecMarker.getSelectedItem();
        String RMCP_lecture = "-";
        String password = "abc123";

        // Check if any field is empty
        if (name.equals("Please enter the student name") || intake.isEmpty() || assessment.isEmpty() || supervisor.isEmpty() || secondMarker.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if any field is empty
        }

        // Create a Student object with the retrieved data
        Student newStudent = new Student(name, age, generateStudentID(), intake, assessment, supervisor, secondMarker, RMCP_lecture, password);

        // Add the student to the ArrayList
        StuData_IO.add(newStudent);

        // Call writeToTxt to update the file with the ArrayList data
        StuData_IO.writeToTxt();

        // Confirmation message
        JOptionPane.showMessageDialog(this, "Student added successfully!");

        // Clear input fields for adding a new student
        clearInputFields();
    }                                          

    // Method to generate a unique student ID (You can modify this method as needed)
    private String generateStudentID() {
        // Code to generate a unique student ID, for now, let's return a fixed value
        return "TP" + ((int) (Math.random() * 100000));
    }//GEN-LAST:event_AddBtnActionPerformed

    private void StudentName_textfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StudentName_textfieldFocusGained
        if (StudentName_textfield.getText().equals("Please enter the student name")) {
                StudentName_textfield.setText("");
                StudentName_textfield.setForeground(Color.BLACK);
            }
    }//GEN-LAST:event_StudentName_textfieldFocusGained

    private void StudentName_textfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StudentName_textfieldFocusLost
        if (StudentName_textfield.getText().isEmpty()) {
            StudentName_textfield.setForeground(Color.GRAY);
            StudentName_textfield.setText("Please enter the student name");
        }
    }//GEN-LAST:event_StudentName_textfieldFocusLost

    private void StudentName_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentName_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentName_textfieldActionPerformed

    private void StudentAge_textfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StudentAge_textfieldFocusGained
        if (StudentAge_textfield.getText().equals("Please enter the student age")) {
                StudentAge_textfield.setText("");
                StudentAge_textfield.setForeground(Color.BLACK);
            }
    }//GEN-LAST:event_StudentAge_textfieldFocusGained

    private void StudentAge_textfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StudentAge_textfieldFocusLost
        if (StudentAge_textfield.getText().isEmpty()) {
            StudentAge_textfield.setForeground(Color.GRAY);
            StudentAge_textfield.setText("Please enter the student age");
        }
    }//GEN-LAST:event_StudentAge_textfieldFocusLost

    private void StudentAge_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentAge_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentAge_textfieldActionPerformed

    private void Back_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_lblMouseClicked
        Admin_Student adminStudentFrame = new Admin_Student();
        adminStudentFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Back_lblMouseClicked

    private void clearInputFields() {
        // Clear input fields and set placeholders
        StudentName_textfield.setText("");
        StudentName_textfield.setForeground(Color.GRAY);
        StudentName_textfield.setText("Please enter the student's name");
        
        StudentAge_textfield.setText("");
        StudentAge_textfield.setForeground(Color.GRAY);
        StudentAge_textfield.setText("Please enter the student age");
        
        // You may add similar code to clear other input fields if needed
    }
    
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(Admin_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        // Create an instance of Admin_AddStudent
        Admin_AddStudent addStudentFrame = new Admin_AddStudent();
        
        // Show the Admin_AddStudent frame
        addStudentFrame.setVisible(true);
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel Back_lbl;
    private javax.swing.JTextField StudentAge_textfield;
    private javax.swing.JComboBox<String> StudentAssessment_cmb;
    private javax.swing.JComboBox<String> StudentIntake_cmb;
    private javax.swing.JTextField StudentName_textfield;
    private javax.swing.JComboBox<String> StudentSecMarker;
    private javax.swing.JComboBox<String> StudentSupervisor_cmb;
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
