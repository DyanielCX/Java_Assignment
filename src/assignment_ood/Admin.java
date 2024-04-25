package assignment_ood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Admin extends javax.swing.JFrame {
    private javax.swing.JPanel AdminPane;

    private javax.swing.JTable lecturePanal;
    
    private List<Lecturer> lecturers;

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        lecturers = new ArrayList<>();
        loadLecturersFromFile();
    }

    private void loadLecturersFromFile() {
        ArrayList<String[]> data = readLecturerDataFromFile();
        for (String[] row : data) {
            String name = row[0];
            String id = row[1];
            boolean isProjectManager = Boolean.parseBoolean(row[2]);
            lecturers.add(new Lecturer(name, id, isProjectManager));
        }
    }

    public void registerLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
        saveLecturersToFile();
    }

    public void amendLecturerDetails(String name, String newLecturerId, boolean newIsProjectManager) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getName().equals(name)) {
                lecturer.setId(newLecturerId);
                lecturer.setIsProjectManager(newIsProjectManager);
                break;
            }
        }
        saveLecturersToFile();
    }

    public void removeLecturer(String name) {
        lecturers.removeIf(lecturer -> lecturer.getName().equals(name));
        saveLecturersToFile();
    }

    public ArrayList<String[]> readLecturerDataFromFile() {
        ArrayList<String[]> lecturerData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("lecturers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                lecturerData.add(parts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lecturerData;
    }

    private void saveLecturersToFile() {
        try (FileWriter writer = new FileWriter("lecturers.txt")) {
            for (Lecturer lecturer : lecturers) {
                writer.write(lecturer.getName() + "," + lecturer.getId() + "," + lecturer.isIsProjectManager() + "\n");
            }
            System.out.println("Lecturer data saved to file.");
        } catch (IOException e) {
            System.err.println("Error writing to lecturers file: " + e.getMessage());
        }
    }

    private void initComponents() {
        AdminPane = new javax.swing.JPanel();  // Initialize AdminPane here
        jScrollPane1 = new javax.swing.JScrollPane();
        lecturePanal = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lecturePanal.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Name", "ID", "Is Project Manager"
                }
        ));

        jScrollPane1.setViewportView(lecturePanal);

        javax.swing.GroupLayout AdminPaneLayout = new javax.swing.GroupLayout(AdminPane);
        AdminPane.setLayout(AdminPaneLayout);
        AdminPaneLayout.setHorizontalGroup(
                AdminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AdminPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                .addContainerGap())
        );
        AdminPaneLayout.setVerticalGroup(
                AdminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AdminPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                .addContainerGap())
        );

        getContentPane().add(AdminPane, java.awt.BorderLayout.CENTER);  // Add AdminPane to the frame's content pane

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
   
    private javax.swing.JScrollPane jScrollPane1;
   
    // End of variables declaration                   
}
