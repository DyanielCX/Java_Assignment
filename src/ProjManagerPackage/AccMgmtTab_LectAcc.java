package ProjManagerPackage;

import Java_Assignment.Session;
import ProjManagerPackage.AccMgmtElem.TableActionCellRender_AccTbl;
import ProjManagerPackage.AccMgmtElem.TableHeader_AccTbl;
import ProjManagerPackage.AssignSupvElem.LectData_IO;
import ProjManagerPackage.StuAssesElem.ModernScrollBarUI;
import ProjManagerPackage.StuAssesElem.TableActionCellEditor_EditButton;
import Lecturer_Package.Lecturer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ProjManagerPackage.StuAssesElem.TableActionEvent_EditButton;


public class AccMgmtTab_LectAcc extends javax.swing.JPanel {

    private ProjManager_MainFrame mainFrame;
    
    public AccMgmtTab_LectAcc(ProjManager_MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        
        //Customize Table Modification
        /* Set the scrollbar to customize scrollbar*/
        fixTable(jScrollPane1);
        
        /* Set the header to customize header */
        LectAccTable.getTableHeader().setReorderingAllowed(false);
        LectAccTable.getTableHeader().setResizingAllowed(false);
        LectAccTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader_AccTbl header = new TableHeader_AccTbl(o + "");
                return header;
            }
        });

        
        //Insert data into table
        for (Lecturer lect :LectData_IO.LectData){
            if (lect.isProjectManager == false) {
                String LectName = lect.lectName;
            String LectID = lect.lectid;

            Object[] InsertRow = {LectName, LectID};

            DefaultTableModel model = (DefaultTableModel) LectAccTable.getModel();
            model.addRow(InsertRow);
            }
        }
        
        
        /*Set the edit button and its function*/
        TableActionEvent_EditButton event = new TableActionEvent_EditButton() {
            @Override
            public void onEdit(int row) {
                //Get the student id of selected student
                String selectedLectID = (String) LectAccTable.getValueAt(row, 1);
                mainFrame.dispose();
                
                AccMgmtFrame_EditLect editPage = new AccMgmtFrame_EditLect(selectedLectID);
                editPage.setVisible(true);
            }
        };
        
        //Insert edit button into table
        LectAccTable.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender_AccTbl());
        LectAccTable.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor_EditButton(event));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        LectAccTable = new javax.swing.JTable();
        TabTitle = new javax.swing.JLabel();
        btbBack = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LectAccTable.setBackground(new java.awt.Color(236, 236, 236));
        LectAccTable.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        LectAccTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Lecturer ID", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        LectAccTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LectAccTable.setRowHeight(40);
        jScrollPane1.setViewportView(LectAccTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 100, 886, 430));

        TabTitle.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        TabTitle.setText("Lecturer Account");
        add(TabTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        btbBack.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        btbBack.setForeground(new java.awt.Color(0, 0, 0));
        btbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/leftArrow(Black).png"))); // NOI18N
        btbBack.setText("Back...");
        btbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbBackMouseClicked(evt);
            }
        });
        add(btbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbBackMouseClicked
        mainFrame.changedTab(5);
    }//GEN-LAST:event_btbBackMouseClicked

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
    private javax.swing.JTable LectAccTable;
    private javax.swing.JLabel TabTitle;
    private javax.swing.JLabel btbBack;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
