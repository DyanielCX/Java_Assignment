package Lecturer_Package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import AdminPackage.addLect;
import java.io.BufferedWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Lecturer_Package.presentationReq;
import java.util.Arrays;
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
    public static boolean lecturerExists(String lecturerId) {
    try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 2 && parts[1].equals(lecturerId)) {
                return true; // Lecturer with the same ID already exists
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    }
    return false; // Lecturer with the given ID does not exist
}
   public static void deleteLecturerFromFile(String lecturerName, String lecturerId, boolean isProjectManager,boolean isSupervisor,boolean isSecondMarker,String password) {
    // Read all lines from the file into a list
    java.util.List<String> lines = new java.util.ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                if (!lecturerId.equals(parts[1])) {
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

  public static List<Lecturer> readLecturersFromFile(String filename) {
        List<Lecturer> lecturers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String lecturerName = parts[0];
                    String lecturerId = parts[1];
                    boolean isProjectManager = Boolean.parseBoolean(parts[2]);
                    
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
public static void refreshStudentStatus(String studentID) {
    try {
  
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("PresentationData.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

    
      for (int i = 0; i < lines.size(); i++) {
    String[] parts = lines.get(i).split(",");
    if (parts[0].trim().equals(studentID)) {
        if (parts.length >= 10) {
            String supervisorStatus = parts[8].trim();
            String secondMarkerStatus = parts[9].trim();
            String studentStatus;

            if (supervisorStatus.equalsIgnoreCase("Rejected") || secondMarkerStatus.equalsIgnoreCase("Rejected")) {
                studentStatus = "Rejected";
            } else if (secondMarkerStatus.equalsIgnoreCase("Accepted") && supervisorStatus.equalsIgnoreCase("Accepted")) {
                studentStatus = "Accepted";
            } else if (secondMarkerStatus.equalsIgnoreCase("Accepted") && supervisorStatus.equalsIgnoreCase("pending")) {
                studentStatus = "Half Accepted";
            } else {
                studentStatus = "Pending";
            }

            parts[5] = studentStatus;
            lines.set(i, String.join(",", parts));
            break;
        }
    }
}

        // Write the updated lines back to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter("PresentationData.txt"));
        for (String updatedLine : lines) {
            writer.write(updatedLine);
            writer.newLine();
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating student status in file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
public static void updateStatusInFile(String studentID, String newStatus, String reason, String role) {
    try {
        // Read all lines from the file into a list
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("PresentationData.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

       
        boolean studentFound = false; // Flag to track if the student is found
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts[0].trim().equals(studentID)) {
                studentFound = true;
                if (parts.length >= 10) { 
                    if (role.equals("supervisor")) {
                        parts[8] = newStatus; // Update Supervisor Status column
                    } else if (role.equals("second_marker")) {
                        parts[9] = newStatus; // Update Second Marker Status column
                    }
                    parts[6] = reason; // Set the reject reason

                    // Determine student status based on supervisor and second marker statuses
                    String supervisorStatus = parts[8].trim();
                    String secondMarkerStatus = parts[9].trim();
                    String studentStatus;

                    if (supervisorStatus.equalsIgnoreCase("Rejected") || secondMarkerStatus.equalsIgnoreCase("Rejected")) {
                        studentStatus = "Rejected";
                    } else if (supervisorStatus.equalsIgnoreCase("Accepted") && secondMarkerStatus.equalsIgnoreCase("Accepted")) {
                        studentStatus = "Accepted";
                    } else if (supervisorStatus.equalsIgnoreCase("Accepted") && secondMarkerStatus.equalsIgnoreCase("Pending")) {
                        studentStatus = "Half Accepted";
                    } else {
                        studentStatus = "Pending";
                    }

                    parts[5] = studentStatus; 
                    lines.set(i, String.join(",", parts)); 
                    break; 
                }
            }
        }

        // Write the updated lines back to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter("PresentationData.txt"));
        for (String updatedLine : lines) {
            writer.write(updatedLine);
            writer.newLine();
        }
        writer.close();
           refreshStudentStatus(studentID);
           
        if (!studentFound) {
            System.err.println("Student ID " + studentID + " not found in the file.");
        } else {
            System.out.println("Student ID " + studentID + " status updated successfully.");
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating status in file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public  void populateDashBoardTable(JTable AssignedStuTbl,String supervisor) {
     DefaultTableModel tableModel = (DefaultTableModel) AssignedStuTbl.getModel();
    tableModel.setRowCount(0); 

    try (BufferedReader reader = new BufferedReader(new FileReader("StuData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            
            String[] parts = line.split(",");

            
           if (parts.length >= 9 && parts[6].trim().equalsIgnoreCase(supervisor)) {

    tableModel.addRow(new Object[]{parts[0], parts[2],parts[4],parts[5],parts[6],parts[7],parts[8]});
}
        }
    } catch (IOException e) {
        e.printStackTrace();
        
    }

}
public static void updateStatusInConsult(int row, String newStatus) {
    try {
        // Read all lines from the file into a list
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("ConsultationData.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        // Update the status in the corresponding line
        if (row < lines.size()) {
            String[] parts = lines.get(row).split(",");
            if (parts.length >= 6) { // Ensure you have enough columns for status
                parts[5] = newStatus; // Update status column
                lines.set(row, String.join(",", parts)); // Join the parts back into a line
            }
        }

        // Write the updated lines back to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter("ConsultationData.txt"));
        for (String updatedLine : lines) {
            writer.write(updatedLine);
            writer.newLine();
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating status in file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
public static List<Lecturer> readLectData(String filename) {
        List<Lecturer> lecturers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("LecData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String name = parts[0];
                    String password = parts[5];
                    String lectid = parts[1];
                    boolean isProjectManager = Boolean.parseBoolean(parts[2]);
                    boolean isSecondMarker = Boolean.parseBoolean(parts[4]);
                    boolean isSupervisor = Boolean.parseBoolean(parts[3]);
                    lecturers.add(new Lecturer(name, lectid, isProjectManager, isSecondMarker, isSupervisor,password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lecturers;
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
