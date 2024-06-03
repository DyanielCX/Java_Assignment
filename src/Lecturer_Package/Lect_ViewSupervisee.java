package Lecturer_Package;

import Java_Assignment.Session;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class Lect_ViewSupervisee extends javax.swing.JPanel {

    private Lecture_mainframe lectmainframe;
    private List<Lecturer> lecturers;
    private String UserName;

    // Constructor that takes a Lecture_mainframe parameter
    public Lect_ViewSupervisee(Lecture_mainframe mainFrame) {
        this.lectmainframe = lectmainframe;
        this.UserName = Session.getUserID(); 
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnViewRMCPSupervisee = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnViewSupervisorSupervisee = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnViewSecondMarkerSupervisee = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 246, 227));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewRMCPSupervisee.setBackground(new java.awt.Color(153, 204, 255));
        btnViewRMCPSupervisee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnViewRMCPSupervisee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewRMCPSuperviseeMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setText("RMCP");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RMCP_View.png"))); // NOI18N

        javax.swing.GroupLayout btnViewRMCPSuperviseeLayout = new javax.swing.GroupLayout(btnViewRMCPSupervisee);
        btnViewRMCPSupervisee.setLayout(btnViewRMCPSuperviseeLayout);
        btnViewRMCPSuperviseeLayout.setHorizontalGroup(
            btnViewRMCPSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnViewRMCPSuperviseeLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(btnViewRMCPSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewRMCPSuperviseeLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewRMCPSuperviseeLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71))))
        );
        btnViewRMCPSuperviseeLayout.setVerticalGroup(
            btnViewRMCPSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnViewRMCPSuperviseeLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(btnViewRMCPSupervisee, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 290, 280));

        btnViewSupervisorSupervisee.setBackground(new java.awt.Color(153, 204, 255));
        btnViewSupervisorSupervisee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnViewSupervisorSupervisee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewSupervisorSuperviseeMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel6.setText("Supervisor");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StuConsultation2.png"))); // NOI18N

        javax.swing.GroupLayout btnViewSupervisorSuperviseeLayout = new javax.swing.GroupLayout(btnViewSupervisorSupervisee);
        btnViewSupervisorSupervisee.setLayout(btnViewSupervisorSuperviseeLayout);
        btnViewSupervisorSuperviseeLayout.setHorizontalGroup(
            btnViewSupervisorSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSupervisorSuperviseeLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(btnViewSupervisorSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(56, 56, 56))
        );
        btnViewSupervisorSuperviseeLayout.setVerticalGroup(
            btnViewSupervisorSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSupervisorSuperviseeLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(21, 21, 21))
        );

        add(btnViewSupervisorSupervisee, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 280, 280));

        btnViewSecondMarkerSupervisee.setBackground(new java.awt.Color(153, 204, 255));
        btnViewSecondMarkerSupervisee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnViewSecondMarkerSupervisee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewSecondMarkerSuperviseeMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel5.setText("Second Marker");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/present.png"))); // NOI18N

        javax.swing.GroupLayout btnViewSecondMarkerSuperviseeLayout = new javax.swing.GroupLayout(btnViewSecondMarkerSupervisee);
        btnViewSecondMarkerSupervisee.setLayout(btnViewSecondMarkerSuperviseeLayout);
        btnViewSecondMarkerSuperviseeLayout.setHorizontalGroup(
            btnViewSecondMarkerSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnViewSecondMarkerSuperviseeLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSecondMarkerSuperviseeLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(24, 24, 24))
        );
        btnViewSecondMarkerSuperviseeLayout.setVerticalGroup(
            btnViewSecondMarkerSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSecondMarkerSuperviseeLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(btnViewSecondMarkerSupervisee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 290, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewSecondMarkerSuperviseeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewSecondMarkerSuperviseeMouseClicked
    if (hasAssignedStudents(UserName, "SecondMarker")) {
                lectmainframe.changeTab(2);
            } else {
                JOptionPane.showMessageDialog(this, "No students assigned to you as Second Marker. Access denied.", "Access Denied", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_btnViewSecondMarkerSuperviseeMouseClicked

    private void btnViewSupervisorSuperviseeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewSupervisorSuperviseeMouseClicked
    if (hasAssignedStudents(UserName, "Supervisor")) {
              lectmainframe.changeTab(3);
          } else {
              JOptionPane.showMessageDialog(this, "No students assigned to you as Supervisor. Access denied.", "Access Denied", JOptionPane.WARNING_MESSAGE);
          }
    }//GEN-LAST:event_btnViewSupervisorSuperviseeMouseClicked

    private void btnViewRMCPSuperviseeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRMCPSuperviseeMouseClicked
    if (hasAssignedStudents(UserName, "RMCP")) {
                  lectmainframe.changeTab(4);
              } else {
                  JOptionPane.showMessageDialog(this, "No students assigned to you as RMCP. Access denied.", "Access Denied", JOptionPane.WARNING_MESSAGE);
              }
    }//GEN-LAST:event_btnViewRMCPSuperviseeMouseClicked

    private boolean hasAssignedStudents(String lecturerName, String role) {
        int roleIndex;
        switch (role) {
            case "Supervisor":
                roleIndex = 6;
                break;
            case "RMCP":
                roleIndex = 8;
                break;
            case "SecondMarker":
                roleIndex = 7;
                break;
            default:
                return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("StuData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 9 && parts[roleIndex].trim().equalsIgnoreCase(lecturerName)) {
                    return true;  // Found at least one student assigned to the lecturer in the specified role
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading student data file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;  // No students assigned to the lecturer in the specified role
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnViewRMCPSupervisee;
    private javax.swing.JPanel btnViewSecondMarkerSupervisee;
    private javax.swing.JPanel btnViewSupervisorSupervisee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
