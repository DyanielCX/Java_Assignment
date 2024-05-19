package assignment_ood;


import StuPackage.StuData_IO;
import java.awt.Color;

public class Lecture_mainframe extends javax.swing.JFrame {

    // Color for side nav bar tab
    private Color navDefaultColor = new Color(122, 162, 227);
    private Color navSelectedColor = new Color(106, 212, 221);
    
    /**
     * Creates new form ProjMng_MainFrame
     */
    public Lecture_mainframe() {
        initComponents();
        getContentPane().setBackground(new Color(248, 246, 227));
        
        // Initialize your tabs
        initializeTabs();
        
        // Set the initial tab to show
        TabPanel.setSelectedIndex(0);
    }
     private void initializeTabs(){
        //Dashboard Panel Section
        Lect_Dashboard dash = new Lect_Dashboard(this);
        TabPanel.addTab("tab0", dash);
        
        //View Supervisee Panel Section
        Lect_ViewSupervisee tab1 = new Lect_ViewSupervisee(this);
        TabPanel.addTab("tab1", tab1);
        
        SecondMarker_ViewSupervisee tab2 = new SecondMarker_ViewSupervisee(this);
        TabPanel.addTab("tab2", tab2);
        
        Supervisor_ViewSupervisee tab3 = new Supervisor_ViewSupervisee(this);
        TabPanel.addTab("tab3", tab3);
        
        RMCP_ViewSupervisee tab4 = new RMCP_ViewSupervisee(this);
        TabPanel.addTab("tab4", tab4);
        
        
        //View Presentation Panel Section
        Lect_ViewPresentation view = new Lect_ViewPresentation(this);
        TabPanel.addTab("tab5", view);
       
        presentationReq tab6 = new  presentationReq(this);
        TabPanel.add("tab6",tab6);
         
        Lect_ViewConsultation tab7 = new Lect_ViewConsultation(this);
        TabPanel.add("tab7",tab7);
        
        lect_ViewRMCP tab8 = new lect_ViewRMCP(this);
        TabPanel.add("tab8",tab8);
     
      /* Get the user name */
        String UserName = "Shahab";
        AccName.setText(UserName);
        
        
        /* Set the tab panel (panel size -> 935, 530) */
//        Lect_ViewPresentation Tab1 = new Lect_ViewPresentation();
//        TabPanel.addTab("tab1", Tab1);
    
//        PanelClassName Tab2 = new PanelClassName();
//        TabPanel.addTab("tab2", Tab2);
    
       // Lect_ViewPresentation Tab3 = new Lect_ViewPresentation();
       // TabPanel.addTab("tab3", Tab3);
    
        
        
    
//        PanelClassName Tab5 = new PanelClassName();
//        TabPanel.addTab("tab5", Tab5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideNavBar = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        DashboardPane = new javax.swing.JPanel();
        navDashboard = new javax.swing.JLabel();
        ViewSuperviseesPane = new javax.swing.JPanel();
        navViewSupervisees = new javax.swing.JLabel();
        ViewPresentationPane = new javax.swing.JPanel();
        navViewPresentation = new javax.swing.JLabel();
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
        navDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProjMngDashboard.png"))); // NOI18N
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

        ViewSuperviseesPane.setBackground(new java.awt.Color(122, 162, 227));

        navViewSupervisees.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        navViewSupervisees.setForeground(new java.awt.Color(255, 255, 255));
        navViewSupervisees.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        navViewSupervisees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProjMngStuAsse.png"))); // NOI18N
        navViewSupervisees.setText("View Supervisees");
        navViewSupervisees.setDoubleBuffered(true);
        navViewSupervisees.setIconTextGap(15);
        navViewSupervisees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navViewSuperviseesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ViewSuperviseesPaneLayout = new javax.swing.GroupLayout(ViewSuperviseesPane);
        ViewSuperviseesPane.setLayout(ViewSuperviseesPaneLayout);
        ViewSuperviseesPaneLayout.setHorizontalGroup(
            ViewSuperviseesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewSuperviseesPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(navViewSupervisees)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ViewSuperviseesPaneLayout.setVerticalGroup(
            ViewSuperviseesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSuperviseesPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(navViewSupervisees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        ViewPresentationPane.setBackground(new java.awt.Color(122, 162, 227));

        navViewPresentation.setBackground(new java.awt.Color(106, 212, 221));
        navViewPresentation.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        navViewPresentation.setForeground(new java.awt.Color(255, 255, 255));
        navViewPresentation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        navViewPresentation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProjMngSupervisor.png"))); // NOI18N
        navViewPresentation.setText("View Presentation");
        navViewPresentation.setIconTextGap(15);
        navViewPresentation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navViewPresentationMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ViewPresentationPaneLayout = new javax.swing.GroupLayout(ViewPresentationPane);
        ViewPresentationPane.setLayout(ViewPresentationPaneLayout);
        ViewPresentationPaneLayout.setHorizontalGroup(
            ViewPresentationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPresentationPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(navViewPresentation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ViewPresentationPaneLayout.setVerticalGroup(
            ViewPresentationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPresentationPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(navViewPresentation, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        AccManagementPane.setBackground(new java.awt.Color(122, 162, 227));

        navAccMangement.setBackground(new java.awt.Color(122, 162, 227));
        navAccMangement.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        navAccMangement.setForeground(new java.awt.Color(255, 255, 255));
        navAccMangement.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        navAccMangement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProjMngAcc.png"))); // NOI18N
        navAccMangement.setText("Account Management");
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
        navReportStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProjMngReport.png"))); // NOI18N
        navReportStatus.setText("Report Status");
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
            .addComponent(ViewSuperviseesPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ViewPresentationPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(ViewSuperviseesPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ViewPresentationPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 519, Short.MAX_VALUE)
                .addComponent(AccName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topNavBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout)
                .addGap(20, 20, 20))
        );
        topNavBarLayout.setVerticalGroup(
            topNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topNavBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogout)
                .addGap(3, 3, 3)
                .addGroup(topNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccName, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
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
        ViewSuperviseesPane.setBackground(navDefaultColor);
        ViewPresentationPane.setBackground(navDefaultColor);
        AccManagementPane.setBackground(navDefaultColor);
        ReportStatusPane.setBackground(navDefaultColor);
        
        //Change to your tab name
        PanelTitle.setText("Dashboard");
        TabPanel.setSelectedIndex(0);
    }//GEN-LAST:event_navDashboardMouseClicked

    private void navViewSuperviseesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navViewSuperviseesMouseClicked
        DashboardPane.setBackground(navDefaultColor);
        ViewSuperviseesPane.setBackground(navSelectedColor);
        ViewPresentationPane.setBackground(navDefaultColor);
        AccManagementPane.setBackground(navDefaultColor);
        ReportStatusPane.setBackground(navDefaultColor);
        
        //Change to your tab name
        PanelTitle.setText("View Supervisee");
        TabPanel.setSelectedIndex(1);
    }//GEN-LAST:event_navViewSuperviseesMouseClicked

    private void navViewPresentationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navViewPresentationMouseClicked
        DashboardPane.setBackground(navDefaultColor);
        ViewSuperviseesPane.setBackground(navDefaultColor);
        ViewPresentationPane.setBackground(navSelectedColor);
        AccManagementPane.setBackground(navDefaultColor);
        ReportStatusPane.setBackground(navDefaultColor);
        
        //Change to your tab name
        PanelTitle.setText("View Presentation");
        TabPanel.setSelectedIndex(5);
    }//GEN-LAST:event_navViewPresentationMouseClicked

    private void navAccMangementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navAccMangementMouseClicked
        DashboardPane.setBackground(navDefaultColor);
        ViewSuperviseesPane.setBackground(navDefaultColor);
        ViewPresentationPane.setBackground(navDefaultColor);
        AccManagementPane.setBackground(navSelectedColor);
        ReportStatusPane.setBackground(navDefaultColor);
        
        //Change to your tab name
        PanelTitle.setText("Account Management");
//        TabPanel.setSelectedIndex(3);
    }//GEN-LAST:event_navAccMangementMouseClicked

    private void navReportStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navReportStatusMouseClicked
        DashboardPane.setBackground(navDefaultColor);
        ViewSuperviseesPane.setBackground(navDefaultColor);
        ViewPresentationPane.setBackground(navDefaultColor);
        AccManagementPane.setBackground(navDefaultColor);
        ReportStatusPane.setBackground(navSelectedColor);
        
        //Change to your tab name
        PanelTitle.setText("Report Status");
        //TabPanel.setSelectedIndex(4);
    }//GEN-LAST:event_navReportStatusMouseClicked
    
    /* Logout Button */
    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        //Back to the Login Page
    }//GEN-LAST:event_lblLogoutMouseClicked

    /**
     * @param args the command line arguments
     */
     public static void changeTab(int TabIndex){
        TabPanel.setSelectedIndex(TabIndex);
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
            java.util.logging.Logger.getLogger(Lecture_mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lecture_mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lecture_mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lecture_mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Lecture_mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel AccManagementPane;
    private javax.swing.JLabel AccName;
    private javax.swing.JPanel CoverTabPane;
    public javax.swing.JPanel DashboardPane;
    public javax.swing.JLabel PanelTitle;
    public javax.swing.JPanel ReportStatusPane;
    public static javax.swing.JTabbedPane TabPanel;
    public javax.swing.JPanel ViewPresentationPane;
    public javax.swing.JPanel ViewSuperviseesPane;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel navAccMangement;
    private javax.swing.JLabel navDashboard;
    private javax.swing.JLabel navReportStatus;
    private javax.swing.JLabel navViewPresentation;
    private javax.swing.JLabel navViewSupervisees;
    private javax.swing.JPanel sideNavBar;
    private javax.swing.JPanel topNavBar;
    // End of variables declaration//GEN-END:variables
}
