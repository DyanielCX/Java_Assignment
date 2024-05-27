package AdminPackage;



import StuPackage.StuData_IO;
import StuPackage.Student;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Admin_AddStudent extends javax.swing.JFrame {

    // ArrayList to store student details
    private ArrayList<String> studentList = new ArrayList<>();
    private HashSet<String> intakeSet = new HashSet<>(); 
    
    
    public Admin_AddStudent() {
        initComponents();
        populateStudentIntakeComboBox();
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
        StudentName_textfield = new javax.swing.JTextField();
        StudentAge_textfield = new javax.swing.JTextField();
        StudentIntake_cmb = new javax.swing.JComboBox<>();
        AddBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 148, 148));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Add New Student");

        Back_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
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
        StudentIntake_cmb.setToolTipText("");
        StudentIntake_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentIntake_cmbActionPerformed(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(255, 148, 148));
        AddBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(StudentName_textfield)
                            .addComponent(StudentAge_textfield)
                            .addComponent(StudentIntake_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(AddBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(AddBtn)
                .addGap(53, 53, 53))
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

        // Check if any field is empty
        if (name.equals("Please enter the student name") || intake.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if any field is empty
        }

        // Create a Student object with the retrieved data
        String stuID = generateStudentID();
        String assessment = "-";
        String supervisor = "-";
        String secondMarker = "-";
        String RMCP_Lecture = "-";
        String password = "123456";

        // Add the student to the ArrayList
        Student newStudent = new Student(name, age, stuID, intake, assessment, supervisor, secondMarker, RMCP_Lecture, password);
        StuData_IO.add(newStudent);

        // Call writeToTxt to update the file with the ArrayList data
        StuData_IO.writeToTxt();
        
         // Write to ReportData.txt
        writeToReportData(stuID);

        // Confirmation message
        JOptionPane.showMessageDialog(this, "Student added successfully!");

        // Clear input fields for adding a new student
        clearInputFields();
    }
    
    private void loadIntakeRecords() {
        try (BufferedReader br = new BufferedReader(new FileReader("IntakeRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(","); // Assuming comma-separated values
                if (fields.length > 0) {
                    String intake = fields[0].trim();
                    if (!intake.isEmpty() && !intakeSet.contains(intake)) {
                        intakeSet.add(intake);
                        StudentIntake_cmb.addItem(intake);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading intake records.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void writeToReportData(String studentID) {
        String reportData = String.format("%s, -,No Attempt,Not Graded, -, -, -, -, -", studentID);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ReportData.txt", true))) {
            writer.write(reportData);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to ReportData.txt", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        this.setVisible(false);
        backMainFrame();
    }//GEN-LAST:event_Back_lblMouseClicked

    private void StudentIntake_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentIntake_cmbActionPerformed

    }//GEN-LAST:event_StudentIntake_cmbActionPerformed

    private void populateStudentIntakeComboBox() {
        try (BufferedReader br = new BufferedReader(new FileReader("IntakeRecord.txt"))) {
            String line;
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // assuming CSV format
                if (columns.length > 0) {
                    model.addElement(columns[0]); // add the first column (Intake) to the model
                }
            }
            StudentIntake_cmb.setModel(model);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading IntakeRecord.txt", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
    
     public void backMainFrame(){
        Admin_MainFrame fr = new Admin_MainFrame();
        fr.setVisible(true);
        
        // Switch to allot intake advisors tab
        fr.Admin_StudentManagement(fr);
        int tabIndex = fr.TabPanel.getTabCount()-1;
        fr.changedTab(tabIndex);
        
        fr.IntakeMgmtPane.setBackground(new Color(255, 148, 148));
        fr.StuMgmtPane.setBackground(new Color(252, 188, 188));
        fr.LectMgmtPane.setBackground(new Color(255, 148, 148));
        fr.PanelTitle.setText("Student Management");
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
            java.util.logging.Logger.getLogger(Admin_StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> StudentIntake_cmb;
    private javax.swing.JTextField StudentName_textfield;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
