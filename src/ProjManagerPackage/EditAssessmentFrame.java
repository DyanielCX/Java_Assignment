package ProjManagerPackage;

import ProjManagerPackage.StuAssessmentFrame;
import StuPackage.StuData_IO;
import StuPackage.Student;
import java.awt.Color;

/**
 *
 * @author PC
 */
public class EditAssessmentFrame extends javax.swing.JFrame {

    private String stuID;
    private String selectedAssessment;

    /**
     * Creates new form EditAssessmentFrame
     */
    public EditAssessmentFrame(String StuID) {
        //Pass the Student ID to class object(stuID)
        stuID = StuID;

        //GUI setting
        initComponents();
        getContentPane().setBackground(new Color(204, 204, 255));

        //Search the selected student data
        for (int i = 0; i < StuData_IO.StuData.size(); i++) {
            if (StuData_IO.StuData.get(i).id.equals(StuID)) {
                lbSelectedName.setText(StuData_IO.StuData.get(i).name);
                lbSelectedID.setText(StuData_IO.StuData.get(i).id);
                selectedAssessment = StuData_IO.StuData.get(i).assessment;
                break;
            }
        }
        
        cboAssesment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"-", "Intern", "Invt Report", "CP1", "CP2", "RMCP", "FYP"}));
        cboAssesment.setSelectedItem(selectedAssessment);
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
        lblTitle = new javax.swing.JLabel();
        lbSelectedName = new javax.swing.JLabel();
        lbStuID = new javax.swing.JLabel();
        lbSelectedID = new javax.swing.JLabel();
        lbAssesment = new javax.swing.JLabel();
        cboAssesment = new javax.swing.JComboBox<>();
        btbSubmit = new javax.swing.JButton();
        btbCancel = new javax.swing.JButton();
        lbStuName2 = new javax.swing.JLabel();
        btbBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Dubai Medium", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(115, 96, 223));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitle.setText("Student Assessment");

        lbSelectedName.setFont(new java.awt.Font("Dubai Medium", 1, 22)); // NOI18N
        lbSelectedName.setForeground(new java.awt.Color(115, 96, 223));
        lbSelectedName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSelectedName.setText(" ");

        lbStuID.setFont(new java.awt.Font("Dubai Medium", 1, 22)); // NOI18N
        lbStuID.setForeground(new java.awt.Color(115, 96, 223));
        lbStuID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbStuID.setText("Student ID: ");

        lbSelectedID.setFont(new java.awt.Font("Dubai Medium", 1, 22)); // NOI18N
        lbSelectedID.setForeground(new java.awt.Color(115, 96, 223));
        lbSelectedID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSelectedID.setText(" ");

        lbAssesment.setFont(new java.awt.Font("Dubai Medium", 1, 22)); // NOI18N
        lbAssesment.setForeground(new java.awt.Color(115, 96, 223));
        lbAssesment.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbAssesment.setText("Assessment: ");

        cboAssesment.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        cboAssesment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btbSubmit.setBackground(new java.awt.Color(115, 96, 223));
        btbSubmit.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        btbSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btbSubmit.setText("Submit");
        btbSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbSubmitActionPerformed(evt);
            }
        });

        btbCancel.setBackground(new java.awt.Color(115, 96, 223));
        btbCancel.setFont(new java.awt.Font("Dubai Medium", 1, 15)); // NOI18N
        btbCancel.setForeground(new java.awt.Color(255, 255, 255));
        btbCancel.setText("Cancel");
        btbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbCancelActionPerformed(evt);
            }
        });

        lbStuName2.setFont(new java.awt.Font("Dubai Medium", 1, 22)); // NOI18N
        lbStuName2.setForeground(new java.awt.Color(115, 96, 223));
        lbStuName2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbStuName2.setText("Student Name: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbStuID)
                    .addComponent(lbStuName2)
                    .addComponent(lbAssesment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSelectedName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSelectedID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAssesment, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btbSubmit)
                        .addGap(113, 113, 113)
                        .addComponent(btbCancel)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(139, 139, 139))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbSelectedName)
                        .addGap(25, 25, 25)
                        .addComponent(lbSelectedID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbStuName2)
                        .addGap(25, 25, 25)
                        .addComponent(lbStuID)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAssesment)
                    .addComponent(cboAssesment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbCancel)
                    .addComponent(btbSubmit))
                .addGap(55, 55, 55))
        );

        btbBack.setFont(new java.awt.Font("Dubai Medium", 1, 20)); // NOI18N
        btbBack.setForeground(new java.awt.Color(48, 26, 171));
        btbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProjMngArrow.png"))); // NOI18N
        btbBack.setText("back");
        btbBack.setIconTextGap(6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btbBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btbBack)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbCancelActionPerformed
        //Return back to the student list page
        this.setVisible(false);
        StuAssessmentFrame NwFrame = new StuAssessmentFrame();
        NwFrame.setVisible(true);
    }//GEN-LAST:event_btbCancelActionPerformed

    private void btbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbSubmitActionPerformed
        //Search the selected student location and
        int Index = StuData_IO.checkStu(stuID);

        //Get all the selected student data
        String Name = StuData_IO.StuData.get(Index).name;
        int Age = StuData_IO.StuData.get(Index).age;
        String Intake = StuData_IO.StuData.get(Index).intake;
        String Assessment = (String) cboAssesment.getSelectedItem();
        String Supervisor = StuData_IO.StuData.get(Index).supervisor;
        String SecondMaker = StuData_IO.StuData.get(Index).secondMaker;

        //Update the edited data into ArrayList
        Student Edited_Student = new Student(Name, Age, stuID, Intake, Assessment, Supervisor, SecondMaker);
        StuData_IO.edit(Index, Edited_Student);

        //Return back to the student list page
        this.setVisible(false);
        
        ProjMng_MainFrame fr = new ProjMng_MainFrame();
        fr.setVisible(true);
        fr.TabPanel.setSelectedIndex(1);
    }//GEN-LAST:event_btbSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(EditAssessmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAssessmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAssessmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAssessmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel btbBack;
    private javax.swing.JButton btbCancel;
    private javax.swing.JButton btbSubmit;
    private javax.swing.JComboBox<String> cboAssesment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAssesment;
    private javax.swing.JLabel lbSelectedID;
    private javax.swing.JLabel lbSelectedName;
    private javax.swing.JLabel lbStuID;
    private javax.swing.JLabel lbStuName2;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}