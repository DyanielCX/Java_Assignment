package assignment_ood;

public class Lect_ViewSupervisee extends javax.swing.JPanel {

    private Lecture_mainframe lectmainframe;

    // Constructor that takes a Lecture_mainframe parameter
    public Lect_ViewSupervisee(Lecture_mainframe mainFrame) {
        this.lectmainframe = lectmainframe;
        initComponents();
    }

    // Default constructor if needed
    public Lect_ViewSupervisee() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnViewSecondMarkerSupervisee = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnViewSupervisorSupervisee = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnViewRMCPSupervisee = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnViewSecondMarkerSupervisee.setBackground(new java.awt.Color(255, 51, 51));
        btnViewSecondMarkerSupervisee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
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
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(btnViewSecondMarkerSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSecondMarkerSuperviseeLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSecondMarkerSuperviseeLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29))))
        );
        btnViewSecondMarkerSuperviseeLayout.setVerticalGroup(
            btnViewSecondMarkerSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSecondMarkerSuperviseeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(16, 16, 16))
        );

        btnViewSupervisorSupervisee.setBackground(new java.awt.Color(255, 51, 51));
        btnViewSupervisorSupervisee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
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
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(btnViewSupervisorSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(57, 57, 57))
        );
        btnViewSupervisorSuperviseeLayout.setVerticalGroup(
            btnViewSupervisorSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewSupervisorSuperviseeLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnViewRMCPSupervisee.setBackground(new java.awt.Color(255, 51, 51));
        btnViewRMCPSupervisee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        btnViewRMCPSupervisee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewRMCPSuperviseeMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setText("RMCP");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProjMngAcc.png"))); // NOI18N

        javax.swing.GroupLayout btnViewRMCPSuperviseeLayout = new javax.swing.GroupLayout(btnViewRMCPSupervisee);
        btnViewRMCPSupervisee.setLayout(btnViewRMCPSuperviseeLayout);
        btnViewRMCPSuperviseeLayout.setHorizontalGroup(
            btnViewRMCPSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnViewRMCPSuperviseeLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(btnViewRMCPSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewRMCPSuperviseeLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewRMCPSuperviseeLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(135, 135, 135))))
        );
        btnViewRMCPSuperviseeLayout.setVerticalGroup(
            btnViewRMCPSuperviseeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnViewRMCPSuperviseeLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnViewSecondMarkerSupervisee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnViewSupervisorSupervisee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewRMCPSupervisee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewSecondMarkerSupervisee, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewSupervisorSupervisee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewRMCPSupervisee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewSecondMarkerSuperviseeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewSecondMarkerSuperviseeMouseClicked
        lectmainframe.changeTab(2);
    }//GEN-LAST:event_btnViewSecondMarkerSuperviseeMouseClicked

    private void btnViewSupervisorSuperviseeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewSupervisorSuperviseeMouseClicked
        lectmainframe.changeTab(3);
    }//GEN-LAST:event_btnViewSupervisorSuperviseeMouseClicked

    private void btnViewRMCPSuperviseeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRMCPSuperviseeMouseClicked
        lectmainframe.changeTab(4);
    }//GEN-LAST:event_btnViewRMCPSuperviseeMouseClicked


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
