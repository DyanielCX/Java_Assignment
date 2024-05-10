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
                return; // Exit the loop once the user is found
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
    return username + "," + lecturerValue + "," + assessmentValue + "," + formattedDate + "," + timeValue;
}
    private void setComponentsVisible(boolean visible) {
        Component[] components = {PreDate, Hour, Minute, Meridiem, modify};
        for (Component component : components) {
            component.setVisible(visible);
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
        EditBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Lecturer = new javax.swing.JLabel();
        Assessment = new javax.swing.JLabel();
        PreStatus = new javax.swing.JLabel();
        PreDateShow = new javax.swing.JLabel();
        PreTimeShow = new javax.swing.JLabel();
        modify = new javax.swing.JLabel();

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
        add(SubmitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, -1, -1));

        jLabel1.setText("Presentation Status");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        jLabel2.setText("Presentation TIme");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));
        add(PreDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 127, -1));

        jLabel3.setText("Presentation Date");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jLabel4.setText("Lecturer ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        Hour.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                HourStateChanged(evt);
            }
        });
        add(Hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 50, -1));

        Minute.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MinuteStateChanged(evt);
            }
        });
        add(Minute, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 60, -1));

        Meridiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am","pm" }));
        add(Meridiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 70, -1));

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        add(EditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, -1));

        jLabel5.setText("Assessment");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        Lecturer.setText("Name");
        add(Lecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 80, 20));

        Assessment.setText("Type");
        add(Assessment, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 50, 20));

        PreStatus.setText("Status");
        add(PreStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        PreDateShow.setText("Date");
        add(PreDateShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 90, 20));

        PreTimeShow.setText("Time");
        add(PreTimeShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 90, 20));

        modify.setText("Modify");
        add(modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private boolean editMode = false;
    private void handleEditMode(boolean editMode) {
    if (editMode) {
        // If currently in "Cancel" state, revert to "Edit" state
        SubmitBtn.setVisible(false);
        setComponentsVisible(false);
        EditBtn.setText("Edit");
        this.editMode = false;
    } else {
        // If currently in "Edit" state, switch to "Cancel" state
        SubmitBtn.setVisible(true);
        setComponentsVisible(true);
        EditBtn.setText("Cancel");
        this.editMode = true;
    }
}
    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        handleEditMode(editMode);
    }//GEN-LAST:event_EditBtnActionPerformed

    private void SubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBtnActionPerformed
       // Check if the username exists in the file
        boolean usernameFound = checkUsernameInFile();

        // Display confirmation dialog based on whether the username is found
        if (usernameFound) {
            int confirmOption = JOptionPane.showConfirmDialog(this, "A presentation already exists for this username. Do you want to update it?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmOption == JOptionPane.YES_OPTION) {
                // User confirmed to update the presentation, proceed with writing data to file
                writeDataToFile();
                handleEditMode(false);
            } else{
                 handleEditMode(true);
            }
        } else {
            int confirmOption = JOptionPane.showConfirmDialog(this, "No presentation found for this username. Do you want to request a presentation?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmOption == JOptionPane.YES_OPTION) {
                // User confirmed to request a presentation, proceed with writing data to file
                writeDataToFile();
                handleEditMode(false);
            } else{
               handleEditMode(true);
            }
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
    private com.toedter.calendar.JDateChooser PreDate;
    private javax.swing.JLabel PreDateShow;
    private javax.swing.JLabel PreStatus;
    private javax.swing.JLabel PreTimeShow;
    private javax.swing.JToggleButton SubmitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel modify;
    // End of variables declaration//GEN-END:variables
}
