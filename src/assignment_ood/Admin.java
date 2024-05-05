package assignment_ood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import assignment_ood.addLect;
import java.io.BufferedWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import assignment_ood.presentationReq;
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
            if (parts.length >= 6) {
                String lecturerName = parts[0];
                String lecturerId = parts[1];
                boolean isProjectManager = Boolean.parseBoolean(parts[2]);
                // Set isSupervisor and isSecondMarker to false
                boolean isSupervisor = false;
                boolean isSecondMarker = false;
                String password = parts[5];
                model.addRow(new Object[]{lecturerName, lecturerId, isProjectManager,password});
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
            if (parts.length >= 6) {
                String lecturerName = parts[0];
                String lecturerId = parts[1];
                boolean isProjectManager = Boolean.parseBoolean(parts[2]);
                // Set isSupervisor and isSecondMarker to false
                boolean isSupervisor = false;
                boolean isSecondMarker = false;
                String password = parts[5];
                model.addRow(new Object[]{lecturerName, lecturerId, isProjectManager,password});
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    }
}
    
    
    public static void saveLecturersToFile(String lecturerName, String lecturerId, boolean isProjectManager, boolean isSecondMarker, boolean isSupervisor,String password) {
    try (FileWriter writer = new FileWriter("LecData.txt", true)) { // Use true as the second parameter to append to the file
        writer.write(lecturerName + "," + lecturerId + "," + isProjectManager +"," + isSecondMarker +","+ isSupervisor + ","+ password +"\n");
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    }  
    
   public static void deleteLecturerFromFile(String lecturerName, String lecturerId, boolean isProjectManager,boolean isSupervisor,boolean isSecondMarker,String password) {
    // Read all lines from the file into a list
    java.util.List<String> lines = new java.util.ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                if (!lecturerName.equals(parts[0]) || !lecturerId.equals(parts[1]) || isProjectManager != Boolean.parseBoolean(parts[2])|| isSupervisor != Boolean.parseBoolean(parts[3])|| isSecondMarker != Boolean.parseBoolean(parts[4]) || !password.equals(parts[5])) {
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


    public static void updateLecturerInFile(JTable lecturerTable, String lecturerName, String lecturerId, boolean isProjectManager, boolean isSecondMarker, boolean isSupervisor, String password, int selectedIndex) {
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
    String updatedLine = lecturerName + "," + lecturerId + "," + isProjectManager + "," + isSecondMarker + "," + isSupervisor + "," + password;
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

  public static List<Lecturer> readLecturersFromFile() {
        List<Lecturer> lecturers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String lecturerName = parts[0];
                    String lecturerId = parts[1];
                    boolean isProjectManager = Boolean.parseBoolean(parts[2]);
                    // Set isSupervisor and isSecondMarker to false
                    boolean isSupervisor = false;
                    boolean isSecondMarker = false;
                    String password = parts[5];
                    Lecturer lecturer = new Lecturer(lecturerName, lecturerId, isProjectManager, isSecondMarker, isSupervisor,password);
                    lecturers.add(lecturer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
        return lecturers;
    }   

     public static void updateStatusInFile(int row, String newStatus) {
    try {
        // Read all lines from the file into a list
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("presentation_data.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        // Update the status in the corresponding line
       if (row < lines.size()) {
      String[] parts = lines.get(row).split(",");
      if (parts.length >= 4) {
        parts[3] = newStatus;
        lines.set(row, String.join(",", parts));
      }
    }

    // Write the updated lines with explicit flush
    BufferedWriter writer = new BufferedWriter(new FileWriter("presentation_data.txt"));
    for (String updatedLine : lines) {
      writer.write(updatedLine);
      writer.newLine();
    }
    writer.flush(); // Flush the buffer before closing
    writer.close();
  } catch (IOException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating status in file.", "Error", JOptionPane.ERROR_MESSAGE);
  }

 
    
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
