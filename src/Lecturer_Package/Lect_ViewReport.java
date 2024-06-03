package Lecturer_Package;

import Java_Assignment.Session;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class Lect_ViewReport extends javax.swing.JPanel {

    private Lecture_mainframe lectmainframe;
    private List<Lecturer> lecturers;
    private String UserName;
    
    public Lect_ViewReport(Lecture_mainframe mainFrame) {
        this.lectmainframe = lectmainframe;
        this.UserName = Session.getUserID(); 
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnViewRMCPReport = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnViewSupervisorReport = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnViewSecondMarkerReport = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 246, 227));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewRMCPReport.setBackground(new java.awt.Color(153, 204, 255));
        btnViewRMCPReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnViewRMCPReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewRMCPReportMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setText("RMCP");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RMCP_View.png"))); // NOI18N

        javax.swing.GroupLayout btnViewRMCPReportLayout = new javax.swing.GroupLayout(btnViewRMCPReport);
        btnViewRMCPReport.setLayout(btnViewRMCPReportLayout);
        btnViewRMCPReportLayout.setHorizontalGroup(
            btnViewRMCPReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnViewRMCPReportLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(btnViewRMCPReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewRMCPReportLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewRMCPReportLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71))))
        );
        btnViewRMCPReportLayout.setVerticalGroup(
            btnViewRMCPReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnViewRMCPReportLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(btnViewRMCPReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 290, 280));

        btnViewSupervisorReport.setBackground(new java.awt.Color(153, 204, 255));
        btnViewSupervisorReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnViewSupervisorReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewSupervisorReportMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel6.setText("Supervisor");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StuConsultation2.png"))); // NOI18N

        javax.swing.GroupLayout btnViewSupervisorReportLayout = new javax.swing.GroupLayout(btnViewSupervisorReport);
        btnViewSupervisorReport.setLayout(btnViewSupervisorReportLayout);
        btnViewSupervisorReportLayout.setHorizontalGroup(
            btnViewSupervisorReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSupervisorReportLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(btnViewSupervisorReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(56, 56, 56))
        );
        btnViewSupervisorReportLayout.setVerticalGroup(
            btnViewSupervisorReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSupervisorReportLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(21, 21, 21))
        );

        add(btnViewSupervisorReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 280, 280));

        btnViewSecondMarkerReport.setBackground(new java.awt.Color(153, 204, 255));
        btnViewSecondMarkerReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnViewSecondMarkerReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewSecondMarkerReportMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel5.setText("Second Marker");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/present.png"))); // NOI18N

        javax.swing.GroupLayout btnViewSecondMarkerReportLayout = new javax.swing.GroupLayout(btnViewSecondMarkerReport);
        btnViewSecondMarkerReport.setLayout(btnViewSecondMarkerReportLayout);
        btnViewSecondMarkerReportLayout.setHorizontalGroup(
            btnViewSecondMarkerReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnViewSecondMarkerReportLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSecondMarkerReportLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(24, 24, 24))
        );
        btnViewSecondMarkerReportLayout.setVerticalGroup(
            btnViewSecondMarkerReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSecondMarkerReportLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(btnViewSecondMarkerReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 290, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewRMCPReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRMCPReportMouseClicked
    if (hasAssignedStudents(UserName, "RMCP")) {
                lectmainframe.changeTab(12);
            } else {
                JOptionPane.showMessageDialog(this, "No students assigned to you as RMCP. Access denied.", "Access Denied", JOptionPane.WARNING_MESSAGE);
            }

    }//GEN-LAST:event_btnViewRMCPReportMouseClicked

    private void btnViewSupervisorReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewSupervisorReportMouseClicked
   if (hasAssignedStudents(UserName, "Supervisor")) {
            lectmainframe.changeTab(11);
        } else {
            JOptionPane.showMessageDialog(this, "No students assigned to you as Supervisor. Access denied.", "Access Denied", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnViewSupervisorReportMouseClicked

    private void btnViewSecondMarkerReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewSecondMarkerReportMouseClicked
    if (hasAssignedStudents(UserName, "SecondMarker")) {
                lectmainframe.changeTab(10);
            } else {
                JOptionPane.showMessageDialog(this, "No students assigned to you as Second Marker. Access denied.", "Access Denied", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_btnViewSecondMarkerReportMouseClicked

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
    private javax.swing.JPanel btnViewRMCPReport;
    private javax.swing.JPanel btnViewSecondMarkerReport;
    private javax.swing.JPanel btnViewSupervisorReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
