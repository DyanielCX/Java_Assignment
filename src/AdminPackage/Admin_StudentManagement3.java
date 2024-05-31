package AdminPackage;

import AdminPackage.TableElement.TableActionCellEditor;
import AdminPackage.TableElement.TableActionCellRender;
import AdminPackage.TableElement.TableActionEvent;
import ProjManagerPackage.StuAssesElem.ModernScrollBarUI;
import ProjManagerPackage.StuAssesElem.TableHeader;
import StuPackage.StuData_IO;
import StuPackage.Student;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Admin_StudentManagement3 extends javax.swing.JPanel {
    
    private Admin_MainFrame mainFrame;

    public Admin_StudentManagement3(Admin_MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        
        fixTable(jScrollPane1);
        
        /* Set the header to customize header */
        StudentList.getTableHeader().setReorderingAllowed(false);
        StudentList.getTableHeader().setResizingAllowed(false);
        StudentList.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
             @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(o + "");
                return header;
            }
        });
        
        StudentList.setRowHeight(40);
    
        loadDataFromFile(); // Load data from file when the form is created
        
         /*Set the edit button and its function*/
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
            String studentID = (String) StudentList.getValueAt(row, 0); // Get student ID from the clicked row
    
            // Get all the student details
            String name = (String) StudentList.getValueAt(row, 1);
            int age = (int) StudentList.getValueAt(row, 2);
            String intake = (String) StudentList.getValueAt(row, 3);
            String assessment = (String) StudentList.getValueAt(row, 4);
            String supervisor = (String) StudentList.getValueAt(row, 5);
            String secondMarker = (String) StudentList.getValueAt(row, 6);
            String RMCP_lecture = (String) StudentList.getValueAt(row, 7);

            // Create an instance of Admin_EditStudent and pass the student details
            Admin_EditStudent editStudentFrame = new Admin_EditStudent(studentID, name, age, intake, assessment, supervisor, secondMarker, RMCP_lecture);
            editStudentFrame.setVisible(true);
            mainFrame.dispose(); // Close the current frame
        }  
            @Override
            public void onDelete(int row) {           
               String studentID = (String) StudentList.getValueAt(row, 0); // Get student ID from the clicked row
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?", "Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        StuData_IO.remove(studentID); // Remove the student from the data source
                        loadDataFromFile(); // Reload the table data
                        JOptionPane.showMessageDialog(null, "Student deleted successfully.", "Delete", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error deleting student: " + e.getMessage(), "Delete", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            
        };
        
        //Insert edit button into table
        StudentList.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
        StudentList.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));
    }
    
    private void loadDataFromFile() {
        DefaultTableModel model = (DefaultTableModel) StudentList.getModel();
        model.setRowCount(0);
        for (Student student : StuData_IO.StuData) {
            model.addRow(new Object[]{
                student.id, student.name, student.age, student.intake,
                student.assessment, student.supervisor, student.secondMarker,student.RMCP_lecture
            });
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
        StudentList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        StuID_txtfield = new javax.swing.JTextField();
        Search_btn = new javax.swing.JButton();
        Add_btn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        StudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Intake", "Assessment", "Supervisor", "Sec Marker", "RMCP", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentList.setRowHeight(40);
        jScrollPane1.setViewportView(StudentList);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 148, 148));

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student ID:");

        StuID_txtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StuID_txtfieldActionPerformed(evt);
            }
        });

        Search_btn.setBackground(new java.awt.Color(252, 188, 188));
        Search_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search_btn.setForeground(new java.awt.Color(255, 255, 255));
        Search_btn.setText("Search");
        Search_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 148, 148), 4, true));
        Search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_btnActionPerformed(evt);
            }
        });

        Add_btn.setBackground(new java.awt.Color(252, 188, 188));
        Add_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Add_btn.setForeground(new java.awt.Color(255, 255, 255));
        Add_btn.setText("Add");
        Add_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 148, 148), 4, true));
        Add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StuID_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(Search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(StuID_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_btn))
                .addGap(38, 38, 38))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void StuID_txtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StuID_txtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StuID_txtfieldActionPerformed

    private void Search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_btnActionPerformed
        String searchID = StuID_txtfield.getText(); // Get the student ID from the text field

        try {
            DefaultTableModel model = (DefaultTableModel) StudentList.getModel();
            int index = StuData_IO.checkStu(searchID); // Get the index of the student
            Student student = StuData_IO.StuData.get(index); // Get the student from the ArrayList
            model.setRowCount(0); // Clear the table
            model.addRow(new Object[] {
                student.id, student.name, student.age, student.intake,
                student.assessment, student.supervisor, student.secondMarker
            });
        } catch (IllegalArgumentException e) {
            // Display message if student ID is not found
            JOptionPane.showMessageDialog(this, e.getMessage(), "Search", JOptionPane.INFORMATION_MESSAGE);
            // Reload the entire table when student is not found
            loadDataFromFile();
        }
    }//GEN-LAST:event_Search_btnActionPerformed

    private void Add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_btnActionPerformed
        Admin_AddStudent addStudentFrame = new Admin_AddStudent();
        addStudentFrame.setVisible(true);
        mainFrame.dispose(); // Close the current frame
    }//GEN-LAST:event_Add_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_btn;
    private javax.swing.JButton Search_btn;
    private javax.swing.JTextField StuID_txtfield;
    private javax.swing.JTable StudentList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
