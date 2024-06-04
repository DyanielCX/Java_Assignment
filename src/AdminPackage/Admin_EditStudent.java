package AdminPackage;

import ProjManagerPackage.ProjManager;
import StuPackage.StuData_IO;
import StuPackage.Student;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import ProjManagerPackage.StuAssesElem.IntakeBasedMethod;


public class Admin_EditStudent extends javax.swing.JFrame {

    private String selectedStuID;
    private String selectedIntake;

    public Admin_EditStudent(String selectedStuID, String name, int age, String selectedIntake) {
        initComponents();
        setVisible(true);
        StudentID_textfield.setBackground(new Color(0, 0, 0, 0));
        
        // Set the options of current available intake
        ArrayList<String> intakeArray = IntakeBasedMethod.getIntake();
        String[] intakeList = intakeArray.toArray(new String[0]);
        cboStuIntake.setModel(new javax.swing.DefaultComboBoxModel<>(intakeList));
        
        // Search the selected student data
        for (Student student : StuData_IO.StuData) {
            if (student.id.equals(selectedStuID)) {
                StudentName_textfield.setText(student.name);
                StudentID_textfield.setText(student.id);
                StudentAge_textfield.setText(String.valueOf(student.age));
                cboStuIntake.setSelectedItem(student.intake);
                break;
            }
        }
        
        this.selectedStuID = selectedStuID;
        this.selectedIntake = selectedIntake;

        // Add action listener to intake combo box
        cboStuIntake.addActionListener(e -> intakeChanged());
    }
    
    private void intakeChanged() {
        String newIntake = (String) cboStuIntake.getSelectedItem();
        if (!newIntake.equals(selectedIntake)) {
            int response = JOptionPane.showConfirmDialog(this, 
                    "Changing the intake will cause the supervisor, second marker, and RMCP lecturer to be reassigned. Do you want to proceed?",
                    "Confirm Intake Change", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                // Set the supervisor, second marker, and RMCP lecturer to default values
                selectedIntake = newIntake;
            } else {
                cboStuIntake.setSelectedItem(selectedIntake); // Revert to previous intake if No is selected
            }
        }
    }

    private void updateStudentDetails() {
        try {
            // Search the selected student location
            int stuIndex = StuData_IO.checkStu(selectedStuID);

            // Get all the edited input data
            String editedName = StudentName_textfield.getText();
            int editedAge = Integer.parseInt(StudentAge_textfield.getText());
            String editedIntake = (String) cboStuIntake.getSelectedItem();
            
            String supervisor = "-";
            String secondMarker = "-";
            String RMCP_lecture = "-";
            
            // Update the student data in the ArrayList
            Student updatedStudent = new Student(editedName, editedAge, selectedStuID, editedIntake, 
                                                 StuData_IO.StuData.get(stuIndex).assessment, 
                                                 supervisor, 
                                                 secondMarker, 
                                                 RMCP_lecture, 
                                                 StuData_IO.StuData.get(stuIndex).password);
            StuData_IO.edit(stuIndex, updatedStudent);

            // Confirmation message
            JOptionPane.showMessageDialog(this, "Student edited successfully!");
            
            // Return back to the student list page
            this.setVisible(false);
            backMainFrame();
        } catch (NumberFormatException numExc) {
            JOptionPane.showMessageDialog(null, "You can only enter digits for age.", "Invalid Age Input", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        StudentName_textfield = new javax.swing.JTextField();
        StudentAge_textfield = new javax.swing.JTextField();
        EditBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        StudentID_textfield = new javax.swing.JTextField();
        cboStuIntake = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 148, 148));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Edit Student");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Back_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Back_lbl))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setText("Student Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setText("Age");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setText("Intake");

        StudentName_textfield.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        StudentName_textfield.setText("jTextField1");

        StudentAge_textfield.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        StudentAge_textfield.setText("jTextField2");
        StudentAge_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentAge_textfieldActionPerformed(evt);
            }
        });

        EditBtn.setBackground(new java.awt.Color(255, 148, 148));
        EditBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(255, 255, 255));
        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel10.setText("Student ID");

        StudentID_textfield.setEditable(false);
        StudentID_textfield.setBackground(new java.awt.Color(255, 255, 255));
        StudentID_textfield.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        StudentID_textfield.setBorder(null);
        StudentID_textfield.setDisabledTextColor(new java.awt.Color(242, 242, 242));

        cboStuIntake.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StudentName_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                    .addComponent(StudentAge_textfield)
                                    .addComponent(cboStuIntake, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(StudentID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(StudentID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(StudentName_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(StudentAge_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboStuIntake, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(EditBtn)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
     updateStudentDetails();

    }//GEN-LAST:event_EditBtnActionPerformed

    private void Back_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_lblMouseClicked
        this.setVisible(false);
        backMainFrame();
    }//GEN-LAST:event_Back_lblMouseClicked

    private void StudentAge_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentAge_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentAge_textfieldActionPerformed

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
            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back_lbl;
    private javax.swing.JButton EditBtn;
    private javax.swing.JTextField StudentAge_textfield;
    private javax.swing.JTextField StudentID_textfield;
    private javax.swing.JTextField StudentName_textfield;
    private javax.swing.JComboBox<String> cboStuIntake;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
