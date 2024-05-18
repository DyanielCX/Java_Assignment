package AdminPackage;

import AdminPackage.TableElement.TableActionCellEditor;
import AdminPackage.TableElement.TableActionCellRender;
import AdminPackage.TableElement.TableActionEvent;
import StuPackage.StuData_IO;
import StuPackage.Student;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Admin_Student extends javax.swing.JFrame {
            
    public Admin_Student() {
        initComponents();
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
            dispose(); // Close the current frame
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

     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        StuID_txtfield = new javax.swing.JTextField();
        Search_btn = new javax.swing.JButton();
        Add_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StudentList.setBackground(new java.awt.Color(153, 204, 255));
        StudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Age", "Intake", "Assessment", "Supervisor", "Second Marker", "RMCP", "Action"
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
        if (StudentList.getColumnModel().getColumnCount() > 0) {
            StudentList.getColumnModel().getColumn(0).setResizable(false);
            StudentList.getColumnModel().getColumn(1).setResizable(false);
            StudentList.getColumnModel().getColumn(2).setResizable(false);
            StudentList.getColumnModel().getColumn(3).setResizable(false);
            StudentList.getColumnModel().getColumn(4).setResizable(false);
            StudentList.getColumnModel().getColumn(5).setResizable(false);
            StudentList.getColumnModel().getColumn(6).setResizable(false);
            StudentList.getColumnModel().getColumn(7).setResizable(false);
            StudentList.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setText("Student ID:");

        StuID_txtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StuID_txtfieldActionPerformed(evt);
            }
        });

        Search_btn.setText("Search");
        Search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_btnActionPerformed(evt);
            }
        });

        Add_btn.setText("Add");
        Add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StuID_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Search_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Add_btn)
                .addGap(177, 177, 177))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(StuID_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search_btn)
                    .addComponent(Add_btn))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
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
        this.dispose(); // Close the current frame
    }//GEN-LAST:event_Add_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StuData_IO.readFrTxt();
                new Admin_Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_btn;
    private javax.swing.JButton Search_btn;
    private javax.swing.JTextField StuID_txtfield;
    private javax.swing.JTable StudentList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
