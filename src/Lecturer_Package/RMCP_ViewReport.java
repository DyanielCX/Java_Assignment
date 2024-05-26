package Lecturer_Package;

import Java_Assignment.Session;
import ProjManagerPackage.AccMgmtElem.TableHeader_AccTbl;
import ProjManagerPackage.StuAssesElem.ModernScrollBarUI;
import ProjManagerPackage.StuAssesElem.TableActionCellEditor_EditButton;
import ProjManagerPackage.StuAssesElem.TableActionCellRender_EditButton;
import ProjManagerPackage.StuAssesElem.TableActionEvent_EditButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class RMCP_ViewReport extends javax.swing.JPanel {
    
    private Lecture_mainframe lectmainframe;
    private String UserName; 

    public RMCP_ViewReport(Lecture_mainframe mainFrame) {
        this.lectmainframe = mainFrame;
        this.UserName = Session.getUserID();
        initComponents();
        
        /* Set the scrollbar to customize scrollbar*/
        fixTable(jScrollPane1);

        /* Set the header to customize header */
        RMCP_Report_Table.getTableHeader().setReorderingAllowed(false);
        RMCP_Report_Table.getTableHeader().setResizingAllowed(false);
        RMCP_Report_Table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_AccTbl header = new TableHeader_AccTbl(o + "");
                return header;
            }
        });
        populateTable();
      
        RMCP_Report_Table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender_EditButton());
        RMCP_Report_Table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor_EditButton(event));       
    }
    
    TableActionEvent_EditButton event = new TableActionEvent_EditButton() {
        @Override
        public void onEdit(int row) {
            // Get the student ID from the table model
            String studentId = (String) RMCP_Report_Table.getValueAt(row, 0);

            // Check the grading status and submit status
            String gradingStatus = (String) RMCP_Report_Table.getValueAt(row, 3);
            String submitStatus = (String) RMCP_Report_Table.getValueAt(row, 2);

            if (!submitStatus.equals("No Attempt") && !gradingStatus.equals("Not Graded")) {
                JOptionPane.showMessageDialog(RMCP_ViewReport.this, "This report has not been attempted and not graded.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Create and show the SecondMarker_GradingFrame
                SecondMarker_GradingFrame gradingFrame = new SecondMarker_GradingFrame(lectmainframe, studentId);
                gradingFrame.setVisible(true);
                lectmainframe.setVisible(false); // Hide the main frame
            }
        }
    };
    
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) RMCP_Report_Table.getModel();
        model.setRowCount(0); // Clear existing rows in the table model

        Map<String, String[]> studentDataMap = new HashMap<>(); // To store student data

        // Read data from StuData.txt file
        try (BufferedReader stuReader = new BufferedReader(new FileReader("StuData.txt"))) {
            String stuLine;
            while ((stuLine = stuReader.readLine()) != null) {
                String[] stuParts = stuLine.split(",");

                // Check if Second Marker matches UserName
                if (stuParts.length >= 9 && stuParts[8].trim().equalsIgnoreCase(UserName)) {
                    studentDataMap.put(stuParts[0].trim(), stuParts); // Store student data by ID
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading Student data file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Read data from ReportData.txt file
        try (BufferedReader reportReader = new BufferedReader(new FileReader("ReportData.txt"))) {
            String reportLine;
            while ((reportLine = reportReader.readLine()) != null) {
                String[] reportParts = reportLine.split(",");

                // Check if Student ID exists in studentDataMap
                if (reportParts.length >= 9 && studentDataMap.containsKey(reportParts[0].trim())) {
                    String[] stuParts = studentDataMap.get(reportParts[0].trim());

                    // Combine data from both files as needed for display
                    model.addRow(new Object[]{
                        stuParts[0].trim(),  // Student ID
                        stuParts[2].trim(),  // Name
                        stuParts[4].trim(),  // Intake
                        stuParts[5].trim(),  // Assessment
                        reportParts[4].trim(),  // Submission Due Date
                        reportParts[2].trim(),  // Submit Status
                        reportParts[3].trim(),  // Grading Status
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading Report data file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void fixTable(JScrollPane scroll) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        RMCP_Report_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(248, 246, 227));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        RMCP_Report_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Intake", "Assessment", "Due Date", "Submission", "Grading", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RMCP_Report_Table.setRowHeight(40);
        jScrollPane1.setViewportView(RMCP_Report_Table);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RMCP_Report_Table;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
