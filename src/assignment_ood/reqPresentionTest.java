/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment_ood;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.List;
import StuPackage.Student;
import StuPackage.StuData_IO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class reqPresentionTest extends javax.swing.JFrame {

    /**
     * Creates new form reqPresentionTest
     */
    public reqPresentionTest() {
        initComponents();
         populateSupervisorComboBox();
          populateStudentComboBox();
    }
    private void populateStudentComboBox() {
    viewStudent.removeAllItems();
    List<Student> students = readFrTxt();
    for (Student student : students) {
        viewStudent.addItem(student.name);
    }
    }
    
    
     private void populateSupervisorComboBox() {
    reqSupervisor.removeAllItems();
    List<Lecturer> lecturers = Admin.readLecturersFromFile();
    for (Lecturer lecturer : lecturers) {
        reqSupervisor.addItem(lecturer.getName());
    }
    }
      public static List<Student> readFrTxt(){
        List<Student> students = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File("StuData.txt"));

            // Read all lines
            while (scan.hasNext()) {
                String currentLine = scan.nextLine();
                String[] stuDataArray = currentLine.split(",");

                // Save the data into variables
                String name = stuDataArray[0];
                int age = Integer.parseInt(stuDataArray[1]);
                String stuID = stuDataArray[2];
                String intake = stuDataArray[3];
                String assessment = stuDataArray[4];
                String supervisor = stuDataArray[5];
                String secondMarker = stuDataArray[6];
                String RMCP_lecture = stuDataArray[7];
                String password = stuDataArray[8];

                // Add into ArrayList
                students.add(new Student(name, age, stuID, intake, assessment, supervisor, secondMarker, RMCP_lecture, password));
            }
            scan.close(); // Close the scanner
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"!Read text file error!");
            ex.printStackTrace();
        }
        return students; // Return the list of students
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reqSupervisor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        viewStudent = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Choose Presentation Date");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Supervisor");

        reqSupervisor.setSelectedItem(reqSupervisor);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Student");

        viewStudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addGap(108, 108, 108))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reqSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(viewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(reqSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String selectedStudent = (String) viewStudent.getSelectedItem();
    String selectedSupervisor = (String) reqSupervisor.getSelectedItem();
    String status ="Pending";
    // Get the selected date from the JCalendar
    java.util.Date selectedDate = jDateChooser1.getDate();
    
    // Define the file path where you want to save the data
    String filePath = "presentation_data.txt";
    
    try (FileWriter writer = new FileWriter(filePath, true); // Append to the file
         BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
        
        // Write the selected data to the file
         writer.write(selectedStudent + "," + selectedSupervisor + "," + selectedDate + ","+status + "\n");

        
        // Display a success message
        JOptionPane.showMessageDialog(this, "Data saved successfully to " + filePath);
    } catch (IOException e) {
        // Handle the exception (e.g., display an error message)
        JOptionPane.showMessageDialog(this, "Error saving data to " + filePath + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(reqPresentionTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reqPresentionTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reqPresentionTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reqPresentionTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reqPresentionTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> reqSupervisor;
    private javax.swing.JComboBox<String> viewStudent;
    // End of variables declaration//GEN-END:variables
}
