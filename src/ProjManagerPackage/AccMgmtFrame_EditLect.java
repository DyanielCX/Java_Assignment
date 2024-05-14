package ProjManagerPackage;

import ProjManagerPackage.AssignSupvElem.LectData_IO;
import java.awt.Color;


public class AccMgmtFrame_EditLect extends javax.swing.JFrame {

    private int LectIndex;
    
    public AccMgmtFrame_EditLect(String selectedLectID) {
        
        //GUI Setting
        initComponents();
        getContentPane().setBackground(new Color(122, 162, 227));
        
        //Search the selected lecturer data
        LectIndex = LectData_IO.checkLect(selectedLectID);
        
        String LectName = LectData_IO.LectData.get(LectIndex).lectName;
        
        TFLectName.setText(LectName);
        TFLectID.setText(selectedLectID);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLectName = new javax.swing.JLabel();
        lblLectID = new javax.swing.JLabel();
        btbSubmit = new javax.swing.JButton();
        btbCancel = new javax.swing.JButton();
        TFLectName = new javax.swing.JTextField();
        TFLectID = new javax.swing.JTextField();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        iconTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblLectName.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblLectName.setForeground(new java.awt.Color(0, 0, 0));
        lblLectName.setText("Lecturer Name:");

        lblLectID.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblLectID.setForeground(new java.awt.Color(0, 0, 0));
        lblLectID.setText("Lecturer ID:");

        btbSubmit.setBackground(new java.awt.Color(122, 162, 227));
        btbSubmit.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        btbSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btbSubmit.setText("Submit");
        btbSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbSubmitActionPerformed(evt);
            }
        });

        btbCancel.setBackground(new java.awt.Color(122, 162, 227));
        btbCancel.setFont(new java.awt.Font("Dubai Medium", 1, 15)); // NOI18N
        btbCancel.setForeground(new java.awt.Color(255, 255, 255));
        btbCancel.setText("Cancel");
        btbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbCancelActionPerformed(evt);
            }
        });

        TFLectName.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N

        TFLectID.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFLectID, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btbSubmit)
                            .addComponent(lblLectName)
                            .addComponent(lblLectID))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btbCancel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(TFLectName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLectName)
                    .addComponent(TFLectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLectID)
                    .addComponent(TFLectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbCancel)
                    .addComponent(btbSubmit))
                .addGap(55, 55, 55))
        );

        lblTitle2.setFont(new java.awt.Font("Dubai Medium", 1, 38)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Account");

        lblTitle1.setFont(new java.awt.Font("Dubai Medium", 1, 38)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("Edit Lecturer");

        iconTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LectIcon.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblTitle2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(iconTitle)))
                .addGap(75, 75, 75)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconTitle)
                .addGap(0, 0, 0)
                .addComponent(lblTitle1)
                .addGap(0, 0, 0)
                .addComponent(lblTitle2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbSubmitActionPerformed
        String editedLectName = TFLectName.getText();
        String editedLectID = TFLectID.getText();
        
        ProjManager.editLectAcc(LectIndex, editedLectName, editedLectID);
        
        //Return back to the lecturer list page
        this.setVisible(false);
        backMainFrame();
    }//GEN-LAST:event_btbSubmitActionPerformed

    private void btbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbCancelActionPerformed
        //Return back to the lecturer list page
        this.setVisible(false);
        backMainFrame();
    }//GEN-LAST:event_btbCancelActionPerformed

    public void backMainFrame(){
        MainFrame fr = new MainFrame();
        fr.setVisible(true);

        fr.DashboardPane.setBackground(new Color(122, 162, 227));
        fr.AccManagementPane.setBackground(new Color(106, 212, 221));
        fr.PanelTitle.setText("Account Management");
        fr.changedTab(6);
    }
    
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
            java.util.logging.Logger.getLogger(AccMgmtFrame_EditLect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccMgmtFrame_EditLect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccMgmtFrame_EditLect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccMgmtFrame_EditLect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFLectID;
    private javax.swing.JTextField TFLectName;
    private javax.swing.JButton btbCancel;
    private javax.swing.JButton btbSubmit;
    private javax.swing.JLabel iconTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLectID;
    private javax.swing.JLabel lblLectName;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    // End of variables declaration//GEN-END:variables
}