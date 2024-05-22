package StuPackage;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanelConsultation extends javax.swing.JPanel {
    private String username; // Declare as an instance variable
    private String password;
    
    public PanelConsultation(String username, String password) {
        this.username = username; // Assign the parameter value to the instance variable
        this.password = password; 
        initComponents();
        
        EditPanel.setVisible(false);
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
                    
                    return; // Exit the loop once the user is found
                }else{
                    ConStatus.setText("Click button below to request a consultation");
                    ReqBtn.setText("Request Consultation");
                }
            }
            // If the loop completes without finding the user
            System.err.println("User not found in the file.");
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
        Lec = new javax.swing.JLabel();
        LecChoose = new javax.swing.JComboBox<>();
        Time = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        HourChoose = new javax.swing.JSpinner();
        MinuteChoose = new javax.swing.JSpinner();
        MeridiemChoose = new javax.swing.JComboBox<>();
        ConStatus2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DateChoose = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        AddEditBtn = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        Obj = new javax.swing.JLabel();
        ObjChoose = new javax.swing.JTextField();
        ConStatus = new javax.swing.JLabel();
        ReqBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(935, 530));
        setMinimumSize(new java.awt.Dimension(935, 530));

        jPanel1.setPreferredSize(new java.awt.Dimension(935, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EditPanel.setBackground(new java.awt.Color(255, 255, 255));
        EditPanel.setForeground(new java.awt.Color(255, 255, 255));
        EditPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Lecturer ");
        EditPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        Lec.setText("Lecturer");
        EditPanel.add(Lec, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        LecChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        EditPanel.add(LecChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        Time.setText("-");
        EditPanel.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 80, -1));

        Date.setText("- ");
        EditPanel.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 80, -1));

        jLabel2.setText("Consultation TIme");
        EditPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));
        EditPanel.add(HourChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 50, -1));
        EditPanel.add(MinuteChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 50, -1));

        MeridiemChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am", "pm" }));
        EditPanel.add(MeridiemChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 60, -1));

        ConStatus2.setText("Status");
        EditPanel.add(ConStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        jLabel3.setText("Consultation Date");
        EditPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));
        EditPanel.add(DateChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 127, -1));

        jLabel5.setText("Consultation Objective");
        EditPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        AddEditBtn.setText("Edit");
        EditPanel.add(AddEditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, -1));

        jToggleButton1.setText("Submit");
        EditPanel.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        Obj.setText("- ");
        EditPanel.add(Obj, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 70, 20));

        ObjChoose.setText("jTextField1");
        EditPanel.add(ObjChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

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
                .addContainerGap(882, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReqBtnActionPerformed
        EditPanel.setVisible(true);
    }//GEN-LAST:event_ReqBtnActionPerformed
    

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
    private javax.swing.JLabel Time;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
