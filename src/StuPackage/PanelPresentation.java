package StuPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelPresentation extends javax.swing.JPanel {
    private String username; // Declare as an instance variable
    private String password;

    
    public PanelPresentation(String username, String password) {
        initComponents();
        this.username = username; // Assign the parameter value to the instance variable
        this.password = password; 
        
        readStudentDetailsFromFile("StuData.txt");
        
        SubmitBtn.setVisible(false);
    }
    
    private void readStudentDetailsFromFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].trim().equals(username)) { 
                Assessment.setText(parts[5].trim());
                Lecturer.setText(parts[6].trim());
                return; // Exit the loop once the user is found
            }
        }
        // If the loop completes without finding the user
        System.err.println("User not found in the file.");
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}
    private void writeSelectedDateToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PresentationData.txt"))) {
            // Get the selected date from the JCalendar component
            Date selectedDate = PreDate.getDate();
            // Format the date as desired
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);
            // Write the formatted date to the file
            writer.write(formattedDate);
            // Optionally, write a new line if you want to append more data later
            writer.newLine();
            // Flush and close the writer
            writer.flush();
            System.out.println("Date written to presentation_data.txt successfully.");
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SubmitBtn = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PreDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Hour = new javax.swing.JSpinner();
        Minute = new javax.swing.JSpinner();
        Meridiem = new javax.swing.JComboBox<>();
        Lecturer = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        EditBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Assessment = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(935, 530));
        setMinimumSize(new java.awt.Dimension(935, 530));
        setPreferredSize(new java.awt.Dimension(935, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(935, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SubmitBtn.setText("Submit");
        SubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBtnActionPerformed(evt);
            }
        });
        add(SubmitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, -1, -1));

        jLabel1.setText("Status");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        jLabel2.setText("Presentation TIme");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));
        add(PreDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 127, -1));

        jLabel3.setText("Presentation Date");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        jLabel4.setText("Lecturer ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));
        add(Hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));
        add(Minute, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));

        Meridiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(Meridiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        Lecturer.setText("jTextField1");
        add(Lecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        jTextField2.setText("jTextField2");
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        add(EditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, -1));

        jLabel5.setText("Assessment");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        Assessment.setText("jTextField3");
        add(Assessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        SubmitBtn.setVisible(true);
    }//GEN-LAST:event_EditBtnActionPerformed

    private void SubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBtnActionPerformed
       writeSelectedDateToFile();
    }//GEN-LAST:event_SubmitBtnActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Assessment;
    private javax.swing.JButton EditBtn;
    private javax.swing.JSpinner Hour;
    private javax.swing.JTextField Lecturer;
    private javax.swing.JComboBox<String> Meridiem;
    private javax.swing.JSpinner Minute;
    private com.toedter.calendar.JDateChooser PreDate;
    private javax.swing.JToggleButton SubmitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
