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

        jPanel1 = new javax.swing.JPanel();
        AddStudentButton = new javax.swing.JButton();
        EditStudentButton = new javax.swing.JButton();
        RemoveStudentButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        AddStudentButton.setText("Add Student");
        AddStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudentButtonActionPerformed(evt);
            }
        });

        EditStudentButton.setText("Edit Student");
        EditStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditStudentButtonActionPerformed(evt);
            }
        });

        RemoveStudentButton.setText("Remove Student");

        jLabel1.setText("LOGO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EditStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RemoveStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(77, 77, 77)
                .addComponent(AddStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EditStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RemoveStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel9.setText("Add New Student");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(245, 245, 245))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addContainerGap(30, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
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
                                .addGap(219, 219, 219)
                                .addComponent(AddBtn)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStudentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddStudentButtonActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // Method for adding a student

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

        // Create a string to represent the student's details
        String studentDetails = name + "," + age + "," + generateStudentID() + "," + intake + "," + assessment + "," + supervisor + "," + secondMarker;

        // Add the student details to the ArrayList
        studentList.add(studentDetails);

        // Write student details to StuData.txt file
        try (FileWriter writer = new FileWriter("StuData.txt", true)) {
            writer.write(studentDetails + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Check if any field is empty
        if (name.equals("Please enter the student name") || intake.isEmpty() || assessment.isEmpty() || supervisor.isEmpty() || secondMarker.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if any field is empty
        }

        
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

    private void EditStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditStudentButtonActionPerformed
    // Create an instance of Admin_EditStudent
    Admin_SearchStudent editStudentFrame = new Admin_SearchStudent();
    
    // Hide the current frame (Admin_AddStudent)
    this.setVisible(false);
    
    // Show the Admin_EditStudent frame
    editStudentFrame.setVisible(true);
    }//GEN-LAST:event_EditStudentButtonActionPerformed

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
        // Create an instance of Admin_AddStudent
        Admin_AddStudent addStudentFrame = new Admin_AddStudent();
        
        // Show the Admin_AddStudent frame
        addStudentFrame.setVisible(true);
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton AddStudentButton;
    private javax.swing.JButton EditStudentButton;
    private javax.swing.JButton RemoveStudentButton;
    private javax.swing.JTextField StudentAge_textfield;
    private javax.swing.JComboBox<String> StudentAssessment_cmb;
    private javax.swing.JComboBox<String> StudentIntake_cmb;
    private javax.swing.JTextField StudentName_textfield;
    private javax.swing.JComboBox<String> StudentSecMarker;
    private javax.swing.JComboBox<String> StudentSupervisor_cmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
