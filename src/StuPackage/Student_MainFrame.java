package StuPackage;

import Java_Assignment.LoginPage;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Student_MainFrame extends javax.swing.JFrame {
    private String username; // Declare as an instance variable
    private String password;
    // Color for side nav bar tab
    private Color navDefaultColor = new Color(122, 162, 227);
    private Color navSelectedColor = new Color(106, 212, 221);
    
    /**
     * Creates new form ProjMng_MainFrame
     */
    public Student_MainFrame(String Username, String Password) {
        initComponents();
        this.username = Username; // Assign the parameter value to the instance variable
        this.password = Password; 
        readStudentNameFromFile("StuData.txt");
        
        getContentPane().setBackground(new Color(248, 246, 227));
        
        /* Set the tab panel (panel size -> 935, 350) */
        PanelDashboard Tab1 = new PanelDashboard (username, password);
        TabPanel.addTab("tab1", Tab1);
    
        PanelSchedule Tab2 = new PanelSchedule(username, password);
        TabPanel.addTab("tab2", Tab2);
    
        PanelPresentation Tab3 = new PanelPresentation(username, password);
        TabPanel.addTab("tab3", Tab3);
    
        PanelReport Tab4 = new PanelReport(username, password);
        TabPanel.addTab("tab4", Tab4);
    
        PanelConsultation Tab5 = new PanelConsultation(username, password);
        TabPanel.addTab("tab5", Tab5);
    }
    
    private void readStudentNameFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].trim().equals(username)) { 
                    AccName.setText(parts[2].trim());
                    return; // Exit the loop once the user is found
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideNavBar = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        DashboardPane = new javax.swing.JPanel();
        navDashboard = new javax.swing.JLabel();
        StuAssessmentPane = new javax.swing.JPanel();
        navStuAssessment = new javax.swing.JLabel();
        AssignSupervisorPane = new javax.swing.JPanel();
        navAssignSupervisor = new javax.swing.JLabel();
        AccManagementPane = new javax.swing.JPanel();
        navAccMangement = new javax.swing.JLabel();
        ReportStatusPane = new javax.swing.JPanel();
        navReportStatus = new javax.swing.JLabel();
        topNavBar = new javax.swing.JPanel();
        PanelTitle = new javax.swing.JLabel();
        AccName = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        CoverTabPane = new javax.swing.JPanel();
        TabPanel = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(248, 246, 227));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideNavBar.setBackground(new java.awt.Color(122, 162, 227));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo(White).png"))); // NOI18N

        DashboardPane.setBackground(new java.awt.Color(106, 212, 221));

        navDashboard.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        navDashboard.setForeground(new java.awt.Color(255, 255, 255));
        navDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        navDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StuDashboard.png"))); // NOI18N
        navDashboard.setText("Dashboard");
        navDashboard.setIconTextGap(15);
        navDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navDashboardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DashboardPaneLayout = new javax.swing.GroupLayout(DashboardPane);
        DashboardPane.setLayout(DashboardPaneLayout);
        DashboardPaneLayout.setHorizontalGroup(
            DashboardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(navDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashboardPaneLayout.setVerticalGroup(
            DashboardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(navDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        StuAssessmentPane.setBackground(new java.awt.Color(122, 162, 227));

        navStuAssessment.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        navStuAssessment.setForeground(new java.awt.Color(255, 255, 255));
        navStuAssessment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        navStuAssessment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StuResult.png"))); // NOI18N
        navStuAssessment.setText("Schedule ");
        navStuAssessment.setDoubleBuffered(true);
        navStuAssessment.setIconTextGap(15);
        navStuAssessment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navStuAssessmentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout StuAssessmentPaneLayout = new javax.swing.GroupLayout(StuAssessmentPane);
        StuAssessmentPane.setLayout(StuAssessmentPaneLayout);
        StuAssessmentPaneLayout.setHorizontalGroup(
            StuAssessmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StuAssessmentPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(navStuAssessment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        StuAssessmentPaneLayout.setVerticalGroup(
            StuAssessmentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StuAssessmentPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(navStuAssessment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        AssignSupervisorPane.setBackground(new java.awt.Color(122, 162, 227));

        navAssignSupervisor.setBackground(new java.awt.Color(106, 212, 221));
        navAssignSupervisor.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        navAssignSupervisor.setForeground(new java.awt.Color(255, 255, 255));
        navAssignSupervisor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        navAssignSupervisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StuPresentation.png"))); // NOI18N
        navAssignSupervisor.setText("Presentation");
        navAssignSupervisor.setIconTextGap(15);
        navAssignSupervisor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navAssignSupervisorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout AssignSupervisorPaneLayout = new javax.swing.GroupLayout(AssignSupervisorPane);
        AssignSupervisorPane.setLayout(AssignSupervisorPaneLayout);
        AssignSupervisorPaneLayout.setHorizontalGroup(
            AssignSupervisorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssignSupervisorPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(navAssignSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AssignSupervisorPaneLayout.setVerticalGroup(
            AssignSupervisorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssignSupervisorPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(navAssignSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        AccManagementPane.setBackground(new java.awt.Color(122, 162, 227));

        navAccMangement.setBackground(new java.awt.Color(122, 162, 227));
        navAccMangement.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        navAccMangement.setForeground(new java.awt.Color(255, 255, 255));
        navAccMangement.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        navAccMangement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StuReport.png"))); // NOI18N
        navAccMangement.setText("Report");
        navAccMangement.setIconTextGap(15);
        navAccMangement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navAccMangementMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout AccManagementPaneLayout = new javax.swing.GroupLayout(AccManagementPane);
        AccManagementPane.setLayout(AccManagementPaneLayout);
        AccManagementPaneLayout.setHorizontalGroup(
            AccManagementPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccManagementPaneLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(navAccMangement)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AccManagementPaneLayout.setVerticalGroup(
            AccManagementPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccManagementPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(navAccMangement, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        ReportStatusPane.setBackground(new java.awt.Color(122, 162, 227));

        navReportStatus.setBackground(new java.awt.Color(122, 162, 227));
        navReportStatus.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        navReportStatus.setForeground(new java.awt.Color(255, 255, 255));
        navReportStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        navReportStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StuConsultation.png"))); // NOI18N
        navReportStatus.setText("Consultation");
        navReportStatus.setIconTextGap(15);
        navReportStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navReportStatusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ReportStatusPaneLayout = new javax.swing.GroupLayout(ReportStatusPane);
        ReportStatusPane.setLayout(ReportStatusPaneLayout);
        ReportStatusPaneLayout.setHorizontalGroup(
            ReportStatusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportStatusPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(navReportStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ReportStatusPaneLayout.setVerticalGroup(
            ReportStatusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportStatusPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(navReportStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout sideNavBarLayout = new javax.swing.GroupLayout(sideNavBar);
        sideNavBar.setLayout(sideNavBarLayout);
        sideNavBarLayout.setHorizontalGroup(
            sideNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideNavBarLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addComponent(DashboardPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(StuAssessmentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AssignSupervisorPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AccManagementPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ReportStatusPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sideNavBarLayout.setVerticalGroup(
            sideNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideNavBarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(DashboardPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(StuAssessmentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(AssignSupervisorPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(AccManagementPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ReportStatusPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(sideNavBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        topNavBar.setBackground(new java.awt.Color(151, 231, 225));

        PanelTitle.setFont(new java.awt.Font("Comic Sans MS", 1, 40)); // NOI18N
        PanelTitle.setForeground(new java.awt.Color(255, 255, 255));
        PanelTitle.setText("Dashboard");

        AccName.setFont(new java.awt.Font("Dubai Medium", 0, 28)); // NOI18N
        AccName.setForeground(new java.awt.Color(255, 255, 255));
        AccName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AccName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProjMngUser.png"))); // NOI18N
        AccName.setIconTextGap(10);

        lblLogout.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logout.png"))); // NOI18N
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout topNavBarLayout = new javax.swing.GroupLayout(topNavBar);
        topNavBar.setLayout(topNavBarLayout);
        topNavBarLayout.setHorizontalGroup(
            topNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topNavBarLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(PanelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 554, Short.MAX_VALUE)
                .addComponent(AccName)
                .addGap(18, 18, 18)
                .addComponent(lblLogout)
                .addGap(31, 31, 31))
        );
        topNavBarLayout.setVerticalGroup(
            topNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topNavBarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(topNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AccName, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelTitle))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topNavBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout)
                .addGap(32, 32, 32))
        );

        getContentPane().add(topNavBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 975, -1));

        CoverTabPane.setBackground(new java.awt.Color(248, 246, 227));

        javax.swing.GroupLayout CoverTabPaneLayout = new javax.swing.GroupLayout(CoverTabPane);
        CoverTabPane.setLayout(CoverTabPaneLayout);
        CoverTabPaneLayout.setHorizontalGroup(
            CoverTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        CoverTabPaneLayout.setVerticalGroup(
            CoverTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(CoverTabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 940, 30));
        getContentPane().add(TabPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 94, -1, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void navDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navDashboardMouseClicked
        DashboardPane.setBackground(navSelectedColor);
        StuAssessmentPane.setBackground(navDefaultColor);
        AssignSupervisorPane.setBackground(navDefaultColor);
        AccManagementPane.setBackground(navDefaultColor);
        ReportStatusPane.setBackground(navDefaultColor);
        
        //Change to your tab name
        PanelTitle.setText("Dashboard");
        TabPanel.setSelectedIndex(0);
    }//GEN-LAST:event_navDashboardMouseClicked

    private void navStuAssessmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navStuAssessmentMouseClicked
        DashboardPane.setBackground(navDefaultColor);
        StuAssessmentPane.setBackground(navSelectedColor);
        AssignSupervisorPane.setBackground(navDefaultColor);
        AccManagementPane.setBackground(navDefaultColor);
        ReportStatusPane.setBackground(navDefaultColor);
        
        //Change to your tab name
        PanelTitle.setText("Scedule");
        TabPanel.setSelectedIndex(1);
    }//GEN-LAST:event_navStuAssessmentMouseClicked

    private void navAssignSupervisorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navAssignSupervisorMouseClicked
        DashboardPane.setBackground(navDefaultColor);
        StuAssessmentPane.setBackground(navDefaultColor);
        AssignSupervisorPane.setBackground(navSelectedColor);
        AccManagementPane.setBackground(navDefaultColor);
        ReportStatusPane.setBackground(navDefaultColor);
        
        //Change to your tab name
        PanelTitle.setText("Presentation");
        TabPanel.setSelectedIndex(2);
    }//GEN-LAST:event_navAssignSupervisorMouseClicked

    private void navAccMangementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navAccMangementMouseClicked
        DashboardPane.setBackground(navDefaultColor);
        StuAssessmentPane.setBackground(navDefaultColor);
        AssignSupervisorPane.setBackground(navDefaultColor);
        AccManagementPane.setBackground(navSelectedColor);
        ReportStatusPane.setBackground(navDefaultColor);
        
        //Change to your tab name
        PanelTitle.setText("Report");
        TabPanel.setSelectedIndex(3);
    }//GEN-LAST:event_navAccMangementMouseClicked

    private void navReportStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navReportStatusMouseClicked
        DashboardPane.setBackground(navDefaultColor);
        StuAssessmentPane.setBackground(navDefaultColor);
        AssignSupervisorPane.setBackground(navDefaultColor);
        AccManagementPane.setBackground(navDefaultColor);
        ReportStatusPane.setBackground(navSelectedColor);
        
        //Change to your tab name
        PanelTitle.setText("Consultation");
        TabPanel.setSelectedIndex(4);
    }//GEN-LAST:event_navReportStatusMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        LoginPage login = new LoginPage();
        login.setVisible(true); // Show the new window
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(Student_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StuData_IO.readFrTxt();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel AccManagementPane;
    private javax.swing.JLabel AccName;
    public javax.swing.JPanel AssignSupervisorPane;
    private javax.swing.JPanel CoverTabPane;
    public javax.swing.JPanel DashboardPane;
    public javax.swing.JLabel PanelTitle;
    public javax.swing.JPanel ReportStatusPane;
    public javax.swing.JPanel StuAssessmentPane;
    public javax.swing.JTabbedPane TabPanel;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel navAccMangement;
    private javax.swing.JLabel navAssignSupervisor;
    private javax.swing.JLabel navDashboard;
    private javax.swing.JLabel navReportStatus;
    private javax.swing.JLabel navStuAssessment;
    private javax.swing.JPanel sideNavBar;
    private javax.swing.JPanel topNavBar;
    // End of variables declaration//GEN-END:variables
}
