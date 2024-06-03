package Lecturer_Package;

import Java_Assignment.Session;
import ProjManagerPackage.AccMgmtElem.TableHeader_AccTbl;
import ProjManagerPackage.StuAssesElem.ModernScrollBarUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class RMCP_ViewSupervisee extends javax.swing.JPanel {

   private Lecture_mainframe lectmainframe;
   private String UserName; 

    public RMCP_ViewSupervisee(Lecture_mainframe lectmainframe) {
        this.lectmainframe = lectmainframe;
        this.UserName = Session.getUserID();
        initComponents();
        
        /* Set the scrollbar to customize scrollbar*/
        fixTable(jScrollPane1);
        
        /* Set the header to customize header */
        RMCP_Supervisee_Table.getTableHeader().setReorderingAllowed(false);
        RMCP_Supervisee_Table.getTableHeader().setResizingAllowed(false);
        RMCP_Supervisee_Table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
             @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_AccTbl header = new TableHeader_AccTbl(o + "");
                return header;
            }
        });
        
        populateTable();
        RMCP_Supervisee_Table.setRowHeight(40);
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) RMCP_Supervisee_Table.getModel();

        model.setRowCount(0); // Clear existing rows in the table model

        // Read data from StuData.txt file
        try (BufferedReader reader = new BufferedReader(new FileReader("StuData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                // Check if Supervisor is "shahab"
                if (parts.length >= 9 && parts[8].trim().equalsIgnoreCase(UserName)) {
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
        RMCP_Supervisee_Table = new javax.swing.JTable();
        Back_lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 246, 227));
        setMaximumSize(new java.awt.Dimension(32767, 32767));
        setMinimumSize(new java.awt.Dimension(909, 579));
        setPreferredSize(new java.awt.Dimension(909, 579));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RMCP_Supervisee_Table.setModel(new javax.swing.table.DefaultTableModel(
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
        RMCP_Supervisee_Table.setMaximumSize(new java.awt.Dimension(2147483647, 160));
        RMCP_Supervisee_Table.setMinimumSize(new java.awt.Dimension(120, 160));
        RMCP_Supervisee_Table.setPreferredSize(new java.awt.Dimension(600, 160));
        jScrollPane1.setViewportView(RMCP_Supervisee_Table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 910, 520));

        Back_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        Back_lbl.setText("Back");
        Back_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Back_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Back_lblMouseClicked(evt);
            }
        });
        add(Back_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("RMCP");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void Back_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_lblMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        lectmainframe.changeTab(1);
    }//GEN-LAST:event_Back_lblMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back_lbl;
    private javax.swing.JTable RMCP_Supervisee_Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
