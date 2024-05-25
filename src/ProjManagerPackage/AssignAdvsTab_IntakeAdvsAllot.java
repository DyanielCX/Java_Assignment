package ProjManagerPackage;

import AdminPackage.IntakeRecord;
import ProjManagerPackage.AssignSupvElem.LectData_IO;
import ProjManagerPackage.StuAssesElem.IntakeBasedMethod;
import StuPackage.StuData_IO;
import StuPackage.Student;
import Lecturer_Package.Lecturer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;


public class AssignAdvsTab_IntakeAdvsAllot extends javax.swing.JPanel {

    private ProjManager_MainFrame mainFrame;
    private String SelectedIntake;
    private String Assessment;
    
    public AssignAdvsTab_IntakeAdvsAllot(ProjManager_MainFrame mainFrame, String selectedIntake) {
        this.mainFrame = mainFrame;
        SelectedIntake = selectedIntake;
        Assessment = IntakeBasedMethod.getAssessment(selectedIntake);
        
        initComponents();
        
        //Get assessement and total student of selected intake
        String assessment = IntakeBasedMethod.getAssessment(selectedIntake);
        int TotalStu = 0;
        
        for (Student stu :StuData_IO.StuData){
            if (stu.intake.equals(selectedIntake)) {
                TotalStu ++;
            }
        }
        //Insert the retrieve data in to panel
        TabTitle.setText(selectedIntake);
        selectedAssessment.setText(assessment);
        numTotalStu.setText(Integer.toString(TotalStu));
        
        
        //Create supervisor, second marker and RMCP lecturer list
        ArrayList<String> Supervisor_ArrayList = new ArrayList<>();
        ArrayList<String> SecondMarker_ArrayList = new ArrayList<>();
        ArrayList<String> RMCPLect_ArrayList = new ArrayList<>();
        
        Supervisor_ArrayList.add("-");
        SecondMarker_ArrayList.add("-");
        RMCPLect_ArrayList.add("-");
        
        for (Lecturer lect :LectData_IO.LectData){
            if (lect.isProjectManager == false){
                if (lect.isSupervisor == true) {
                    Supervisor_ArrayList.add(lect.lectName);
                }
                if(lect.isSecondMarker == true) {
                    SecondMarker_ArrayList.add(lect.lectName);
                }
                RMCPLect_ArrayList.add(lect.lectName);
            }
        }
        
        //Convert ArrayList into Array
        String[] SupervisorList = Supervisor_ArrayList.toArray(new String[Supervisor_ArrayList.size()]);
        String[] SecondMarkerList = SecondMarker_ArrayList.toArray(new String[SecondMarker_ArrayList.size()]);
        String[] RMCP_LectList = RMCPLect_ArrayList.toArray(new String[RMCPLect_ArrayList.size()]);
        
        //Insert the list into ComboBox
        cboSupv1.setModel(new javax.swing.DefaultComboBoxModel<>(SupervisorList));
        cboSupv2.setModel(new javax.swing.DefaultComboBoxModel<>(SupervisorList));
        cboSupv3.setModel(new javax.swing.DefaultComboBoxModel<>(SupervisorList));
        
        cbo2ndMkr1.setModel(new javax.swing.DefaultComboBoxModel<>(SecondMarkerList));
        cbo2ndMkr2.setModel(new javax.swing.DefaultComboBoxModel<>(SecondMarkerList));
        cbo2ndMkr3.setModel(new javax.swing.DefaultComboBoxModel<>(SecondMarkerList));
        
        cboRMCP_Lect.setModel(new javax.swing.DefaultComboBoxModel<>(RMCP_LectList));
        
        //Set the selection of advisor based on intake
        int intakeIndex = IntakeRecord.checkIntake(SelectedIntake);
        
        cboSupv1.setSelectedItem(IntakeRecord.IntakeRecordData.get(intakeIndex).Spv1);
        cboSupv2.setSelectedItem(IntakeRecord.IntakeRecordData.get(intakeIndex).Spv2);
        cboSupv3.setSelectedItem(IntakeRecord.IntakeRecordData.get(intakeIndex).Spv3);
        cbo2ndMkr1.setSelectedItem(IntakeRecord.IntakeRecordData.get(intakeIndex).SecondMkr1);
        cbo2ndMkr2.setSelectedItem(IntakeRecord.IntakeRecordData.get(intakeIndex).SecondMkr2);
        cbo2ndMkr3.setSelectedItem(IntakeRecord.IntakeRecordData.get(intakeIndex).SecondMkr3);
        cboRMCP_Lect.setSelectedItem(IntakeRecord.IntakeRecordData.get(intakeIndex).RMCP_Lecturer);
        
        //Set the comboBox unable to select based on assessment type
        switch (assessment) {
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
                cbo2ndMkr1.setEnabled(false);
                cbo2ndMkr2.setEnabled(false);
                cbo2ndMkr3.setEnabled(false);
                cboRMCP_Lect.setEnabled(false);
                break;
            case "RMCP":
                cboSupv1.setEnabled(false);
                cboSupv2.setEnabled(false);
                cboSupv3.setEnabled(false);
                cbo2ndMkr1.setEnabled(false);
                cbo2ndMkr2.setEnabled(false);
                cbo2ndMkr3.setEnabled(false);
                break;
            default:
                cboSupv1.setEnabled(false);
                cboSupv2.setEnabled(false);
                cboSupv3.setEnabled(false);
                cbo2ndMkr1.setEnabled(false);
                cbo2ndMkr2.setEnabled(false);
                cbo2ndMkr3.setEnabled(false);
                cboRMCP_Lect.setEnabled(false);
        }
        mainFrame.changedTab(5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btbBack = new javax.swing.JLabel();
        TabTitle = new javax.swing.JLabel();
        numTotalStu = new javax.swing.JLabel();
        lblTotalStu = new javax.swing.JLabel();
        selectedAssessment = new javax.swing.JLabel();
        SupvPane = new javax.swing.JPanel();
        lblSupvTitle = new javax.swing.JLabel();
        lblSupv1 = new javax.swing.JLabel();
        cboSupv1 = new javax.swing.JComboBox<>();
        cboSupv2 = new javax.swing.JComboBox<>();
        lblSupv2 = new javax.swing.JLabel();
        cboSupv3 = new javax.swing.JComboBox<>();
        lblSupv3 = new javax.swing.JLabel();
        lblAssessment = new javax.swing.JLabel();
        SecondMkrPane = new javax.swing.JPanel();
        lbl2ndMkrTitle = new javax.swing.JLabel();
        lbl2ndMkr1 = new javax.swing.JLabel();
        cbo2ndMkr1 = new javax.swing.JComboBox<>();
        lbl2ndMkr2 = new javax.swing.JLabel();
        cbo2ndMkr2 = new javax.swing.JComboBox<>();
        lbl2ndMkr3 = new javax.swing.JLabel();
        cbo2ndMkr3 = new javax.swing.JComboBox<>();
        RMCP_LectPane = new javax.swing.JPanel();
        lblRMCP_LectTitle = new javax.swing.JLabel();
        cboRMCP_Lect = new javax.swing.JComboBox<>();
        btbAutoAssign = new javax.swing.JButton();
        btbSubmit = new javax.swing.JButton();
        btbManualAssign = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btbBack.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        btbBack.setForeground(new java.awt.Color(0, 0, 0));
        btbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/leftArrow(Black).png"))); // NOI18N
        btbBack.setText("Back...");
        btbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbBackMouseClicked(evt);
            }
        });

        TabTitle.setFont(new java.awt.Font("Dubai Medium", 1, 30)); // NOI18N
        TabTitle.setForeground(new java.awt.Color(0, 0, 0));
        TabTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TabTitle.setText("AG2109");

        numTotalStu.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        numTotalStu.setForeground(new java.awt.Color(0, 0, 0));
        numTotalStu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        numTotalStu.setText("20");

        lblTotalStu.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblTotalStu.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalStu.setText("Total of Student:");

        selectedAssessment.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        selectedAssessment.setForeground(new java.awt.Color(0, 0, 0));
        selectedAssessment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        selectedAssessment.setText("CP2");

        SupvPane.setBackground(new java.awt.Color(217, 217, 217));
        SupvPane.setForeground(new java.awt.Color(217, 217, 217));

        lblSupvTitle.setFont(new java.awt.Font("Dubai Medium", 1, 22)); // NOI18N
        lblSupvTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblSupvTitle.setText("Supervisor");

        lblSupv1.setFont(new java.awt.Font("Dubai Medium", 0, 17)); // NOI18N
        lblSupv1.setForeground(new java.awt.Color(0, 0, 0));
        lblSupv1.setText("Supervisor 1:");

        cboSupv1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboSupv2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSupv2.setFont(new java.awt.Font("Dubai Medium", 0, 17)); // NOI18N
        lblSupv2.setForeground(new java.awt.Color(0, 0, 0));
        lblSupv2.setText("Supervisor 2:");

        cboSupv3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSupv3.setFont(new java.awt.Font("Dubai Medium", 0, 17)); // NOI18N
        lblSupv3.setForeground(new java.awt.Color(0, 0, 0));
        lblSupv3.setText("Supervisor 3:");

        javax.swing.GroupLayout SupvPaneLayout = new javax.swing.GroupLayout(SupvPane);
        SupvPane.setLayout(SupvPaneLayout);
        SupvPaneLayout.setHorizontalGroup(
            SupvPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupvPaneLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(SupvPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SupvPaneLayout.createSequentialGroup()
                        .addComponent(lblSupvTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SupvPaneLayout.createSequentialGroup()
                        .addComponent(lblSupv1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboSupv1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSupv2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboSupv2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(lblSupv3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboSupv3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        SupvPaneLayout.setVerticalGroup(
            SupvPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupvPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSupvTitle)
                .addGap(0, 0, 0)
                .addGroup(SupvPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SupvPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSupv2)
                        .addComponent(cboSupv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SupvPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSupv3)
                        .addComponent(cboSupv3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SupvPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSupv1)
                        .addComponent(cboSupv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblAssessment.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        lblAssessment.setForeground(new java.awt.Color(0, 0, 0));
        lblAssessment.setText("Assessment:");

        SecondMkrPane.setBackground(new java.awt.Color(217, 217, 217));
        SecondMkrPane.setForeground(new java.awt.Color(217, 217, 217));

        lbl2ndMkrTitle.setFont(new java.awt.Font("Dubai Medium", 1, 22)); // NOI18N
        lbl2ndMkrTitle.setForeground(new java.awt.Color(0, 0, 0));
        lbl2ndMkrTitle.setText("Second Marker");

        lbl2ndMkr1.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        lbl2ndMkr1.setForeground(new java.awt.Color(0, 0, 0));
        lbl2ndMkr1.setText("Second Marker 1:");

        cbo2ndMkr1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl2ndMkr2.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        lbl2ndMkr2.setForeground(new java.awt.Color(0, 0, 0));
        lbl2ndMkr2.setText("Second Marker 2:");

        cbo2ndMkr2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl2ndMkr3.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        lbl2ndMkr3.setForeground(new java.awt.Color(0, 0, 0));
        lbl2ndMkr3.setText("Second Marker 3:");

        cbo2ndMkr3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout SecondMkrPaneLayout = new javax.swing.GroupLayout(SecondMkrPane);
        SecondMkrPane.setLayout(SecondMkrPaneLayout);
        SecondMkrPaneLayout.setHorizontalGroup(
            SecondMkrPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecondMkrPaneLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(SecondMkrPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl2ndMkrTitle)
                    .addGroup(SecondMkrPaneLayout.createSequentialGroup()
                        .addComponent(lbl2ndMkr1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo2ndMkr1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lbl2ndMkr2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo2ndMkr2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(lbl2ndMkr3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo2ndMkr3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        SecondMkrPaneLayout.setVerticalGroup(
            SecondMkrPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecondMkrPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl2ndMkrTitle)
                .addGap(0, 0, 0)
                .addGroup(SecondMkrPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecondMkrPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl2ndMkr3)
                        .addComponent(cbo2ndMkr3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SecondMkrPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl2ndMkr2)
                        .addComponent(cbo2ndMkr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SecondMkrPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl2ndMkr1)
                        .addComponent(cbo2ndMkr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        RMCP_LectPane.setBackground(new java.awt.Color(217, 217, 217));
        RMCP_LectPane.setForeground(new java.awt.Color(217, 217, 217));

        lblRMCP_LectTitle.setFont(new java.awt.Font("Dubai Medium", 1, 22)); // NOI18N
        lblRMCP_LectTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblRMCP_LectTitle.setText("RMCP Lecturer");

        cboRMCP_Lect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout RMCP_LectPaneLayout = new javax.swing.GroupLayout(RMCP_LectPane);
        RMCP_LectPane.setLayout(RMCP_LectPaneLayout);
        RMCP_LectPaneLayout.setHorizontalGroup(
            RMCP_LectPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RMCP_LectPaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblRMCP_LectTitle)
                .addGap(18, 18, 18)
                .addComponent(cboRMCP_Lect, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        RMCP_LectPaneLayout.setVerticalGroup(
            RMCP_LectPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RMCP_LectPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(RMCP_LectPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRMCP_LectTitle)
                    .addComponent(cboRMCP_Lect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btbAutoAssign.setBackground(new java.awt.Color(76, 184, 193));
        btbAutoAssign.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        btbAutoAssign.setForeground(new java.awt.Color(255, 255, 255));
        btbAutoAssign.setText("Auto Assign");
        btbAutoAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbAutoAssignActionPerformed(evt);
            }
        });

        btbSubmit.setBackground(new java.awt.Color(76, 184, 193));
        btbSubmit.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        btbSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btbSubmit.setText("Submit");
        btbSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbSubmitActionPerformed(evt);
            }
        });

        btbManualAssign.setBackground(new java.awt.Color(76, 184, 193));
        btbManualAssign.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        btbManualAssign.setForeground(new java.awt.Color(255, 255, 255));
        btbManualAssign.setText("Manual Assign..");
        btbManualAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbManualAssignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btbBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAssessment)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(selectedAssessment)
                                .addGap(100, 100, 100)
                                .addComponent(lblTotalStu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numTotalStu))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TabTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btbManualAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addComponent(SupvPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SecondMkrPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RMCP_LectPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btbSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btbAutoAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btbBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TabTitle)
                    .addComponent(btbManualAssign))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numTotalStu)
                    .addComponent(lblTotalStu)
                    .addComponent(selectedAssessment)
                    .addComponent(lblAssessment))
                .addGap(18, 18, 18)
                .addComponent(SupvPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SecondMkrPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RMCP_LectPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbAutoAssign)
                    .addComponent(btbSubmit))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbBackMouseClicked
        
        //Back to previous page
        mainFrame.createIntakeListPane(mainFrame);
        int tabIndex = mainFrame.TabPanel.getTabCount()-1;
        mainFrame.changedTab(tabIndex);
    }//GEN-LAST:event_btbBackMouseClicked

    private void btbAutoAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbAutoAssignActionPerformed
        boolean selectionCheck = true;

        //Advisors Submission
        switch (Assessment) {
            case "Investigation Report":
                selectionCheck = commonAssesSubmit();
                break;
            case "CP1":
                selectionCheck = commonAssesSubmit();
                break;
            case "CP2":
                selectionCheck = commonAssesSubmit();
                break;
            case "FYP":
                selectionCheck = commonAssesSubmit();
                break;
            case "Intern":
                selectionCheck = internAssesSubmit();
                break;
            case "RMCP":
                RMCPAssesSubmit();
                break;
            default:
                JOptionPane.showMessageDialog(null,"This intake haven't assign assessment.");
        }
        
        if (selectionCheck == true) {
            //Auto assign to student
            ProjManager.autoAssignAdvisor(SelectedIntake, Assessment);

            //Back to previous page
            mainFrame.createIntakeListPane(mainFrame);
            int tabIndex = mainFrame.TabPanel.getTabCount()-1;
            mainFrame.changedTab(tabIndex);
        }
    }//GEN-LAST:event_btbAutoAssignActionPerformed

    private void btbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbSubmitActionPerformed
        boolean selectionCheck = true;

        //Advisors Submission
        switch (Assessment) {
            case "Investigation Report":
                selectionCheck = commonAssesSubmit();
                break;
            case "CP1":
                selectionCheck = commonAssesSubmit();
                break;
            case "CP2":
                selectionCheck = commonAssesSubmit();
                break;
            case "FYP":
                selectionCheck = commonAssesSubmit();
                break;
            case "Intern":
                selectionCheck = internAssesSubmit();
                break;
            case "RMCP":
                RMCPAssesSubmit();
                break;
            default:
                JOptionPane.showMessageDialog(null,"This intake haven't assign assessment.");
        }
        
        if (selectionCheck == true) {
            //Back to previous page
            mainFrame.createIntakeListPane(mainFrame);
            int tabIndex = mainFrame.TabPanel.getTabCount()-1;
            mainFrame.changedTab(tabIndex);
        }
    }//GEN-LAST:event_btbSubmitActionPerformed

    private void btbManualAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbManualAssignActionPerformed
        boolean selectionCheck = true;

        //Advisors Submission
        switch (Assessment) {
            case "Investigation Report":
                selectionCheck = commonAssesSubmit();
                break;
            case "CP1":
                selectionCheck = commonAssesSubmit();
                break;
            case "CP2":
                selectionCheck = commonAssesSubmit();
                break;
            case "FYP":
                selectionCheck = commonAssesSubmit();
                break;
            case "Intern":
                selectionCheck = internAssesSubmit();
                break;
            case "RMCP":
                RMCPAssesSubmit();
                break;
            default:
                JOptionPane.showMessageDialog(null,"This intake haven't assign assessment.");
        }

        if (selectionCheck == true) {
            // Switch to manual assign advisor tab
            mainFrame.createStuAdvsListPane(mainFrame, SelectedIntake, Assessment);
            int tabIndex = mainFrame.TabPanel.getTabCount()-1;
            mainFrame.changedTab(tabIndex);
        }
    }//GEN-LAST:event_btbManualAssignActionPerformed

    //Submission Method for Invstigation Report, CP1, CP2, FYP
    private boolean commonAssesSubmit(){
        Set<String> SpvSet = new HashSet<>();
        Set<String> SecondMkrSet = new HashSet<>();
        int intakeIndex = IntakeRecord.checkIntake(SelectedIntake);
        
        //Rerieve data from comboBox
        String Spv1 = (String) cboSupv1.getSelectedItem();
        String Spv2 = (String) cboSupv2.getSelectedItem();
        String Spv3 = (String) cboSupv3.getSelectedItem();
        String SecondMkr1 = (String) cbo2ndMkr1.getSelectedItem();
        String SecondMkr2 = (String) cbo2ndMkr2.getSelectedItem();
        String SecondMkr3 = (String) cbo2ndMkr3.getSelectedItem();
        
        //Add data into HashSet
        SpvSet.add(Spv1);
        SpvSet.add(Spv2);
        SpvSet.add(Spv3);
        SecondMkrSet.add(SecondMkr1);
        SecondMkrSet.add(SecondMkr2);
        SecondMkrSet.add(SecondMkr3);
        
        //Checking is there any repeated selection
        if (SpvSet.size() == 3 && SecondMkrSet.size() == 3 || (Spv1.equals("-") && Spv2.equals("-") && Spv3.equals("-")) || 
        (Spv1.equals("-") && Spv2.equals("-")) || (Spv2.equals("-") && Spv3.equals("-")) ||
        (Spv1.equals("-") && Spv3.equals("-")) || (SecondMkr1.equals("-") && SecondMkr2.equals("-") && SecondMkr3.equals("-")) || 
        (SecondMkr1.equals("-") && SecondMkr2.equals("-")) || (SecondMkr2.equals("-") && SecondMkr3.equals("-")) ||
        (SecondMkr1.equals("-") && SecondMkr3.equals("-"))) {
            IntakeRecord editedRecord = new IntakeRecord(SelectedIntake, Assessment, Spv1, Spv2, Spv3, SecondMkr1, SecondMkr2, SecondMkr3, "-");
            IntakeRecord.edit(intakeIndex, editedRecord);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"You cannot select the same lecturer as supervisor / second marker.", "Invalid Selection", JOptionPane.ERROR_MESSAGE);
            
            cboSupv1.setSelectedItem(Spv1);
            cboSupv2.setSelectedItem(Spv2);
            cboSupv3.setSelectedItem(Spv3);
            cbo2ndMkr1.setSelectedItem(SecondMkr1);
            cbo2ndMkr2.setSelectedItem(SecondMkr2);
            cbo2ndMkr3.setSelectedItem(SecondMkr3);
            return false;
        } 
    }
    
    //Submission Method for Intern
    private boolean internAssesSubmit(){
        Set<String> SpvSet = new HashSet<>();
        int intakeIndex = IntakeRecord.checkIntake(SelectedIntake);
        
        //Rerieve data from comboBox
        String Spv1 = (String) cboSupv1.getSelectedItem();
        String Spv2 = (String) cboSupv2.getSelectedItem();
        String Spv3 = (String) cboSupv3.getSelectedItem();
        
        //Add data into HashSet
        SpvSet.add(Spv1);
        SpvSet.add(Spv2);
        SpvSet.add(Spv3);

        //Checking is there any repeated selection
        if (SpvSet.size() == 3 || (Spv1.equals("-") && Spv2.equals("-") && Spv3.equals("-")) || 
        (Spv1.equals("-") && Spv2.equals("-")) || (Spv2.equals("-") && Spv3.equals("-")) ||
        (Spv1.equals("-") && Spv3.equals("-"))) {
            IntakeRecord editedRecord = new IntakeRecord(SelectedIntake, Assessment, Spv1, Spv2, Spv3, "-", "-", "-", "-");
            IntakeRecord.edit(intakeIndex, editedRecord);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"You cannot select the same lecturer as supervisor.", "Invalid Selection", JOptionPane.ERROR_MESSAGE);
            
            cboSupv1.setSelectedItem(Spv1);
            cboSupv2.setSelectedItem(Spv2);
            cboSupv3.setSelectedItem(Spv3);
            return false;
        } 
    }
    
    //Submission Method for RMCP
    private void RMCPAssesSubmit(){
        int intakeIndex = IntakeRecord.checkIntake(SelectedIntake);
        
        String RMCP_Lect = (String) cboRMCP_Lect.getSelectedItem();
        
        IntakeRecord editedRecord = new IntakeRecord(SelectedIntake, Assessment, "-", "-", "-", "-", "-", "-", RMCP_Lect);
        IntakeRecord.edit(intakeIndex, editedRecord);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RMCP_LectPane;
    private javax.swing.JPanel SecondMkrPane;
    private javax.swing.JPanel SupvPane;
    private javax.swing.JLabel TabTitle;
    private javax.swing.JButton btbAutoAssign;
    private javax.swing.JLabel btbBack;
    private javax.swing.JButton btbManualAssign;
    private javax.swing.JButton btbSubmit;
    private javax.swing.JComboBox<String> cbo2ndMkr1;
    private javax.swing.JComboBox<String> cbo2ndMkr2;
    private javax.swing.JComboBox<String> cbo2ndMkr3;
    private javax.swing.JComboBox<String> cboRMCP_Lect;
    private javax.swing.JComboBox<String> cboSupv1;
    private javax.swing.JComboBox<String> cboSupv2;
    private javax.swing.JComboBox<String> cboSupv3;
    private javax.swing.JLabel lbl2ndMkr1;
    private javax.swing.JLabel lbl2ndMkr2;
    private javax.swing.JLabel lbl2ndMkr3;
    private javax.swing.JLabel lbl2ndMkrTitle;
    private javax.swing.JLabel lblAssessment;
    private javax.swing.JLabel lblRMCP_LectTitle;
    private javax.swing.JLabel lblSupv1;
    private javax.swing.JLabel lblSupv2;
    private javax.swing.JLabel lblSupv3;
    private javax.swing.JLabel lblSupvTitle;
    private javax.swing.JLabel lblTotalStu;
    private javax.swing.JLabel numTotalStu;
    private javax.swing.JLabel selectedAssessment;
    // End of variables declaration//GEN-END:variables
}
