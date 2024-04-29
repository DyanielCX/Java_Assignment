package assignment_ood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import assignment_ood.addLect;
import javax.swing.JTable;

public class Admin extends javax.swing.JFrame {
    private javax.swing.JPanel AdminPane;

    private javax.swing.JTable lecturePanal;
    
    private List<Lecturer> lecturers;

    /**
     * Creates new form Admin
     */
    public Admin(JTable lecturerTable) {
        
        lecturers = new ArrayList<>();
       
    }

    public static void loadLecturersFromFile(JTable lecturerTable) {
    DefaultTableModel model = (DefaultTableModel) lecturerTable.getModel();
    model.setRowCount(0); 

    try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                String lecturerName = parts[0];
                String lecturerId = parts[1];
                boolean isProjectManager = Boolean.parseBoolean(parts[2]);
                // Set isSupervisor and isSecondMarker to false
                boolean isSupervisor = false;
                boolean isSecondMarker = false;
                model.addRow(new Object[]{lecturerName, lecturerId, isProjectManager});
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    }
}
    
    public static void loadLecturerpanalFromFile(JTable lecturePanal) {
    DefaultTableModel model = (DefaultTableModel) lecturePanal.getModel();
    model.setRowCount(0); 

    try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                String lecturerName = parts[0];
                String lecturerId = parts[1];
                boolean isProjectManager = Boolean.parseBoolean(parts[2]);
                // Set isSupervisor and isSecondMarker to false
                boolean isSupervisor = false;
                boolean isSecondMarker = false;
                model.addRow(new Object[]{lecturerName, lecturerId, isProjectManager});
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    }
}
    
    
    public static void saveLecturersToFile(String lecturerName, String lecturerId, boolean isProjectManager, boolean isSecondMarker, boolean isSupervisor) {
    try (FileWriter writer = new FileWriter("LecData.txt", true)) { // Use true as the second parameter to append to the file
        writer.write(lecturerName + "," + lecturerId + "," + isProjectManager +"," + isSecondMarker +","+ isSupervisor + "\n");
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    }  
    
   public static void deleteLecturerFromFile(String lecturerName, String lecturerId, boolean isProjectManager,boolean isSupervisor,boolean isSecondMarker) {
    // Read all lines from the file into a list
    java.util.List<String> lines = new java.util.ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                if (!lecturerName.equals(parts[0]) || !lecturerId.equals(parts[1]) || isProjectManager != Boolean.parseBoolean(parts[2])|| isSupervisor != Boolean.parseBoolean(parts[3])|| isSecondMarker != Boolean.parseBoolean(parts[4])) {
                    lines.add(line);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Write the updated lines back to the file
    try (FileWriter writer = new FileWriter("LecData.txt")) {
        for (String line : lines) {
            writer.write(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public static void updateLecturerInFile(JTable lecturerTable,String lecturerName, String lecturerId, boolean isProjectManager,boolean isSecondMarker, boolean isSupervisor) {
    // Read all lines from the file into a list
    java.util.List<String> lines = new java.util.ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    } catch (IOException e) {
        
        e.printStackTrace();
    }

    // Update the selected lecturer's details
    String updatedLine = lecturerName + "," + lecturerId + "," + isProjectManager;
    int selectedIndex = lecturerTable.getSelectedRow();
    if (selectedIndex != -1 && selectedIndex < lines.size()) {
        lines.set(selectedIndex, updatedLine);
    }

    // Write the updated lines back to the file
    try (FileWriter writer = new FileWriter("LecData.txt")) {
        for (String line : lines) {
            writer.write(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Refresh the table to reflect the changes
   Admin.loadLecturersFromFile(lecturerTable);
}

    

    

   

    public static void main(String args[]) {
        JTable lecturerTable = new JTable();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin(lecturerTable).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
   
    private javax.swing.JScrollPane jScrollPane1;
   
    // End of variables declaration                   
}
