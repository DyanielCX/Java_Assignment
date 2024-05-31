package StuPackage;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class PanelPresentation extends javax.swing.JPanel {
    private String username; // Declare as an instance variable
    private String password;
    
    public PanelPresentation(String username, String password) {
        initComponents();
        this.username = username; // Assign the parameter value to the instance variable
        this.password = password; 
        
        // initiate 0, min 1, max 12 , step size 1
         Hour.setModel(new SpinnerNumberModel(0, -1, 13, 1));
        // initiate 0, min 1, max 59 , step size 5
        Minute.setModel(new SpinnerNumberModel(0, -5, 60, 5));
        
        readStudentDetailsFromFile("StuData.txt");
        readPresentationDetailsFromFile("PresentationData.txt");
        
        setComponentsVisible(false);
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
    private void readPresentationDetailsFromFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].trim().equals(username)) { 
                PreDateShow.setText(parts[3].trim());
                PreTimeShow.setText(parts[4].trim());
                PreStatus.setText(parts[5].trim());
                String rejectReason = parts.length > 6 ? parts[6].trim() : "";
                if ("-".equals(rejectReason)) {
                    RejectReason.setVisible(false);
                } else {
                    RejectReason.setText(rejectReason);
                    RejectReason.setVisible(true);
                }
                return;
            }
        }
        // If the loop completes without finding the user
        System.err.println("User not found in the file.");
         PreDateShow.setText("-");
         PreTimeShow.setText("-");
         PreStatus.setText("No Presentation Request");
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
    }
}
private void writeDataToFile() {
    try {
        // Read existing content of the file into a StringBuilder
        File file = new File("PresentationData.txt");
        StringBuilder fileContent = new StringBuilder();
        boolean usernameFound = false; // Flag to track if the username is found
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(username)) {
                    // Replace the line with the new data
                    line = constructNewLine();
                    usernameFound = true;
                }
                fileContent.append(line).append(System.lineSeparator());
            }
            reader.close();
        }

        // If username was not found, append new line
        if (!usernameFound) {
            fileContent.append(constructNewLine()).append(System.lineSeparator());
        }

        // Write the updated content back to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(fileContent.toString());
        writer.close();

        System.out.println("Data written to PresentationData.txt successfully.");
    } catch (IOException ex) {
        System.err.println("Error writing to file: " + ex.getMessage());
    }
}

