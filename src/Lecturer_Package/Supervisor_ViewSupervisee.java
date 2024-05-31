package Lecturer_Package;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Java_Assignment.Session;
import ProjManagerPackage.AccMgmtElem.TableHeader_AccTbl;
import ProjManagerPackage.StuAssesElem.ModernScrollBarUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class Supervisor_ViewSupervisee extends javax.swing.JPanel {

    private Lecture_mainframe lectmainframe;
    private String UserName; 

    public Supervisor_ViewSupervisee(Lecture_mainframe lectmainframe) {
        this.lectmainframe = lectmainframe;
        this.UserName = Session.getUserID();
        initComponents();
        /* Set the scrollbar to customize scrollbar*/
        fixTable(jScrollPane1);
        
        /* Set the header to customize header */
        Supervisor_Supervisee_Table.getTableHeader().setReorderingAllowed(false);
        Supervisor_Supervisee_Table.getTableHeader().setResizingAllowed(false);
        Supervisor_Supervisee_Table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
             @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_AccTbl header = new TableHeader_AccTbl(o + "");
                return header;
            }
        });
        
        populateTable();
        Supervisor_Supervisee_Table.setRowHeight(40);
    }
    
    
    
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) Supervisor_Supervisee_Table.getModel();
        model.setRowCount(0); // Clear existing rows in the table model

        // Read data from StuData.txt file
        try (BufferedReader reader = new BufferedReader(new FileReader("StuData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                // Check if Supervisor is "shahab"
                if (parts.length >= 9 && parts[6].trim().equalsIgnoreCase(UserName)) {
                    // Add only required data to the table model
                    model.addRow(new Object[]{parts[0], parts[2], parts[3], parts[4], parts[5]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading Student data file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Supervisor_Supervisee_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(248, 246, 227));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        Supervisor_Supervisee_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Age", "Intake", "Assessment"
            }
        ));
        jScrollPane1.setViewportView(Supervisor_Supervisee_Table);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Supervisor_Supervisee_Table;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
