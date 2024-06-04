package ProjManagerPackage;

import ProjManagerPackage.AssignSupvElem.LectData_IO;
import ProjManagerPackage.DashboardElem.TableActionCellRender_DashRptStatusIcon;
import ProjManagerPackage.DashboardElem.TableHeader_Dashboard;
import ProjManagerPackage.StuAssesElem.IntakeBasedMethod;
import ProjManagerPackage.StuAssesElem.ModernScrollBarUI;
import StuPackage.StuData_IO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Dashboard extends javax.swing.JPanel {

    private ProjManager_MainFrame mainFrame;
    
    public Dashboard(ProjManager_MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        
        //Customize Table Modification
        /* Set the scrollbar to customize scrollbar*/
        fixTable(jScrollPane1);
        
        /* Set the header to customize header */
        StuRptStatusTable.getTableHeader().setReorderingAllowed(false);
        StuRptStatusTable.getTableHeader().setResizingAllowed(false);
        StuRptStatusTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_Dashboard header = new TableHeader_Dashboard(o + "");
                return header;
            }
        });

        //Get total intake, total student & total lecturer
        ArrayList<String> intakeList = IntakeBasedMethod.getIntake();
        
        lblNumIntake.setText(Integer.toString(intakeList.size()));   
        lblNumStu.setText(Integer.toString(StuData_IO.StuData.size()));
        lblNumLect.setText(Integer.toString(LectData_IO.LectData.size()));
        
        /* Insert data into table */
        // Generate 5 unique random index for get student data
        Random rand = new Random();
        int size = StuData_IO.StuData.size();
        Set<Integer> uniqueRandomNumbers = new HashSet<>();
        
        while (uniqueRandomNumbers.size() < 5) {
            int randInt = rand.nextInt(size);
            uniqueRandomNumbers.add(randInt);
        }
        
        // Convert the set to a list to retrieve elements by index
        List<Integer> randomNumbersList = new ArrayList<>(uniqueRandomNumbers);

        
        // Retrieve student data
        for (int i=0; i < 5; i++){
            int rantNum = randomNumbersList.get(i);
            
            String StuName = StuData_IO.StuData.get(rantNum).name;
            String StuID = StuData_IO.StuData.get(rantNum).id;
            String Intake = StuData_IO.StuData.get(rantNum).intake;
            String Assessment = StuData_IO.StuData.get(rantNum).assessment;

            Object[] InsertRow = {StuName, StuID, Intake, Assessment};

            DefaultTableModel model = (DefaultTableModel) StuRptStatusTable.getModel();
            model.addRow(InsertRow);

            //Get the report status
            try{
                Scanner scan = new Scanner(new File("ReportData.txt"));

                while(scan.hasNext()){
                    String currentLine = scan.nextLine();
                    String[] StuData_Array = currentLine.split(",");

                    if (StuData_Array[0].trim().equals(StuID)) {
                        String SubmitStatus = StuData_Array[2];
                        String GradeStatus = StuData_Array[3];

                        StuRptStatusTable.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender_DashRptStatusIcon());

                        if (SubmitStatus.equals("No Attempt")) {
                            model.setValueAt(TableActionCellRender_DashRptStatusIcon.STATUS_NOSUBMITTED, model.getRowCount() - 1, 4);
                        }else{
                            if (GradeStatus.equals("Not Graded") || GradeStatus.equals("Half Graded")) {
                                model.setValueAt(TableActionCellRender_DashRptStatusIcon.STATUS_PENDING, model.getRowCount() - 1, 4);
                            }else{
                                model.setValueAt(TableActionCellRender_DashRptStatusIcon.STATUS_MARKED, model.getRowCount() - 1, 4);
                            }
                        }
                    }
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,"!Read student report status error!");
            }
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

        boxRptStatus = new javax.swing.JPanel();
        btbSeeMore = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StuRptStatusTable = new javax.swing.JTable();
        TabTitle = new javax.swing.JLabel();
        boxTtlLect = new javax.swing.JPanel();
        lblNumLect = new javax.swing.JLabel();
        lblTtlLect = new javax.swing.JLabel();
        LectIcon = new javax.swing.JLabel();
        boxTtlIntake = new javax.swing.JPanel();
        IntakeIcon = new javax.swing.JLabel();
        lblTtlIntake = new javax.swing.JLabel();
        lblNumIntake = new javax.swing.JLabel();
        boxTtlStu = new javax.swing.JPanel();
        lblTtlStu = new javax.swing.JLabel();
        lblNumStu = new javax.swing.JLabel();
        StuIcon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(238, 238, 238));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boxRptStatus.setBackground(new java.awt.Color(255, 255, 255));
        boxRptStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btbSeeMore.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        btbSeeMore.setForeground(new java.awt.Color(0, 0, 0));
        btbSeeMore.setText("See More...");
        btbSeeMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbSeeMoreMouseClicked(evt);
            }
        });
        boxRptStatus.add(btbSeeMore, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 70, 30));

        StuRptStatusTable.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        StuRptStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Student ID", "Intake", "Assessment", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StuRptStatusTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StuRptStatusTable.setRowHeight(40);
        jScrollPane1.setViewportView(StuRptStatusTable);

        boxRptStatus.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 840, 290));

        TabTitle.setFont(new java.awt.Font("Dubai Medium", 0, 23)); // NOI18N
        TabTitle.setForeground(new java.awt.Color(0, 0, 0));
        TabTitle.setText("Report Status");
        boxRptStatus.add(TabTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 30));

        add(boxRptStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 880, 350));

        boxTtlLect.setBackground(new java.awt.Color(137, 225, 96));
        boxTtlLect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumLect.setFont(new java.awt.Font("Dubai Medium", 1, 30)); // NOI18N
        lblNumLect.setForeground(new java.awt.Color(255, 255, 255));
        lblNumLect.setText("20");
        boxTtlLect.add(lblNumLect, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        lblTtlLect.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        lblTtlLect.setForeground(new java.awt.Color(255, 255, 255));
        lblTtlLect.setText("Total Lecturer");
        boxTtlLect.add(lblTtlLect, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        LectIcon.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        LectIcon.setForeground(new java.awt.Color(255, 255, 255));
        LectIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Dashboard_Lect.png"))); // NOI18N
        boxTtlLect.add(LectIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        add(boxTtlLect, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 270, 130));

        boxTtlIntake.setBackground(new java.awt.Color(200, 88, 239));
        boxTtlIntake.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IntakeIcon.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        IntakeIcon.setForeground(new java.awt.Color(255, 255, 255));
        IntakeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Darshboard_Intake.png"))); // NOI18N
        boxTtlIntake.add(IntakeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        lblTtlIntake.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        lblTtlIntake.setForeground(new java.awt.Color(255, 255, 255));
        lblTtlIntake.setText("Total Intake");
        boxTtlIntake.add(lblTtlIntake, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblNumIntake.setFont(new java.awt.Font("Dubai Medium", 1, 30)); // NOI18N
        lblNumIntake.setForeground(new java.awt.Color(255, 255, 255));
        lblNumIntake.setText("4");
        boxTtlIntake.add(lblNumIntake, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        add(boxTtlIntake, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 270, 130));

        boxTtlStu.setBackground(new java.awt.Color(234, 175, 86));
        boxTtlStu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTtlStu.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        lblTtlStu.setForeground(new java.awt.Color(255, 255, 255));
        lblTtlStu.setText("Total Student");
        boxTtlStu.add(lblTtlStu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblNumStu.setFont(new java.awt.Font("Dubai Medium", 1, 30)); // NOI18N
        lblNumStu.setForeground(new java.awt.Color(255, 255, 255));
        lblNumStu.setText("30");
        boxTtlStu.add(lblNumStu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        StuIcon.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        StuIcon.setForeground(new java.awt.Color(255, 255, 255));
        StuIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Dashboard_Stu.png"))); // NOI18N
        boxTtlStu.add(StuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        add(boxTtlStu, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 270, 130));
    }// </editor-fold>//GEN-END:initComponents

    private void btbSeeMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbSeeMoreMouseClicked
        mainFrame.DashboardPane.setBackground(new Color(122, 162, 227));
        mainFrame.ReportStatusPane.setBackground(new Color(106, 212, 221));
        mainFrame.PanelTitle.setText("Report Status");
        mainFrame.changedTab(8);
    }//GEN-LAST:event_btbSeeMoreMouseClicked

    /* Customize the scrollbar for table */
    public void fixTable (JScrollPane scroll){
        scroll.getViewport().setBackground(Color.WHITE);
        
        JScrollBar verticalScrollBar = scroll.getVerticalScrollBar();
        verticalScrollBar.setUI(new ModernScrollBarUI());

        // Set other properties of the vertical scroll bar
        verticalScrollBar.setPreferredSize(new Dimension(3, 5));
        verticalScrollBar.setForeground(new Color(71, 105, 231, 178));
        verticalScrollBar.setUnitIncrement(20);
        verticalScrollBar.setOpaque(false);
        
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IntakeIcon;
    private javax.swing.JLabel LectIcon;
    private javax.swing.JLabel StuIcon;
    private javax.swing.JTable StuRptStatusTable;
    private javax.swing.JLabel TabTitle;
    private javax.swing.JPanel boxRptStatus;
    private javax.swing.JPanel boxTtlIntake;
    private javax.swing.JPanel boxTtlLect;
    private javax.swing.JPanel boxTtlStu;
    private javax.swing.JLabel btbSeeMore;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumIntake;
    private javax.swing.JLabel lblNumLect;
    private javax.swing.JLabel lblNumStu;
    private javax.swing.JLabel lblTtlIntake;
    private javax.swing.JLabel lblTtlLect;
    private javax.swing.JLabel lblTtlStu;
    // End of variables declaration//GEN-END:variables
}