// Helper method to construct the new line of data
private String constructNewLine() {
    // Get the selected date from the JCalendar component
    Date selectedDate = PreDate.getDate();
    // Format the date as desired
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String formattedDate = dateFormat.format(selectedDate);

    // Get assessment and lecturer
    String assessmentValue = Assessment.getText().trim();
    String lecturerValue = Lecturer.getText().trim();

    // Get hour, minute, and meridiem values
    int hourValue = (int) Hour.getValue();
    int minuteValue = (int) Minute.getValue();
    String meridiemValue = (String) Meridiem.getSelectedItem();

    // Concatenate hour, minute, and meridiem into one string
    String timeValue = hourValue + ":" + String.format("%02d", minuteValue) + " " + meridiemValue;

    // Construct the new line
    return username + "," + lecturerValue + "," + assessmentValue + "," + formattedDate + "," + timeValue  + ", Pending, -" ;
}
    private void setComponentsVisible(boolean visible) {
        Component[] components = {PreDate, Hour, Minute, Meridiem, modify, NewDate, NewTime, Modify_Panel};
        for (Component component : components) {
            component.setVisible(visible);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Lecturer = new javax.swing.JLabel();
        Assessment = new javax.swing.JLabel();
        PreDateShow = new javax.swing.JLabel();
        PreTimeShow = new javax.swing.JLabel();
        PreStatus = new javax.swing.JLabel();
        RejectReason = new javax.swing.JLabel();
        EditBtn = new javax.swing.JButton();
        Modify_Panel = new javax.swing.JPanel();
        modify = new javax.swing.JLabel();
        PreDate = new com.toedter.calendar.JDateChooser();
        Hour = new javax.swing.JSpinner();
        Minute = new javax.swing.JSpinner();
        Meridiem = new javax.swing.JComboBox<>();
        SubmitBtn = new javax.swing.JToggleButton();
        NewDate = new javax.swing.JLabel();
        NewTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        setMaximumSize(new java.awt.Dimension(935, 530));
        setMinimumSize(new java.awt.Dimension(935, 530));
        setPreferredSize(new java.awt.Dimension(935, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(935, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(242, 242, 242));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Lecturer ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Assessment");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Presentation Date");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Presentation TIme");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText(" Request Status");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        Lecturer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Lecturer.setText("Name");
        jPanel3.add(Lecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 80, 20));

        Assessment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Assessment.setText("Type");
        jPanel3.add(Assessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 50, 20));

        PreDateShow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PreDateShow.setText("Date");
        jPanel3.add(PreDateShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 90, 20));

        PreTimeShow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PreTimeShow.setText("Time");
        jPanel3.add(PreTimeShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 90, 20));

        PreStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PreStatus.setText("Status");
        jPanel3.add(PreStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        RejectReason.setForeground(new java.awt.Color(255, 51, 0));
        RejectReason.setText("Reject Reason");
        jPanel3.add(RejectReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        EditBtn.setBackground(new java.awt.Color(255, 255, 255));
        EditBtn.setForeground(new java.awt.Color(0, 0, 0));
        EditBtn.setText("Edit");
        EditBtn.setBorder(null);
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        jPanel3.add(EditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 80, 30));

        Modify_Panel.setBackground(new java.awt.Color(198, 198, 206));
        Modify_Panel.setForeground(new java.awt.Color(255, 255, 255));
        Modify_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        modify.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        modify.setText("Modify");
        Modify_Panel.add(modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        PreDate.setBackground(new java.awt.Color(255, 255, 255));
        Modify_Panel.add(PreDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 127, -1));

        Hour.setBorder(null);
        Hour.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                HourStateChanged(evt);
            }
        });
        Modify_Panel.add(Hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 50, -1));

        Minute.setBorder(null);
        Minute.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MinuteStateChanged(evt);
            }
        });
        Modify_Panel.add(Minute, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 60, -1));

        Meridiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am","pm" }));
        Meridiem.setBorder(null);
        Modify_Panel.add(Meridiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 70, -1));

        SubmitBtn.setBackground(new java.awt.Color(204, 255, 204));
        SubmitBtn.setForeground(new java.awt.Color(0, 0, 0));
        SubmitBtn.setText("Submit");
        SubmitBtn.setBorder(null);
        SubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBtnActionPerformed(evt);
            }
        });
        Modify_Panel.add(SubmitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 80, 30));

        NewDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NewDate.setText("Date");
        Modify_Panel.add(NewDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        NewTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NewTime.setText("Time");
        Modify_Panel.add(NewTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jPanel3.add(Modify_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 330, 420));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/presentationPIC.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 260, 190));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 750, 420));
    }// </editor-fold>//GEN-END:initComponents

    private boolean editMode = true;
    private void handleEditMode(boolean editMode) {
        if (!editMode) {
            // If currently in "Cancel" state, revert to "Edit" state
            SubmitBtn.setVisible(false);
            setComponentsVisible(false);
            EditBtn.setText("Edit");
            this.editMode = true;
        } else {
            // If currently in "Edit" state, switch to "Cancel" state
            SubmitBtn.setVisible(true);
            setComponentsVisible(true);
            EditBtn.setText("Cancel");
            this.editMode = false;
        }
    }
    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        handleEditMode(editMode);
    }//GEN-LAST:event_EditBtnActionPerformed

    private void SubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBtnActionPerformed
        // Check if the JSpinners and JDateChooser have valid values
        int hourValue = (int) Hour.getValue();
        Date selectedDate = PreDate.getDate();
        boolean allValid = hourValue != 0 && selectedDate != null && selectedDate.after(new Date());
        
        if (!allValid) {
            JOptionPane.showMessageDialog(null, "Please select valid date and time", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if any of the values are invalid
        }

        // Check if the username exists in the file
        boolean usernameFound = checkUsernameInFile();

        // Display confirmation dialog based on whether the username is found
        int confirmOption;
        if (usernameFound) {
            confirmOption = JOptionPane.showConfirmDialog(null, "A presentation already exists for this username. Do you want to update it?", "Confirmation", JOptionPane.YES_NO_OPTION);
        } else {
            confirmOption = JOptionPane.showConfirmDialog(null, "No presentation found for this username. Do you want to request a presentation?", "Confirmation", JOptionPane.YES_NO_OPTION);
        }

        if (confirmOption == JOptionPane.YES_OPTION) {
            // Proceed with writing data to file
            writeDataToFile();
            readStudentDetailsFromFile("StuData.txt");
            readPresentationDetailsFromFile("PresentationData.txt");
            handleEditMode(false);
            JOptionPane.showMessageDialog(null, "Request has been sent successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            handleEditMode(true);
        }

    }//GEN-LAST:event_SubmitBtnActionPerformed
    
    private boolean checkUsernameInFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("PresentationData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].trim().equals(username)) {
                    return true; // Username found in the file
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return false; // Username not found in the file
    }
    private void HourStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_HourStateChanged
      int value = (int) Hour.getValue();
                if (value == 13) {
                    // If the spinner value is 12, reset it to 1
                    Hour.setValue(1);
                }else if(value == 0 || value == -1) {
                    // If the spinner value is 0, reset it to 12
                    Hour.setValue(12);
                }
    }//GEN-LAST:event_HourStateChanged

    private void MinuteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MinuteStateChanged
        int value = (int) Minute.getValue();
                if (value == 60) {
                    // If the spinner value is 60, reset it to 0
                    Minute.setValue(0);
                }else if(value == -5) {
                    // If the spinner value is -5 , reset it to 55
                    Minute.setValue(55);
                }
    }//GEN-LAST:event_MinuteStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Assessment;
    private javax.swing.JButton EditBtn;
    private javax.swing.JSpinner Hour;
    private javax.swing.JLabel Lecturer;
    private javax.swing.JComboBox<String> Meridiem;
    private javax.swing.JSpinner Minute;
    private javax.swing.JPanel Modify_Panel;
    private javax.swing.JLabel NewDate;
    private javax.swing.JLabel NewTime;
    private com.toedter.calendar.JDateChooser PreDate;
    private javax.swing.JLabel PreDateShow;
    private javax.swing.JLabel PreStatus;
    private javax.swing.JLabel PreTimeShow;
    private javax.swing.JLabel RejectReason;
    private javax.swing.JToggleButton SubmitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel modify;
    // End of variables declaration//GEN-END:variables
}
