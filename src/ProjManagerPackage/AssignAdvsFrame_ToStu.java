/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ProjManagerPackage;

import StuPackage.StuData_IO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class AssignAdvsFrame_ToStu extends javax.swing.JFrame {

    private String StuIntake;
    private String StuAsses;
    private int StuIndex;
    
    public AssignAdvsFrame_ToStu(String selectedStuID) {
        
        //GUI Setting
        initComponents();
        getContentPane().setBackground(new Color(151, 231, 225));
        
        //Search and retrieve the selected student data
        StuIndex = StuData_IO.checkStu(selectedStuID);
        
        String StuName = StuData_IO.StuData.get(StuIndex).name;
        StuIntake = StuData_IO.StuData.get(StuIndex).intake;
        StuAsses = StuData_IO.StuData.get(StuIndex).assessment;
        
        lblSelectedName.setText(StuName);
        lblSelectedID.setText(selectedStuID);
        lblSelectedAssess.setText(StuAsses);
        
        //Get the advisor list
        ArrayList<String> Supervisor_ArrayList = new ArrayList<>();
        ArrayList<String> SecondMarker_ArrayList = new ArrayList<>();
        ArrayList<String> RMCPLect_ArrayList = new ArrayList<>();
        
        Supervisor_ArrayList.add("-");
        SecondMarker_ArrayList.add("-");
        RMCPLect_ArrayList.add("-");
        
        for (AdvisorsRecord advsRecord :AdvisorsRecord.AdvisorsRecordData){
            if (advsRecord.Intake.equals(StuIntake)) {
                if (!advsRecord.Spv1.equals("-")) {
                    Supervisor_ArrayList.add(advsRecord.Spv1);
                }
                if (!advsRecord.Spv2.equals("-")) {
                    Supervisor_ArrayList.add(advsRecord.Spv2);
                }
                if (!advsRecord.Spv3.equals("-")) {
                    Supervisor_ArrayList.add(advsRecord.Spv3);
                }
                if (!advsRecord.SecondMkr1.equals("-")) {
                    SecondMarker_ArrayList.add(advsRecord.SecondMkr1);
                }
                if (!advsRecord.SecondMkr2.equals("-")) {
                    SecondMarker_ArrayList.add(advsRecord.SecondMkr2);
                }
                if (!advsRecord.SecondMkr3.equals("-")) {
                    SecondMarker_ArrayList.add(advsRecord.SecondMkr3);
                }
                if (!advsRecord.RMCP_Lecturer.equals("-")) {
                    RMCPLect_ArrayList.add(advsRecord.RMCP_Lecturer);
                }
            }
        }

        //Convert ArrayList into Array
        String[] SupervisorList = Supervisor_ArrayList.toArray(new String[Supervisor_ArrayList.size()]);
        String[] SecondMarkerList = SecondMarker_ArrayList.toArray(new String[SecondMarker_ArrayList.size()]);
        String[] RMCP_LectList = RMCPLect_ArrayList.toArray(new String[RMCPLect_ArrayList.size()]);
        
        //Add advisor list into combo box
        cboSupervisor.setModel(new javax.swing.DefaultComboBoxModel<>(SupervisorList));
        cboSecondMarker.setModel(new javax.swing.DefaultComboBoxModel<>(SecondMarkerList));
        cboRMCP_Lect.setModel(new javax.swing.DefaultComboBoxModel<>(RMCP_LectList));
        
        //Set the selection of advisor based on student
        cboSupervisor.setSelectedItem(StuData_IO.StuData.get(StuIndex).supervisor);
        cboSecondMarker.setSelectedItem(StuData_IO.StuData.get(StuIndex).secondMarker);
        cboRMCP_Lect.setSelectedItem(StuData_IO.StuData.get(StuIndex).RMCP_lecture);
        
        //Set the comboBox unable to select based on assessment type
        switch (StuAsses) {
            case "Investigation Report":
                cboRMCP_Lect.setEnabled(false);
                break;
            case "CP1":
                cboRMCP_Lect.setEnabled(false);
                break;
            case "CP2":
                cboRMCP_Lect.setEnabled(false);
                break;
            case "FYP":
                cboRMCP_Lect.setEnabled(false);
                break;
            case "Intern":
                cboSecondMarker.setEnabled(false);
                cboRMCP_Lect.setEnabled(false);
                break;
            case "RMCP":
                cboSupervisor.setEnabled(false);
                cboSecondMarker.setEnabled(false);
                break;
        }
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
        lblSelectedName = new javax.swing.JLabel();
        lblStuName = new javax.swing.JLabel();
        lblSelectedID = new javax.swing.JLabel();
        lblSecondMarker = new javax.swing.JLabel();
        lblStuID = new javax.swing.JLabel();
        lblSupervisor = new javax.swing.JLabel();
        btbSubmit = new javax.swing.JButton();
        btbCancel = new javax.swing.JButton();
        lblAssess = new javax.swing.JLabel();
        lblSelectedAssess = new javax.swing.JLabel();
        lblRMCP_Lect = new javax.swing.JLabel();
        cboSupervisor = new javax.swing.JComboBox<>();
        cboSecondMarker = new javax.swing.JComboBox<>();
        cboRMCP_Lect = new javax.swing.JComboBox<>();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        iconTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblSelectedName.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblSelectedName.setForeground(new java.awt.Color(0, 0, 0));
        lblSelectedName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSelectedName.setText(" ");

        lblStuName.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblStuName.setForeground(new java.awt.Color(0, 0, 0));
        lblStuName.setText("Student Name:");

        lblSelectedID.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblSelectedID.setForeground(new java.awt.Color(0, 0, 0));
        lblSelectedID.setText(" ");

        lblSecondMarker.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblSecondMarker.setForeground(new java.awt.Color(0, 0, 0));
        lblSecondMarker.setText("Second Marker:");

        lblStuID.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblStuID.setForeground(new java.awt.Color(0, 0, 0));
        lblStuID.setText("Student ID:");

        lblSupervisor.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblSupervisor.setForeground(new java.awt.Color(0, 0, 0));
        lblSupervisor.setText("Supervisor:");

        btbSubmit.setBackground(new java.awt.Color(106, 212, 221));
        btbSubmit.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        btbSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btbSubmit.setText("Submit");
        btbSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbSubmitActionPerformed(evt);
            }
        });

        btbCancel.setBackground(new java.awt.Color(106, 212, 221));
        btbCancel.setFont(new java.awt.Font("Dubai Medium", 1, 15)); // NOI18N
        btbCancel.setForeground(new java.awt.Color(255, 255, 255));
        btbCancel.setText("Cancel");
        btbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbCancelActionPerformed(evt);
            }
        });

        lblAssess.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblAssess.setForeground(new java.awt.Color(0, 0, 0));
        lblAssess.setText("Assessment:");

        lblSelectedAssess.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        lblSelectedAssess.setForeground(new java.awt.Color(0, 0, 0));
        lblSelectedAssess.setText(" ");

        lblRMCP_Lect.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblRMCP_Lect.setForeground(new java.awt.Color(0, 0, 0));
        lblRMCP_Lect.setText("RMCP Lecturer:");

        cboSupervisor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboSecondMarker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboRMCP_Lect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblStuName)
                            .addComponent(lblStuID)
                            .addComponent(lblSupervisor)
                            .addComponent(lblSecondMarker)
                            .addComponent(lblAssess)
                            .addComponent(lblRMCP_Lect))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSelectedAssess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSecondMarker, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboRMCP_Lect, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSelectedName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSelectedID, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btbSubmit)
                        .addGap(63, 63, 63)
                        .addComponent(btbCancel)
                        .addGap(47, 47, 47)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectedName)
                    .addComponent(lblStuName))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectedID)
                    .addComponent(lblStuID))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAssess)
                    .addComponent(lblSelectedAssess))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupervisor)
                    .addComponent(cboSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSecondMarker)
                    .addComponent(cboSecondMarker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRMCP_Lect)
                    .addComponent(cboRMCP_Lect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbCancel)
                    .addComponent(btbSubmit))
                .addGap(37, 37, 37))
        );

        lblTitle2.setFont(new java.awt.Font("Dubai Medium", 1, 38)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Student");

        lblTitle1.setFont(new java.awt.Font("Dubai Medium", 1, 38)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("Assign To");

        iconTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AssignStu.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(iconTitle)
                        .addGap(51, 51, 51))
                    .addComponent(lblTitle1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle2)
                        .addGap(15, 15, 15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(iconTitle)
                        .addGap(0, 0, 0)
                        .addComponent(lblTitle1)
                        .addGap(0, 0, 0)
                        .addComponent(lblTitle2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbSubmitActionPerformed
        //Retrieve combo box selection
        String selectedSpv = (String) cboSupervisor.getSelectedItem();
        String selectedSecondMkr = (String) cboSecondMarker.getSelectedItem();
        String selectedRMCP_Lect = (String) cboRMCP_Lect.getSelectedItem();
        
        if (selectedSpv.equals(selectedSecondMkr) && !selectedSpv.equals("-") && !selectedSecondMkr.equals("-")) {
            //Show error message
            JOptionPane.showMessageDialog(null,"You cannot select the same person for supervisor and second marker.","Invalid Advisor Selection",JOptionPane.WARNING_MESSAGE);
            
            //Remain the combo box selection
            cboSupervisor.setSelectedItem(selectedSpv);
            cboSecondMarker.setSelectedItem(selectedSecondMkr);
            cboRMCP_Lect.setSelectedItem(selectedRMCP_Lect);
        }
        else{
            //Update the edited student data into ArrayList
            ProjManager.manualAssignStuAdvs(StuIndex, selectedSpv, selectedSecondMkr, selectedRMCP_Lect);

            //Return back to the student list page
            this.setVisible(false);
            backMainFrame();
        }
        
    }//GEN-LAST:event_btbSubmitActionPerformed

    private void btbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbCancelActionPerformed
        //Return back to the student list page
        this.setVisible(false);
        backMainFrame();
    }//GEN-LAST:event_btbCancelActionPerformed

    public void backMainFrame(){
        MainFrame fr = new MainFrame();
        fr.setVisible(true);

        fr.DashboardPane.setBackground(new Color(122, 162, 227));
        fr.AssignAdvisorsPane.setBackground(new Color(106, 212, 221));
        fr.PanelTitle.setText("Assign Advisors");
        
        fr.createStuAdvsListPane(fr, StuIntake, StuAsses);
        int tabIndex = fr.TabPanel.getTabCount()-1;
        fr.changedTab(tabIndex);
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
            java.util.logging.Logger.getLogger(AssignAdvsFrame_ToStu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignAdvsFrame_ToStu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignAdvsFrame_ToStu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignAdvsFrame_ToStu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbCancel;
    private javax.swing.JButton btbSubmit;
    private javax.swing.JComboBox<String> cboRMCP_Lect;
    private javax.swing.JComboBox<String> cboSecondMarker;
    private javax.swing.JComboBox<String> cboSupervisor;
    private javax.swing.JLabel iconTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAssess;
    private javax.swing.JLabel lblRMCP_Lect;
    private javax.swing.JLabel lblSecondMarker;
    private javax.swing.JLabel lblSelectedAssess;
    private javax.swing.JLabel lblSelectedID;
    private javax.swing.JLabel lblSelectedName;
    private javax.swing.JLabel lblStuID;
    private javax.swing.JLabel lblStuName;
    private javax.swing.JLabel lblSupervisor;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    // End of variables declaration//GEN-END:variables
}