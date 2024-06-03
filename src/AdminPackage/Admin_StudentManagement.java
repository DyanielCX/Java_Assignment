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


public class Admin_StudentManagement extends javax.swing.JPanel {
    
    private Admin_MainFrame mainFrame;

    public Admin_StudentManagement(Admin_MainFrame mainFrame) {
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
            Admin_EditStudent editStudentFrame = new Admin_EditStudent(studentID, name, age, intake);
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

        jLabel1 = new javax.swing.JLabel();
        StuID_txtfield = new javax.swing.JTextField();
        Search_btn = new javax.swing.JButton();
        Add_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentList = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 148, 148));
        setPreferredSize(new java.awt.Dimension(909, 518));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student ID:");

        Search_btn.setBackground(new java.awt.Color(252, 188, 188));
        Search_btn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Search_btn.setForeground(new java.awt.Color(255, 255, 255));
        Search_btn.setText("Search");
        Search_btn.setBorder(null);
        Search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_btnActionPerformed(evt);
            }
        });

        Add_btn.setBackground(new java.awt.Color(252, 188, 188));
        Add_btn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Add_btn.setForeground(new java.awt.Color(255, 255, 255));
        Add_btn.setText("Add");
        Add_btn.setBorder(null);
        Add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_btnActionPerformed(evt);
            }
        });

        StudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Age", "Intake", "Assessment", "Supervisor", "Sec Marker", "RMCP", "Action"
            }
        ));
        jScrollPane1.setViewportView(StudentList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StuID_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(Search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(StuID_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Search_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Add_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_btnActionPerformed
        Admin_AddStudent addStudentFrame = new Admin_AddStudent();
        addStudentFrame.setVisible(true);
        mainFrame.dispose();
    }//GEN-LAST:event_Add_btnActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_btn;
    private javax.swing.JButton Search_btn;
    private javax.swing.JTextField StuID_txtfield;
    private javax.swing.JTable StudentList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
