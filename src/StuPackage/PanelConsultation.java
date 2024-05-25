package StuPackage;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanelConsultation extends javax.swing.JPanel {
    private String username; // Declare as an instance variable
    private String password;
    
    public PanelConsultation(String username, String password) {
        this.username = username; // Assign the parameter value to the instance variable
        this.password = password; 
        initComponents();
        
        setEditVisible(false);
        EditPanel.setVisible(false);
        SaveBtn.setVisible(false);
        readConsultationFile("ConsultationData.txt");
        List<String> lecturerNames = readLecturerNamesFromFile("LecData.txt");
        for (String name : lecturerNames) {
            LecChoose.addItem(name);
        }
    }
    
    private void readConsultationFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].trim().equals(username)) { 
                    ConStatus.setText("You have one consultation");
                    ReqBtn.setText("Check Consultation");
                    ConStatus2.setText(parts[5].trim());
                    Lec.setText(parts[1].trim());
                    Obj.setText(parts[2].trim());
                    Date.setText(parts[3].trim());
                    Time.setText(parts[4].trim());
                    
                    return; // Exit the loop once the user is found
                }else{
                    ConStatus.setText("Click button below to request a consultation");
                    ReqBtn.setText("Request Consultation");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
     public static List<String> readLecturerNamesFromFile(String fileName) {
        List<String> lecturerNames = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the lecturer name is the first part of the line
                String[] parts = line.split(",");  // Adjust the delimiter as necessary
                if (parts.length > 0) {
                    lecturerNames.add(parts[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lecturerNames;
    }
     private String constructNewLine() {
        // Get the selected date from the JCalendar component
        Date selectedDate = DateChoose.getDate();
        // Format the date as desired
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(selectedDate);

        // Get assessment and lecturer
        String ObjValue = ObjChoose.getText();
        String lecturerValue = LecChoose.getSelectedItem().toString().trim();

        // Get hour, minute, and meridiem values
        int hourValue = (int) HourChoose.getValue();
        int minuteValue = (int) MinuteChoose.getValue();
        String meridiemValue = (String) MeridiemChoose.getSelectedItem();

        // Concatenate hour, minute, and meridiem into one string
        String timeValue = hourValue + ":" + String.format("%02d", minuteValue) + " " + meridiemValue;

        // Construct the new line
        return username + "," + lecturerValue  + "," + ObjValue +"," + formattedDate + "," + timeValue  + ", Pending" ;
    }
     private void writeDataToFile() {
        try {
            // Read existing content of the file into a StringBuilder
            File file = new File("ConsultationData.txt");
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

            System.out.println("Data written to ConsultationData.txt successfully.");
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + ex.getMessage());
        }
    }

     private void setEditVisible(boolean visible) {
        Component[] components = {LecChoose,ObjChoose,DateChoose,HourChoose,MinuteChoose,MeridiemChoose};
        for (Component component : components) {
            component.setVisible(visible);
        }
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        EditPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        LecChoose = new javax.swing.JComboBox<>();
        Lec = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        HourChoose = new javax.swing.JSpinner();
        MinuteChoose = new javax.swing.JSpinner();
        MeridiemChoose = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ConStatus2 = new javax.swing.JLabel();
        DateChoose = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AddEditBtn = new javax.swing.JButton();
        SaveBtn = new javax.swing.JToggleButton();
        ObjChoose = new javax.swing.JTextField();
        Obj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ConStatus = new javax.swing.JLabel();
        ReqBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(935, 530));
        setMinimumSize(new java.awt.Dimension(935, 530));

        jPanel1.setPreferredSize(new java.awt.Dimension(935, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EditPanel.setBackground(new java.awt.Color(204, 204, 255));
        EditPanel.setForeground(new java.awt.Color(255, 255, 255));
        EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Lecturer ");
        EditPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        LecChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        EditPanel.add(LecChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 120, 30));

        Lec.setText("Lecturer");
        EditPanel.add(Lec, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        Time.setText("-");
        EditPanel.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 80, -1));

        Date.setText("- ");
        EditPanel.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 80, -1));
        EditPanel.add(HourChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 50, -1));
        EditPanel.add(MinuteChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 50, -1));

        MeridiemChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am", "pm" }));
        EditPanel.add(MeridiemChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 60, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Consultation TIme");
        EditPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        ConStatus2.setBackground(new java.awt.Color(204, 204, 255));
        ConStatus2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ConStatus2.setText("Status");
        EditPanel.add(ConStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 120, 30));
        EditPanel.add(DateChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 127, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Consultation Date");
        EditPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Consultation Objective");
        EditPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        AddEditBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddEditBtn.setText("Edit");
        AddEditBtn.setBorder(null);
        AddEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEditBtnActionPerformed(evt);
            }
        });
        EditPanel.add(AddEditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 60, 30));

        SaveBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SaveBtn.setText("Submit");
        SaveBtn.setBorder(null);
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });
        EditPanel.add(SaveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 60, 30));

        ObjChoose.setText("jTextField1");
        EditPanel.add(ObjChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 130, 30));

        Obj.setText("- ");
        Obj.setAutoscrolls(true);
        EditPanel.add(Obj, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 250, 40));

        jLabel1.setText("jLabel1");
        EditPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, -1, -1));

        jLabel6.setText("jLabel6");
        EditPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, -1, -1));

        jPanel4.add(EditPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 420));

        ConStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ConStatus.setText("Consultation Status");
        jPanel4.add(ConStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        ReqBtn.setBackground(new java.awt.Color(0, 102, 153));
        ReqBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ReqBtn.setForeground(new java.awt.Color(255, 255, 255));
        ReqBtn.setText("Request Consultation");
        ReqBtn.setBorder(null);
        ReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReqBtnActionPerformed(evt);
            }
        });
        jPanel4.add(ReqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 130, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/consultation.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 10, 420, 410));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 770, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReqBtnActionPerformed
        EditPanel.setVisible(true);
    }//GEN-LAST:event_ReqBtnActionPerformed
    private boolean editMode = true;
    private void handleEditMode(boolean editMode) {
        if (!editMode) {
            SaveBtn.setVisible(false);
            setEditVisible(false);
            AddEditBtn.setText("Add");
            this.editMode = true;
        } else {
            SaveBtn.setVisible(true);
            setEditVisible(true);
            AddEditBtn.setText("Cancel");
            this.editMode = false;
        }
    }
    private void AddEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEditBtnActionPerformed
        handleEditMode(editMode);
    }//GEN-LAST:event_AddEditBtnActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        writeDataToFile();
        handleEditMode(false);
        readConsultationFile("ConsultationData.txt");
    }//GEN-LAST:event_SaveBtnActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddEditBtn;
    private javax.swing.JLabel ConStatus;
    private javax.swing.JLabel ConStatus2;
    private javax.swing.JLabel Date;
    private com.toedter.calendar.JDateChooser DateChoose;
    private javax.swing.JPanel EditPanel;
    private javax.swing.JSpinner HourChoose;
    private javax.swing.JLabel Lec;
    private javax.swing.JComboBox<String> LecChoose;
    private javax.swing.JComboBox<String> MeridiemChoose;
    private javax.swing.JSpinner MinuteChoose;
    private javax.swing.JLabel Obj;
    private javax.swing.JTextField ObjChoose;
    private javax.swing.JButton ReqBtn;
    private javax.swing.JToggleButton SaveBtn;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
