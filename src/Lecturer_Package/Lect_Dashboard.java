/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Lecturer_Package;
import Java_Assignment.Session;
import ProjManagerPackage.Dashboard;
import ProjManagerPackage.DashboardElem.TableHeader_Dashboard;
import ProjManagerPackage.ProjManager_MainFrame;
import ProjManagerPackage.StuAssesElem.ModernScrollBarUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import Lecturer_Package.presentationReq;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author User
 */

public class Lect_Dashboard extends javax.swing.JPanel {
private Lecture_mainframe lectmainframe;
    /**
     * Creates new form Lect_Dashboard
     */
    public Lect_Dashboard(Lecture_mainframe lectmainframe) {
          if (Session.isLoggedIn()) {
    
    String username = Session.getUserID();
    System.out.println("Logged in as: " + username);
} else {
    
    System.out.println("No user logged in.");
}
        initComponents();
         this.lectmainframe = lectmainframe;
           String UserName = Session.getUserID();
           lectName.setText(UserName);
         Admin admin = new Admin(AssignedStuTbl);
         admin.populateDashBoardTable(AssignedStuTbl,Session.getUserID());
          int numberOfSupervisees = AssignedStuTbl.getRowCount();
         assigned_Supervisees.setText(String.valueOf(numberOfSupervisees));
          updatePresentationDateLabel("PresentationData.txt");
          
            fixTable(jScrollPane1);
        
        /* Set the header to customize header */
        AssignedStuTbl.getTableHeader().setReorderingAllowed(false);
        AssignedStuTbl.getTableHeader().setResizingAllowed(false);
        AssignedStuTbl.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_Dashboard header = new TableHeader_Dashboard(o + "");
                return header;
            }
        });
        
       
        AssignedStuTbl.getTableHeader().setReorderingAllowed(false);
        AssignedStuTbl.getTableHeader().setResizingAllowed(false);
        AssignedStuTbl.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_Dashboard header = new TableHeader_Dashboard(o + "");
                return header;
            }
        });
         
    }

 private void updatePresentationDateLabel(String filePath) {
  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
  Date currentDate = new Date();

  String closestDate = null;
  long minDifference = Long.MAX_VALUE;

  try (Scanner scanner = new Scanner(new File(filePath))) {
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] data = line.split(","); // Split the line based on commas (",")

      try {
        // Assuming presentation date is at index 3 based on your data structure
        Date date = dateFormat.parse(data[3]);
        long difference = Math.abs(date.getTime() - currentDate.getTime());
        if (difference < minDifference) {
          minDifference = difference;
          closestDate = data[3]; // Store the actual date string
        }
      } catch (ParseException e) {
        // Handle parsing exceptions for invalid dates in the file
        System.err.println("Error parsing date in PresentationData.txt: " + line);
      } catch (IndexOutOfBoundsException e) {
        // Handle cases where data doesn't have expected number of elements
        System.err.println("Invalid data format in PresentationData.txt: " + line);
      }
    }
  } catch (FileNotFoundException e) {
    // Handle file not found exception
    System.err.println("PresentationData.txt file not found!");
  }

  if (closestDate != null) {
    presentationDate.setText(closestDate);
  } else {
    presentationDate.setText("No upcoming presentations found in file.");
  }
}
     
      public  void fixTable (JScrollPane scroll){
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boxRptStatus = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AssignedStuTbl = new javax.swing.JTable();
        TabTitle = new javax.swing.JLabel();
        lectName = new javax.swing.JLabel();
        boxTtlLect = new javax.swing.JPanel();
        lblTtlLect = new javax.swing.JLabel();
        LectIcon = new javax.swing.JLabel();
        presentationDate = new javax.swing.JLabel();
        boxTtlIntake = new javax.swing.JPanel();
        IntakeIcon = new javax.swing.JLabel();
        lblTtlIntake = new javax.swing.JLabel();
        lblNumIntake = new javax.swing.JLabel();
        boxTtlStu = new javax.swing.JPanel();
        lblTtlStu = new javax.swing.JLabel();
        lblNumStu = new javax.swing.JLabel();
        StuIcon = new javax.swing.JLabel();
        assigned_Supervisees = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boxRptStatus.setBackground(new java.awt.Color(255, 255, 255));
        boxRptStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AssignedStuTbl.setFont(new java.awt.Font("Dubai Medium", 0, 17)); // NOI18N
        AssignedStuTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Number", "Student Name", "Intake", "Course", "Supervisor", "Second Marker", "RMCP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AssignedStuTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AssignedStuTbl.setRowHeight(40);
        jScrollPane1.setViewportView(AssignedStuTbl);

        boxRptStatus.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 850, 300));

        TabTitle.setFont(new java.awt.Font("Dubai Medium", 0, 23)); // NOI18N
        TabTitle.setForeground(new java.awt.Color(0, 0, 0));
        TabTitle.setText("Assigned Supervisees for ");
        boxRptStatus.add(TabTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 250, 30));

        lectName.setFont(new java.awt.Font("Dubai Medium", 1, 23)); // NOI18N
        lectName.setText("jLabel1");
        boxRptStatus.add(lectName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 80, 40));

        jPanel1.add(boxRptStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 880, 350));

        boxTtlLect.setBackground(new java.awt.Color(137, 225, 96));
        boxTtlLect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTtlLect.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        lblTtlLect.setForeground(new java.awt.Color(255, 255, 255));
        lblTtlLect.setText("Next Presentation");
        boxTtlLect.add(lblTtlLect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        LectIcon.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        LectIcon.setForeground(new java.awt.Color(255, 255, 255));
        LectIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Dashboard_Lect.png"))); // NOI18N
        boxTtlLect.add(LectIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        presentationDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        presentationDate.setForeground(new java.awt.Color(255, 255, 255));
        boxTtlLect.add(presentationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 250, 60));

        jPanel1.add(boxTtlLect, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 270, 130));

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

        jPanel1.add(boxTtlIntake, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 270, 130));

        boxTtlStu.setBackground(new java.awt.Color(234, 175, 86));
        boxTtlStu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTtlStu.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        lblTtlStu.setForeground(new java.awt.Color(255, 255, 255));
        lblTtlStu.setText("Assigned Supervisees");
        boxTtlStu.add(lblTtlStu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblNumStu.setFont(new java.awt.Font("Dubai Medium", 1, 30)); // NOI18N
        lblNumStu.setForeground(new java.awt.Color(255, 255, 255));
        boxTtlStu.add(lblNumStu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        StuIcon.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        StuIcon.setForeground(new java.awt.Color(255, 255, 255));
        StuIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Dashboard_Stu.png"))); // NOI18N
        boxTtlStu.add(StuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        assigned_Supervisees.setFont(new java.awt.Font("Dubai Medium", 1, 30)); // NOI18N
        assigned_Supervisees.setForeground(new java.awt.Color(255, 255, 255));
        boxTtlStu.add(assigned_Supervisees, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, 30));

        jPanel1.add(boxTtlStu, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 270, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 935, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AssignedStuTbl;
    private javax.swing.JLabel IntakeIcon;
    private javax.swing.JLabel LectIcon;
    private javax.swing.JLabel StuIcon;
    private javax.swing.JLabel TabTitle;
    private javax.swing.JLabel assigned_Supervisees;
    private javax.swing.JPanel boxRptStatus;
    private javax.swing.JPanel boxTtlIntake;
    private javax.swing.JPanel boxTtlLect;
    private javax.swing.JPanel boxTtlStu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumIntake;
    private javax.swing.JLabel lblNumStu;
    private javax.swing.JLabel lblTtlIntake;
    private javax.swing.JLabel lblTtlLect;
    private javax.swing.JLabel lblTtlStu;
    private javax.swing.JLabel lectName;
    public javax.swing.JLabel presentationDate;
    // End of variables declaration//GEN-END:variables
}
