package Java_Assignment;

import ProjManagerPackage.AssignSupvElem.LectData_IO;
import ProjManagerPackage.MainFrame;
import StuPackage.StuData_IO;
import assignment_ood.Lect_Dashboard;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import assignment_ood.Lecture_mainframe;
public class LoginPage extends javax.swing.JFrame {
    private String UsernameInput; // Declare as an instance variable
    private String PasswordInput; // Declare as an instance variable
    public LoginPage() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        LoginBtn = new javax.swing.JButton();
        Username_input = new javax.swing.JTextField();
        Password_input = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(85, 128, 214));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginBtn.setBackground(new java.awt.Color(255, 255, 255));
        LoginBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(0, 0, 0));
        LoginBtn.setText("Login");
        LoginBtn.setBorder(null);
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(LoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 62, 29));

        Username_input.setBackground(new java.awt.Color(255, 255, 255));
        Username_input.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(Username_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 130, 30));

        Password_input.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Password_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 130, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 80, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 65, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 67, 33));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo(White).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 160, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LoginPic.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
         // Get the username and password input from the text fields
    String username = Username_input.getText();
    String password = Password_input.getText();
    
    // Call the authenticateUser method to validate the credentials
    boolean isSupervisor = false;
    String role = authenticateUser(username, password);
    
    
    if (role != null) {
        // If credentials are valid, redirect to the appropriate dashboard
         Session.setUsername(username);
        redirectToDashboard(username, password, role);
        // Close the login window or do any other necessary action
        dispose();
    } else {
        // If credentials are invalid, show an error message
        JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true); // Show the new window
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked
    
    public static String authenticateUser(String username, String password) {
        // Array to hold the filenames for each role
        String[] roleFiles = {"LecData.txt","StuData.txt"};

        // Loop through each role file
        for (String file : roleFiles) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    String role = file.substring(0, file.indexOf('.'));
                    
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        role = role.trim();
                        if (role.equals("LecData")){
                        boolean isSupervisor = Boolean.parseBoolean(parts[2]);
                           if (isSupervisor) { // Check if isSupervisor is true
            role = "ProjectMgn"; // Change the role to ProjectMgn
            return role;
        }
                        }return  role.trim();
                   }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null; // User not found or invalid credentials
    }

    public static void redirectToDashboard(String username, String password, String role) {
        switch (role) {
            case "StuData":
                StuPackage.Student_MainFrame studentAcc= new StuPackage.Student_MainFrame(username, password);
                studentAcc.setVisible(true);
                break;
            case "LecData":
                Lecture_mainframe lect= new Lecture_mainframe();
                lect.setVisible(true);
                break;
            case "ProjectMgn":
                  MainFrame fr = new MainFrame();
                  fr.setVisible(true);
                  break;
                  
            case "admin":
                System.out.println("Redirecting to admin dashboard...");
                // Redirect logic for admin dashboard
                break;
            default:
                System.out.println("Invalid role.");
        }
    }
    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Clear the session
    Session.clearSession();

   
    LoginPage loginPage = new LoginPage();
    loginPage.setVisible(true);
    this.dispose(); // Close the current window
}
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StuData_IO.readFrTxt();
                LectData_IO.readFrTxt();
                new LoginPage().setVisible(true);
            }
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JTextField Password_input;
    private javax.swing.JTextField Username_input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
